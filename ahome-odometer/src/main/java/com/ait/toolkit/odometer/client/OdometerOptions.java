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

import com.ait.toolkit.core.client.JsoHelper;

/**
 * Global odometer options
 */
public class OdometerOptions extends BaseOdometerOptions {

	public OdometerOptions() {
		jsObj = JsoHelper.createObject();
	}

	/**
	 * Wheter or not everything with class 'odometer' should be initialized
	 */
	public void setAuto(boolean value) {
		JsoHelper.setAttribute(jsObj, "auto", value);
	}

	/**
	 * Change the selector used to automatically find things to be animated
	 */
	public void setSelector(String value) {
		JsoHelper.setAttribute(jsObj, "selector", value);
	}

}
