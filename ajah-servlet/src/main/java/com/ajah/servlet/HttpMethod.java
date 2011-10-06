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
package com.ajah.servlet;

import com.ajah.util.Identifiable;

/**
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 * 
 */
public enum HttpMethod implements Identifiable<String> {

	GET("2"), POST("5"), DELETE("1"), HEAD("3"), OPTIONS("4"), PUT("6"), TRACE("7");

	private String id;

	private HttpMethod(String id) {
		this.id = id;
	}

	/**
	 * @param method
	 * @return
	 */
	public static HttpMethod get(String method) {
		for (HttpMethod candidate : values()) {
			if (candidate.name().equals(method)) {
				return candidate;
			}
		}
		return null;
	}

	/**
	 * @see com.ajah.util.Identifiable#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * @see com.ajah.util.Identifiable#setId(java.lang.Comparable)
	 */
	@Override
	public void setId(String id) {
		throw new UnsupportedOperationException();
	}

}