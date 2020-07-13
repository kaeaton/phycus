package org.dash.freq.validations;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.Response;

import org.dash.freq.utilities.Urls;


/**
 * Important how tos:
 * https://www.baeldung.com/java-download-file
 * https://www.baeldung.com/async-http-client
 * https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 */

public class IonCheck {
	
	private final String fileLocation = "https://www.iccbba.org/docs/tech-library/database/grid-issuing-organizations-data-file.xml";
	// private final URL FILE_URL = Urls.finalUrl(fileLocation);

	private File ionFile = new File("ion.xml");
	private FileOutputStream stream = newFileOutputStream(ionFile);

	private AsyncHttpClient client = Dsl.asyncHttpClient();


	public IonCheck() {

		client.prepareGet(fileLocation).execute(new AsyncCompletionHandler<FileOutputStream>() {
	 
		    @Override
		    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) 
		      throws Exception {
		        stream.getChannel().write(bodyPart.getBodyByteBuffer());
		        return State.CONTINUE;
		    }
		 
		    @Override
		    public FileOutputStream onCompleted(Response response) 
		      throws Exception {
		        return stream;
		    }
		});
	}

	public FileOutputStream newFileOutputStream(File file) {
		try {
			return new FileOutputStream(file);
		} catch(Exception ex) {
			System.out.println("Error creating new FileOutputStream (IonCheck): " + ex);
			throw new Error(ex);
		}
	}
}
