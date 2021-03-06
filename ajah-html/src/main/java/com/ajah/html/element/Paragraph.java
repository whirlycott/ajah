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
package com.ajah.html.element;

import java.io.IOException;
import java.io.Writer;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * p element
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Paragraph extends AbstractNestableHtmlCoreElement<Paragraph> {

	private String text;

	/**
	 * Returns "paragraph"
	 * 
	 * @see com.ajah.html.element.AbstractNestableHtmlCoreElement#getName()
	 */
	@Override
	public String getName() {
		return "p";
	}

	@Override
	public
	Paragraph getThis() {
		return this;
	}

	@Override
	protected void renderBeforeChildren(Writer out) throws IOException {
		out.write(this.text);
	}

	/**
	 * Fluent alias to {@link #setText(String)}.
	 * 
	 * @param newText
	 *            The text to set.
	 * @return The current instance.
	 */
	public Paragraph text(String newText) {
		this.setText(newText);
		return this;
	}

}
