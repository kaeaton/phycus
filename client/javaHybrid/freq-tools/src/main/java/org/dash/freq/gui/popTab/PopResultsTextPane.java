package org.dash.freq.gui.popTab;

import java.awt.Font;

import javax.swing.JTextPane;

public class PopResultsTextPane {

	private JTextPane popResultsTextPane = new JTextPane();

	public PopResultsTextPane() { }

	public JTextPane getPopResultsTextPane() {
		popResultsTextPane.setFocusable(true);
		popResultsTextPane.setFont(new Font("Courier New", 0, 13));

		return popResultsTextPane;

	}
}