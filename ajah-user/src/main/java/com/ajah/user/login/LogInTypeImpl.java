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
package com.ajah.user.login;

/**
 * Basic implementations of LoginSource.
 * 
 * @author Eric F. Savage <code@efsavage.com>
 * 
 */
public enum LogInTypeImpl implements LogInType {

	/**
	 * Manual logins
	 */
	MANUAL("1", "manual", "Manual", "Manual login, by a human", true),
	/**
	 * Cookie logins
	 */
	COOKIE("2", "cookie", "Cookie", "Automatic cookie login", false),
	/**
	 * Login that occurs as part of signup
	 */
	SIGNUP("3", "signup", "Sign Up", "Logged in by signing up", true);

	private final String id;

	private final String code;

	private final String name;

	private final String description;

	private final boolean manual;

	private LogInTypeImpl(final String id, final String code, final String name, final String description, final boolean manual) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.manual = manual;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isManual() {
		return this.manual;
	}

}
