package org.dash.freq.utilities;

import java.net.URL;

public class Urls {

	public Urls() { }

	public static URL finalUrl(String urlString) {
		try {
			return new URL(urlString);
		} catch(Exception ex) {
			System.out.println("Error creating new URL (utilities.Urls): " + ex);
			throw new Error(ex);
		}
	}
}