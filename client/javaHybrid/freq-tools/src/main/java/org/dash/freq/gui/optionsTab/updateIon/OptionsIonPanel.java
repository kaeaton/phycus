package org.dash.freq.gui.optionsTab.updateIon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import org.dash.freq.utilities.StyleGuide;

public class OptionsIonPanel extends JPanel {

	
	private JButton resetIonButton = new ResetIonButton().getResetIonButton();
	// private JButton updateIonButton = new UpdateIonButton(updateIonPopup).getUpdateIonButton();
	private JButton updateIonButton = new JButton("Update Ion");
	private TitledBorder ionBorder = BorderFactory.createTitledBorder(StyleGuide.TITLED_BORDER_OUTLINE, "Reset Issuing Organization Number (ION)");
	private Border paddingBorder = StyleGuide.EMPTY_BORDER_MARGIN_VERTICAL;
	private JPanel ionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	private Frame ionParentFrame = findParentFrame(this);
	private UpdateIonPopup updateIonPopup = new UpdateIonPopup(ionParentFrame, "updateIonPanel", ionPanel);

	public OptionsIonPanel() { }

	public JPanel getOptionsIonPanel() {

		updateIonButton.addActionListener(updateIonListener);

		this.setPreferredSize(new Dimension(500, 80));
		this.add(resetIonButton);
		this.add(updateIonButton);
		this.setBorder(new CompoundBorder(paddingBorder, ionBorder));

		return this;
	}

	private ActionListener updateIonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			// updateIonPopupFrame.setVisible(true);
			updateIonPopup.setVisible(true);

			// load ION xml in background
		}
	};

	private Frame findParentFrame(JPanel childPanel) {
		Window parentWindow = SwingUtilities.windowForComponent(childPanel); 

		// or pass 'this' if you are inside the panel
		Frame parentFrame = null;
		if (parentWindow instanceof Frame) {
		    parentFrame = (Frame)parentWindow;
		}

		return parentFrame;
	}
}
