package org.dash.freq.gui.popTab;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.dash.freq.gui.ExitButton;


public class PopTab extends JPanel {

	private PopTabClassInstantiations popTabClassInstantiations = PopTabClassInstantiations.getPopTabClassInstantiationsInstance();

	private JTextField popSearchTextField = popTabClassInstantiations.getPopSearchTextFieldInstance();
	private JTextPane popResultsTextPane = popTabClassInstantiations.getPopResultsTextPaneInstance();

	public PopTab() {
		JLabel selectAllLabelGfe = new JLabel("Check all");
		this.add(popSearchTextField);

		JPanel bottomButtons = new JPanel();
		JButton exitButton = new ExitButton().getExitButton();
		bottomButtons.add(exitButton);

		this.add(bottomButtons);
	}
}