/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.odometer.client;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

/**
 * base odometer options
 */
public class BaseOdometerOptions extends JsObject {

	public BaseOdometerOptions() {
		jsObj = JsoHelper.createObject();
	}

	/**
	 * Change how digit groups are formatted, and how many digits are shown
	 * after the decimal point.
	 * <p>
	 * 
	 * <pre>
	 * Format    -  Example
	 * (,ddd)    -  12,345,678
	 * (,ddd).dd -  12,345,678.09
	 * (.ddd),dd -  12.345.678,09
	 * ( ddd),dd -  12 345 678,09
	 * d         -  12345678
	 * </pre>
	 */
	public void setFormat(String value) {
		JsoHelper.setAttribute(jsObj, "format", value);
	}

	/**
	 * Change how long the javascript expects the CSS animation to take
	 */
	public void setDuration(double value) {
		JsoHelper.setAttribute(jsObj, "duration", value);
	}

	/**
	 * Specify the theme (if you have more than one theme css file on the page)
	 */
	public void setTheme(String value) {
		JsoHelper.setAttribute(jsObj, "theme", value);
	}

	/**
	 * Count is a simpler animation method which just increments the value, use
	 * it when you're looking for something more subtle.
	 */
	public void setAnimation(String value) {
		JsoHelper.setAttribute(jsObj, "animation", value);
	}
}
