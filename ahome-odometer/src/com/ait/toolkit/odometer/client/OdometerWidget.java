package com.ait.toolkit.odometer.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class OdometerWidget extends Widget {

	private Element el;
	private Odometer odometer;
	private OdometerTheme theme;

	public OdometerWidget() {
		this(0, OdometerTheme.DEFAULT);
	}

	public OdometerWidget(OdometerTheme theme) {
		this(0, theme);
	}

	public OdometerWidget(int initalValue) {
		this(initalValue, OdometerTheme.DEFAULT);
	}

	public OdometerWidget(int initalValue, OdometerTheme theme) {
		el = DOM.createDiv();
		setElement(el);
		update(initalValue);
		this.theme = theme;
		Odometer.addTheme(this.theme);
	}

	@Override
	public void onLoad() {
		Odometer.init();
		if (odometer == null) {
			OdometerConfig config = new OdometerConfig();
			config.setElement(el);
			config.setTheme(this.theme);
			odometer = Odometer.create(config);
		}
	}

	public void update(int value) {
		el.setInnerHTML(Integer.toString(value));
	}
}
