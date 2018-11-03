package com.test.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		// httpClient.execute(httpGet);

		CloseableHttpResponse closablehhtpresponse = httpClient.execute(httpGet);

		// Status code
		int statusCode = closablehhtpresponse.getStatusLine().getStatusCode();
		System.out.println("The Respons Code is" + statusCode);

		// JSONString
		String responseString = EntityUtils.toString(closablehhtpresponse.getEntity(), "UTF-8");
		JSONObject responsejsonObject = new JSONObject(responseString);
		System.out.println("Response JSON From API" + responsejsonObject);
		Header[] headerArray = closablehhtpresponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("All Headers as " + allHeaders);
	}
}