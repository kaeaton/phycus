package org.dash.freq.gui.popTab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class PopSearchTextField implements KeyListener {

	private JTextField popSearchTextField = new JTextField();

	public PopSearchTextField() { }

	public JTextField getPopSearchTextField() {
		popSearchTextField.setFocusable(true);
		popSearchTextField.setColumns(30);

		popSearchTextField.addKeyListener(this);

		return popSearchTextField;

	}

	public void keyReleased(KeyEvent evt) {											   
		String popSearchName = popSearchTextField.getText();
		// popList.updatePopulation(popSearchName, populations);
		System.out.println("Key released: " + popSearchName);
	}

	public void keyPressed(KeyEvent evt) { }  
  
	public void keyTyped(KeyEvent evt) { }

	public String getThePopSearchTerm() {
		return popSearchTextField.getText();
	}
}