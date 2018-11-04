package com.test.client;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// GET Method without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closehttpresponse = httpClient.execute(httpGet);
		return closehttpresponse;
	}

	// GET Method with headers
	/*
	 * public CloseableHttpResponse get(String url, HashMap<String, String>
	 * headerMap) throws ClientProtocolException, IOException { CloseableHttpClient
	 * httpClient = HttpClients.createDefault(); HttpGet httpGet = new HttpGet(url);
	 * 
	 * for (Map.Entry<String, String> entry : headerMap.entrySet()) {
	 * 
	 * httpGet.addHeader(entry.getKey(), entry.getValue()); }
	 * 
	 * CloseableHttpResponse closablehhtpresponse = httpClient.execute(httpGet);
	 * return closablehhtpresponse;
	 * 
	 * }
	 */
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);// for post request
		httpPost.setEntity(new StringEntity(entityString));// for payload for post only

		for (Map.Entry<String, String> entry : headerMap.entrySet()) {

			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closehttpresponse = httpClient.execute(httpPost);
		return closehttpresponse;
	}

}