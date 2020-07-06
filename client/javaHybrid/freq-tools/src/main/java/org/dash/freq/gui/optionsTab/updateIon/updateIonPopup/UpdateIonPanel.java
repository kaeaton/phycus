package org.dash.freq.gui.optionsTab.updateIon.updateIonPopup;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// import org.dash.freq.gui.optionsTab.CloseButton;
// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;
import org.dash.freq.utilities.StyleGuide;

public class UpdateIonPanel {

	private JPanel updateIonPanel = new JPanel();
	
	private final JLabel instructionsLabel = new JLabel("<html><body>If your facility has an ION number<br>"
														+ "please enter it here:<br>  </body></html>");
	private Border paddingBorderHorizontal = StyleGuide.EMPTY_BORDER_MARGIN_HORIZONTAL;
	private Border paddingBorderVertical = StyleGuide.EMPTY_BORDER_MARGIN_VERTICAL;
	
	private JTextField updateIonTextField;

	private JButton submitNewIonButton = new SubmitNewIonButton().getSubmitNewIonButton();

	// get the popup JFrame so the close button knows what to close
	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private JFrame updateIonPopup = optionsTabClassInstantiations.getUpdateIonPopupInstance();
	private JButton closeButton = new IonCloseButton().getCloseButton();

	private JPanel buttonsPanel = new JPanel();

	public UpdateIonPanel(JTextField updateIonTF) {
		this.updateIonTextField = updateIonTF;
	}

	public JPanel getUpdateIonPanel() {
		updateIonPanel.setPreferredSize(new Dimension(300, 240));
		instructionsLabel.setFont(StyleGuide.LABEL_FONT);
		instructionsLabel.setBorder(new CompoundBorder(paddingBorderHorizontal, paddingBorderVertical));

		buttonsPanel.add(submitNewIonButton);
		buttonsPanel.add(closeButton);

		// layout
		updateIonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0.5;
		
		// line 0
		c.gridx = 0;
		c.gridy = 0;
		updateIonPanel.add(instructionsLabel, c);
		
		// line 1
		c.anchor = GridBagConstraints.NORTH;
		c.gridy = 1;
		updateIonPanel.add(updateIonTextField, c);

		// // line 2
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 2;
		updateIonPanel.add(buttonsPanel, c);

		// // line 3
		// c.gridy = 3;
		// updateIonPanel.add(advancedPanel, c);



		return updateIonPanel;
	}
}