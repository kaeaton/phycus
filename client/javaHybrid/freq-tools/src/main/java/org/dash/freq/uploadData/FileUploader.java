package org.dash.freq.uploadData;

import java.io.File;

import javax.swing.JTextPane;

import org.dash.freq.gui.uploadTab.UploadTabClassInstantiations;
import org.dash.freq.publisher.*;

/**
 * This class triggers the file upload process to PostPopulationFrequencies, 
 * first setting the file, then calling the "call()" function which starts the validations. 
 *
 * @author katrinaeaton
 */
public class FileUploader {

	private UploadFilesObservable uploadFilesObservable = UploadFilesObservable.getInstance();
	private UploadTabObserver uploadTabObserver;
	private ReceiptObserver receiptObserver;

	public FileUploader() { }

	/**
	 * Begins the upload process, writing to both the GUI and the receipt.
	 *
	 * @param selectedFile The Phycus file to be uploaded.
	 */
	public void uploadFile(File selectedFile) {

		// set up new Observers
		receiptObserver = new ReceiptObserver(uploadFilesObservable, selectedFile);
		uploadTabObserver = new UploadTabObserver(uploadFilesObservable);

		try { 
			uploadFilesObservable.addObserver(receiptObserver); 
			uploadFilesObservable.addObserver(uploadTabObserver); 
		} catch (Exception ex) { System.out.println("FileUploader: Error adding observer"); ex.printStackTrace(); }
		
		// // list file name
		// uploadFilesObservable.setLine((selectedFile.getName() + ":"), "blue", "gui");
		// uploadFilesObservable.setLine(("File name: " + selectedFile.getName() + ":"), "black", "receipt");
		
		// run as background thread so TextPane updates
		Runnable fileUpload = new Runnable() {
			public void run() {
				try {
					// list file name
		uploadFilesObservable.setLine((selectedFile.getName() + ":"), "blue", "gui");
		uploadFilesObservable.setLine(("File name: " + selectedFile.getName() + ":"), "black", "receipt");

					PostPopulationFrequencies ppf = new PostPopulationFrequencies(
						"gtRegistry", 
						"test");
						// prefs.get("PHY_EST_ENTITY", null));
					ppf.setFile(selectedFile);
					ppf.call();

					System.out.println("Number of observers: " + uploadFilesObservable.countObservers());
					uploadFilesObservable.setLine("", "black", "receipt");
					uploadFilesObservable.setLine("End of receipt", "black", "receipt");
					uploadFilesObservable.deleteObserver(receiptObserver);
					uploadFilesObservable.deleteObserver(uploadTabObserver);

				} catch (Exception ex) { ex.printStackTrace(); }
			}
		};
		new Thread(fileUpload).start();
	}

}