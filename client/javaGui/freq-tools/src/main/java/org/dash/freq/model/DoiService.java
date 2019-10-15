/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dash.freq.model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import javax.swing.JTextPane;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.dash.freq.view.AppendText;
import org.dash.freq.view.PhycusGui;


/**
 * 
 * @author katrinaeaton
 */
public class DoiService {

    private InputStream incomingData;
	// https://www.ncbi.nlm.nih.gov/pmc/utils/idconv/v1.0/?tool=PHYCuS&email=phycusproject@gmail.com&ids=23193287&versions=no&format=csv");
	public static final String userDocumentsPath = 
				(System.getProperty("user.home") 
                + System.getProperty("file.separator") + "Documents" 
                + System.getProperty("file.separator"));
	InputStream is;
	
	
	public DoiService() {
		
	}

    public InputStream makeCall() throws IOException {
		
		// get data from input
		String input = PhycusGui.doiInputTextField.getText();
		System.out.println(input);

		// create the httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			
			// build the request
			URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.ncbi.nlm.nih.gov")
				.setPath("/pmc/utils/idconv/v1.0/")
				.setParameter("tool", "PHYCuS")
				.setParameter("email", "phycusproject@gmail.com")
				.setParameter("ids", input)
				.setParameter("versions", "no")
				.setParameter("format", "csv")
				.build();
			HttpGet httpget = new HttpGet(uri);
			
			CloseableHttpResponse response = httpclient.execute(httpget);
			System.out.println(response);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
                is = entity.getContent();
//                String filePath = userDocumentsPath + "doi.csv";
//				FileOutputStream fos = new FileOutputStream(new File(filePath));
//				int inByte;
//				while((inByte = is.read()) != -1)
//					 fos.write(inByte);
//				
//				fos.close();
            }
			
			// read input stream. Skip first line
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.println(br.readLine());
			
			int i = 0;
			String[] inputs = input.split(",");
			while (br.ready()) {
				
				// split line by comma
				String nextLine = br.readLine();
				String[] splitLine = nextLine.split(",");
				
				AppendText.appendToPane(PhycusGui.doiOutputTextPane, (String.format("%-25s", inputs[i])), Color.BLACK);

				// we're looking for splitLine[2]
				// and "doi=" + splitLine[2] to doiOutputTextPane
				AppendText.appendToPane(PhycusGui.doiOutputTextPane, ("doi=" + splitLine[2]), Color.BLACK);
				AppendText.appendToPane(PhycusGui.doiOutputTextPane, System.lineSeparator(), Color.BLACK);
			
				i++;
			}
			
			// any messages to doiNotificationsTextPane
			AppendText.appendToPane(PhycusGui.doiNotificationsTextPane, "test", Color.BLACK);
			
			
			
			
			
//			URL serviceRootUrl = new URL(serviceRoot);
//			
//            // Open connection
//			HttpURLConnection connection = (HttpURLConnection) serviceRootUrl.openConnection();
//          
//            // Setup the connection
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "text/csv");
//            connection.setRequestProperty("Content-Type", "text/csv");
//            connection.setRequestProperty("X-Stream", "true");
//            
//            // Send our request
//            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
//            wr.write(params);
//            wr.flush();
//            
//            // Did we get a response?
//            int httpResult = connection.getResponseCode();
//            System.out.println("http response code: " + httpResult);
//            if (httpResult == HttpURLConnection.HTTP_OK) {
//                incomingData = connection.getInputStream();
//                System.out.println("got input string");
//            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
			is.close();
            httpclient.close();
        }
        return incomingData;
    }	
}
