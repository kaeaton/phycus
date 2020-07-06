package org.dash.freq.gui.optionsTab.advanced.databaseLocationPopup;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DatabaseLocationPopup extends JFrame {

	public DatabaseLocationPopup() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(360, 300));
		this.setAlwaysOnTop(true);
		this.setVisible(false);

		this.pack();
		this.setLocationRelativeTo(null);
	}
}