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
package com.ajah.user.message;

import java.io.Serializable;

/**
 * A wrapper around a String for typesafe message IDs.
 * 
 * @author Eric F. Savage <code@efsavage.com>
 * 
 */
public class MessageId implements Serializable {

	private static final long serialVersionUID = -8938358157550623613L;

	private final String id;

	/**
	 * Simple string constructor.
	 * 
	 * @param id
	 *            UID of user, cannot be null.
	 */
	public MessageId(String id) {
		this.id = id;
	}

	/**
	 * Returns the String passed into the constructor.
	 * 
	 * @return The String passed into the constructor.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Returns the String passed into the constructor.
	 */
	@Override
	public String toString() {
		return this.id;
	}

}