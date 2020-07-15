package org.dash.freq.validations;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import com.Ostermiller.util.CircularByteBuffer;

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

public class IonCheckExperimental {
	
	private final String fileLocation = "https://www.iccbba.org/docs/tech-library/database/grid-issuing-organizations-data-file.xml";
	// private final URL FILE_URL = Urls.finalUrl(fileLocation);

	private File ionFile = new File("ion.xml");

	/* ------------- */
	private FileInputStream input;
	private FileChannel fileChannel;
	private FileOutputStream stream;
	private FileOutputStream streamToCircularBB;
	// private FileOutputStream stream = newFileOutputStream(ionFile);
	private CircularByteBuffer cbb = new CircularByteBuffer(CircularByteBuffer.INFINITE_SIZE);


	/*  ------------ */

	private AsyncHttpClient client = Dsl.asyncHttpClient();
	private Document doc;


	public IonCheckExperimental() {

		// streamToCircularBB = getXmlFile();
		OutputStream ops = cbb.getOutputStream();
		ops = getXmlFile();
		// cbb.getOutputStream() = (OutputStream)streamToCircularBB;
		
	}

	private OutputStream getXmlFile() {

		client.prepareGet(fileLocation).execute(new AsyncCompletionHandler<FileOutputStream>() {
	 
		    @Override
		    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) 
		      throws Exception {
		        stream.getChannel().write(bodyPart.getBodyByteBuffer());
		        // stream.getChannel().write(cbb.getOutputStream());
		        return State.CONTINUE;
		    }
		 
		    @Override
		    public FileOutputStream onCompleted(Response response) 
		      throws Exception {
		      	System.out.println("IonCheck: xml file downloaded.");

		        return stream;
		    }
		});

		OutputStream returnedStream = stream;

		return returnedStream;
	}

	public String[] checkIon(String enteredIon) {
		String[] results = {"", ""};
		try {

			/* ------------- */


			// InputStream input = newFileInputStream(stream);
			// FileInputStream input = newFileInputStream(stream);

			/* ------------- */

			// build and parse the xml document
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			/* ------------- */
			doc = dBuilder.parse(cbb.getInputStream());
			// doc = dBuilder.parse(input);

			/* ------------- */
		} catch(Exception ex) {
			System.out.println("Document builder error in IonCheck: " + ex);
		}
		
		// collect all the Issuing_Organization nodes
		NodeList nList = doc.getElementsByTagName("Issuing_Organization");
		
		// cycle through the nodes
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				// get elements at that node
				Element eElement = (Element) nNode;

				System.out.println("ION: " + eElement.getElementsByTagName("ION").item(0).getTextContent());
				System.out.println("ION name: " + eElement.getElementsByTagName("Issuing_Organization_Name").item(0).getTextContent());
			
				// if the ION entered matches the ION in a node, assign to results, break the loop
				if(enteredIon.equals(eElement.getElementsByTagName("ION").item(0).getTextContent())) {
					results[0] = eElement.getElementsByTagName("ION").item(0).getTextContent();
					results[1] = eElement.getElementsByTagName("Issuing_Organization_Name").item(0).getTextContent();
					break;
				} else {
					results = null;
				}
			}
		}

		return results;
	}


	// private InputStream newFileInputStream(FileOutputStream outputStream) {
	// 	// buffer all data in a circular buffer of infinite size
	// 	CircularByteBuffer cbb = new CircularByteBuffer(CircularByteBuffer.INFINITE_SIZE);
	// 	streamToCircularBB = cbb.getOutputStream();
	// 	return cbb.getInputStream();

	// 	// try {
	// 	// 	return new FileOutputStream(file);
	// 	// } catch(Exception ex) {
	// 	// 	System.out.println("Error creating new FileOutputStream (IonCheck): " + ex);
	// 	// 	throw new Error(ex);
	// 	// }
	// }


}
