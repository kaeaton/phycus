package org.dash.freq.gui.uploadTab;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;

import org.dash.freq.gui.uploadTab.selectFile.*;

public class UploadButton {

	private SelectFileButton selectFileButton;

	public UploadButton(SelectFileButton selectFileBtn) {
		this.selectFileButton = selectFileBtn;
	}

	public JButton getUploadButton() {
		JButton uploadButton = new JButton("Upload");
		uploadButton.setPreferredSize(new Dimension(90, 30));

		uploadButton.addActionListener(uploadListener);

		return uploadButton;
	}

	public ActionListener uploadListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			try {	

				File selectedFile = selectFileButton.getTheSelectedFile();
				System.out.println("UploadButton can find the selected file/folder: " + selectedFile.getAbsolutePath());

				// // check to make sure there's a file or folder listed in
				// // file location text area
				// if (!fileLocationTextArea.getText().isEmpty())
				// {
				// 	// for a single file
				// 	if (selectedFile.isFile())
				// 	{
				// 		// set up a new Receipt Observer
				// 		ReceiptObserver ro = new ReceiptObserver(upTextMgr, selectedFile);
				// 		try { upTextMgr.addObserver(ro); }
				// 		catch (Exception ex) { 
				// 			System.out.println("Error adding observer"); 
				// 			ex.printStackTrace(); 
				// 		}
						
				// 		// reset TextPane
				// 		outputTextPane.setText("");
						
				// 		// list file name
				// 		upTextMgr.setLine((selectedFile.getName() + ":"), "blue", "gui");
				// 		upTextMgr.setLine(("File name: " + selectedFile.getName() + ":"), "blue", "receipt");
						
				// 		// run as background thread so TextPane updates
				// 		Runnable fileUpload = new Runnable() 
				// 		{
				// 			public void run() {
				// 				try {
				// 					PostPopulationFrequencies ppf = new PostPopulationFrequencies();
				// 					ppf.setFile(selectedFile);
				// 					ppf.call();
				// 					System.out.println("Number of observers: " + upTextMgr.countObservers());
				// 					upTextMgr.setLine("", "black", "receipt");
				// 					upTextMgr.setLine("End of receipt", "black", "receipt");
				// 					upTextMgr.deleteObserver(ro);

				// 				} catch (Exception ex) { ex.printStackTrace(); }
				// 			}
				// 		};
				// 		new Thread(fileUpload).start();
				// 	}
				// 	// for multiple files
				// 	else if (!selectedFile.isFile())
				// 	{
				// 		// reset TextPane
				// 		outputTextPane.setText("");
						
				// 		// run batch job in background so TextPane updates
				// 		Runnable batchUpload = new Runnable() 
				// 		{
				// 			public void run() {
				// 				BatchUploader bu = new BatchUploader();
				// 				bu.uploadFiles(selectedFile.toString());
				// 			}
				// 		};
						
				// 		new Thread(batchUpload).start();
				// 	}
				// }
				
				// // make sure there is a file selected to prevent crashes
				// else 
				// {
				// 	outputTextPane.setText("");
				// 	upTextMgr.setLine("Please select a file or folder", "red", "gui");
				// }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
}