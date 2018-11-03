package com.test.getapitest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.client.RestClient;

public class GetAPITest extends TestBase {
	TestBase  testBase;
	String apiurl;
	String serviceurl;
	String url;
	RestClient restClient;
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase= new TestBase();
		 serviceurl=prop .getProperty("URL");
		apiurl=prop .getProperty("service");
		
		 url=serviceurl+apiurl;
	}
		 
		 @Test
		 public void getAPITest() throws ClientProtocolException, IOException {
			 restClient = new RestClient();
				restClient.get(url);
		 }
		
}


