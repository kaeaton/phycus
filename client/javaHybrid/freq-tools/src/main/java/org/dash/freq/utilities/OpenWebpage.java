package org.dash.freq.utilities;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenWebpage {

	public OpenWebpage() { }

	// open links to external browser
	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
