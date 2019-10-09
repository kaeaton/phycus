/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dash.freq.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


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
	
	
	
	public DoiService() {
		
	}

    public InputStream makeCall() throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			
			URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.ncbi.nlm.nih.gov")
				.setPath("/pmc/utils/idconv/v1.0/")
				.setParameter("tool", "PHYCuS")
				.setParameter("email", "phycusproject@gmail.com")
				.setParameter("ids", "23193287")
				.setParameter("versions", "no")
				.setParameter("format", "csv")
				.build();
			HttpGet httpget = new HttpGet(uri);
			
			CloseableHttpResponse response = httpclient.execute(httpget);
			System.out.println(response);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
                long len = entity.getContentLength();
                InputStream is = entity.getContent();
                String filePath = userDocumentsPath + "doi.csv";
				FileOutputStream fos = new FileOutputStream(new File(filePath));
				int inByte;
				while((inByte = is.read()) != -1)
					 fos.write(inByte);
				is.close();
				fos.close();
            }
			

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
            httpclient.close();
        }
        return incomingData;
    }	
}
