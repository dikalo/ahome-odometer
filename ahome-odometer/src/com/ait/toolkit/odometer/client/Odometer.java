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

import com.ait.toolkit.core.client.CSSUtil;
import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.odometer.client.resources.OdometerResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.Window;

/**
 * Odometer class
 */
public class Odometer {

	private static final String THEME_PREFIX = "odometer-theme";
	private static final String VERSION = "0.4.6";
	private static final String RESOURCE_FOLDER = Util.getModuleBaseUrl() + "ahomeOdometer/";
	private JavaScriptObject odometerPeer;

	static {
		if (!isLoaded()) {
			addTheme(OdometerTheme.CAR);
			load();
		}
	}

	private Odometer(OdometerConfig config) {
		odometerPeer = createPeer(config.getJsObj());
	}

	public static native void init()/*-{
		$wnd.Odometer.init();
	}-*/;

	public static Odometer create(OdometerConfig config) {
		return new Odometer(config);
	}

	public native void update(double value)/*-{
		var peer = this.@com.ait.toolkit.odometer.client.Odometer::odometerPeer;
		if (peer != null) {
			peer.update(value);
		}

	}-*/;

	public native void render()/*-{
		var peer = this.@com.ait.toolkit.odometer.client.Odometer::odometerPeer;
		if (peer != null) {
			peer.render();
		}

	}-*/;

	/**
	 * Loads the odometer library. You normally never have to do this manually
	 */
	public static void load() {
		if (!isLoaded()) {
			OdometerResources resources = GWT.create(OdometerResources.class);
			ScriptInjector.fromString(resources.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		}
	}

	public static native void setGlobalOptions(OdometerOptions options)/*-{
		var peer = options.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		$wnd.odometerOptions = peer;
	}-*/;

	public static void addTheme(OdometerTheme theme) {
		Window.alert(GWT.getModuleBaseURL() + "," + GWT.getHostPageBaseURL() + "/" + GWT.getModuleName() + "ttt");
		String themeCss = THEME_PREFIX + "-" + theme.name().toLowerCase().replace("_", "-") + ".css";

		CSSUtil.injectStyleSheet(RESOURCE_FOLDER + VERSION + "/themes/" + themeCss);
	}

	public static native boolean isLoaded()/*-{
		if (typeof $wnd.odometerOptions === "undefined"
				|| $wnd.odometerOptions === null) {
			return false;
		}
		return true;
	}-*/;

	private native JavaScriptObject createPeer(JavaScriptObject options)/*-{
		return new $wnd.Odometer(options);
	}-*/;

}
