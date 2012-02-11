/*
 *  Copyright 2011 Eric F. Savage, code@efsavage.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.ajah.log.http.servlet.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.ajah.log.http.RequestEventHandler;
import com.ajah.log.http.request.RequestEvent;
import com.ajah.log.http.request.data.RequestEventManager;
import com.ajah.servlet.AjahFilter;
import com.ajah.util.AjahUtils;

/**
 * Logs HTTP requests.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 * 
 */
@Service
public class AccessLoggerFilter extends AjahFilter {

	private static final Logger log = Logger.getLogger(AccessLoggerFilter.class.getName());

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired
	private RequestEventManager requestEventManager;

	/**
	 * Logs requests.
	 */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		RequestEvent requestEvent = new RequestEvent(request);
		request.setAttribute("ajahRequestEvent", requestEvent);
		try {
			chain.doFilter(request, response);
		} finally {
			requestEvent.complete();
			log.finest(requestEvent.getUri() + " took " + requestEvent.getDuration() + "ms");
			AjahUtils.requireParam(this.taskExecutor, "taskExecutor");
			this.taskExecutor.execute(new RequestEventHandler(requestEvent, this.requestEventManager));
		}
	}

}