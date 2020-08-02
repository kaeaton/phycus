package org.dash.freq.utilities;

import java.awt.Frame;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FindParentFrame {

	public FindParentFrame() { }

	public static Frame getParentFrame(JPanel childPanel) {
		// pass 'this' if you are inside the panel

		// if that doesn't work:
		// Use in ActionListener to get parent panel from Button class
		// JPanel parentPanel = ((JButton)evt.getComponent()).getParent()); 

		Window parentWindow = SwingUtilities.windowForComponent(childPanel); 

		Frame parentFrame = null;
		if (parentWindow instanceof Frame) {
		    parentFrame = (Frame)parentWindow;
		}

		return parentFrame;
	}
}