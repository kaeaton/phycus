package org.dash.freq.uploadData;

import java.io.File;

import javax.swing.JTextPane;

import org.dash.freq.gui.uploadTab.UploadTabClassInstantiations;
import org.dash.freq.publisher.*;

public class FileUploader {

	private UploadFilesObservable uploadFilesObservable = UploadFilesObservable.getInstance();
	private UploadTabObserver uploadTabObserver; //= new UploadTabObserver(uploadFilesObservable);
	private ReceiptObserver receiptObserver;

	public FileUploader() { }

	public void uploadFile(File selectedFile) {

		// set up new Observers
		receiptObserver = new ReceiptObserver(uploadFilesObservable, selectedFile);
		uploadTabObserver = new UploadTabObserver(uploadFilesObservable);

		try { 
			uploadFilesObservable.addObserver(receiptObserver); 
			uploadFilesObservable.addObserver(uploadTabObserver); 
		} catch (Exception ex) { System.out.println("FileUploader: Error adding observer"); ex.printStackTrace(); }
		
		// list file name
		uploadFilesObservable.setLine((selectedFile.getName() + ":"), "blue", "gui");
		uploadFilesObservable.setLine(("File name: " + selectedFile.getName() + ":"), "black", "receipt");
		
		// run as background thread so TextPane updates
		Runnable fileUpload = new Runnable() 
		{
			public void run() {
				try {

					// PostPopulationFrequencies ppf = new PostPopulationFrequencies(
					// 	gtRegistry, 
					// 	prefs.get("PHY_EST_ENTITY", null));
					// ppf.setFile(selectedFile);
					// ppf.call();

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