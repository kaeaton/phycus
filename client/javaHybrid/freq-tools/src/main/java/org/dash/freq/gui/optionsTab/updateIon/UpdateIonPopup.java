package org.dash.freq.gui.optionsTab.updateIon;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.beans.*; //property change stuff
import java.awt.*;
import java.awt.event.*;

// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;


/* 1.4 example used by DialogDemo.java. */
public class UpdateIonPopup extends JDialog
				   implements ActionListener,
							  PropertyChangeListener {
	private String typedText = null;
	private JTextField textField;

	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private JPanel optionsIonPanel = optionsTabClassInstantiations.getOptionsIonPanelInstance();
	JPanel optionsIonPanel;

	private String magicWord;
	private JOptionPane optionPane;

	private String btnString1 = "Enter";
	private String btnString2 = "Cancel";

	/**
	 * Returns null if the typed string was invalid;
	 * otherwise, returns the string as the user entered it.
	 */
	public String getValidatedText() {
		return typedText;
	}

	/** Creates the reusable dialog. */
	public UpdateIonPopup(Frame aFrame, String aWord, JPanel parent) {
		super(aFrame, true);
		optionsIonPanel = parent;
		parent.setPreferredSize(new Dimension(360, 300));


		magicWord = aWord.toUpperCase();
		setTitle("Quiz");

		textField = new JTextField(10);

		//Create an array of the text and components to be displayed.
		String msgString1 = "What was Dr. SEUSS's real last name?";
		String msgString2 = "(The answer is \"" + magicWord
							  + "\".)";
		Object[] array = {msgString1, msgString2, textField};

		//Create an array specifying the number of dialog buttons
		//and their text.
		Object[] options = {btnString1, btnString2};


		//Create the JOptionPane.
		optionPane = new JOptionPane(array,
									JOptionPane.QUESTION_MESSAGE,
									JOptionPane.YES_NO_OPTION,
									null,
									options,
									options[0]);

		//Make this dialog display it.
		setContentPane(optionPane);

		// this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(new Dimension(360, 300));
		this.setLocationRelativeTo(null);


		//Handle window closing correctly.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				
			// 	 * Instead of directly closing the window,
			// 	 * we're going to change the JOptionPane's
			// 	 * value property.
				 
				optionPane.setValue(new Integer(
									JOptionPane.CLOSED_OPTION));
			}
		});

		//Ensure the text field always gets the first focus.
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				textField.requestFocusInWindow();
			}
		});

		//Register an event handler that puts the text into the option pane.
		textField.addActionListener(this);

		//Register an event handler that reacts to option pane state changes.
		optionPane.addPropertyChangeListener(this);
	}

	/** This method handles events for the text field. */
	public void actionPerformed(ActionEvent e) {
		optionPane.setValue(btnString1);
	}

	/** This method reacts to state changes in the option pane. */
	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();

		if (isVisible()
		 && (e.getSource() == optionPane)
		 && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
			 JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
			Object value = optionPane.getValue();

			if (value == JOptionPane.UNINITIALIZED_VALUE) {
				//ignore reset
				return;
			}

			//Reset the JOptionPane's value.
			//If you don't do this, then if the user
			//presses the same button next time, no
			//property change event will be fired.
			optionPane.setValue(
					JOptionPane.UNINITIALIZED_VALUE);

			if (btnString1.equals(value)) {
					typedText = textField.getText();
				String ucText = typedText.toUpperCase();
				if (magicWord.equals(ucText)) {
					//we're done; clear and dismiss the dialog
					clearAndHide();
				} else {
					//text was invalid
					textField.selectAll();
					JOptionPane.showMessageDialog(
									UpdateIonPopup.this,
									"Sorry, \"" + typedText + "\" "
									+ "isn't a valid response.\n"
									+ "Please enter "
									+ magicWord + ".",
									"Try again",
									JOptionPane.ERROR_MESSAGE);
					typedText = null;
					textField.requestFocusInWindow();
				}
			} else { //user closed dialog or clicked cancel
			//     optionsIonPanel.setLabel("It's OK.  "
			//              + "We won't force you to type "
			//              + magicWord + ".");
			    typedText = null;
			    clearAndHide();
			}
		}
	}

	/** This method clears the dialog and hides it. */
	public void clearAndHide() {
		textField.setText(null);
		setVisible(false);
	}
}