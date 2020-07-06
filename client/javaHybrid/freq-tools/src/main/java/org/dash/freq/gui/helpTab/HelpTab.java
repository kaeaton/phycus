package org.dash.freq.gui.helpTab;

import java.awt.Dimension;

import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.dash.freq.gui.ExitButton;


public class HelpTab extends JPanel {
	// private Preferences prefs = Preferences.userNodeForPackage(Gui.class);

	public HelpTab() {
		JLabel selectAllLabelGfe = new JLabel("Check all");
		this.add(selectAllLabelGfe);

		JPanel bottomButtons = new JPanel();
		JButton exitButton = new ExitButton().getExitButton();
		bottomButtons.add(exitButton);

		this.add(bottomButtons);
	}

}