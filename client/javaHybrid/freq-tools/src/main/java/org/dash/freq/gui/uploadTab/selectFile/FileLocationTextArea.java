package org.dash.freq.gui.uploadTab.selectFile;

import java.awt.Font;

import javax.swing.JTextArea;

import org.dash.freq.utilities.Prefs;
import org.dash.freq.utilities.StyleGuide;

public class FileLocationTextArea {
	private JTextArea fileLocationTextArea = new JTextArea();

	public FileLocationTextArea() { }

	public JTextArea getFileLocationTextArea() {
		fileLocationTextArea.setEditable(false);
		fileLocationTextArea.setLineWrap(true);
		fileLocationTextArea.setFocusable(false);
		fileLocationTextArea.setOpaque(false);
		fileLocationTextArea.setFont(StyleGuide.TEXT_AREA_FONT);

		fileLocationTextArea.setText(Prefs.getUploadPath());
		return fileLocationTextArea;
	}
}










