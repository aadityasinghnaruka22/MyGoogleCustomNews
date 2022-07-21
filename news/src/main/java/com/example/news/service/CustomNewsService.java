package com.example.news.service;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomNewsService {

	public String getResult(String value) throws IOException {  
	    CloseableHttpResponse response ;
	    String responseBody = "";
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

        //forming the url based on the user given topic 
		String url = "https://news.google.com/search?q="+value+"&hl=en-IN&gl=IN&ceid=IN:en";
        HttpGet httpget = new HttpGet(url);
        
        //Executing the get request
         response = httpclient.execute(httpget);
         if(response.getStatusLine().getStatusCode() == 200) {
        	 responseBody =  EntityUtils.toString(response.getEntity());
         }
    }
		//Returning the responseBody 
		return responseBody;
}
	
	}

