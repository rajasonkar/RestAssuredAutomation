package com;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_Post {

	@SuppressWarnings("unchecked")
	@Test
	void registerUser() {
		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		//resquest payload sending along with post request 
		JSONObject reqParam = new JSONObject();
		reqParam.put("FirstName", "abcesdfsdsdss");
		reqParam.put("LastName", "addgddce");
		reqParam.put("UserName", "abftcef");
		reqParam.put("Password", "abcejh");
		reqParam.put("Email", "adced@abce.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(reqParam.toJSONString());
		
		// Response object
		Response response = httpRequest.request(Method.POST, "/register");

		// print response

		String responseBody = response.getBody().asString();
		System.out.println("Response Body : " + responseBody);

		// status code

		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// status line verification
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("success code : " + successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}

	
	
}
