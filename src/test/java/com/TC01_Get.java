package com;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TC01_Get {

	// @Test
	void getWeatherDetails() {
		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET, "/Mumbai");

		// print response

		String responseBody = response.getBody().asString();
		System.out.println("Response Body : " + responseBody);

		// status code

		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	// @Test
	void googleMapTest() {
		// specify base URI
		RestAssured.baseURI = "https://www.facebook.com/";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET,
				"login/device-based/regular/login/?login_attempt=1&lwv=110");

		// print response

		String responseBody = response.getBody().asString();
		System.out.println("Response Body : " + responseBody);

		// validating header
		System.out.println("Content type :" + response.header("Content-Type"));
		System.out.println("Content Encoding :" + response.header("Content-Encoding"));

	}

	// @Test
	void testCase() {
		// specify base URI
		/*
		 * RestAssured.baseURI = "https://reqres.in/api/"; // Request object
		 * RequestSpecification httpRequest = RestAssured.given(); // Response
		 * object Response response = httpRequest.request(Method.GET,
		 * "users/2");
		 */
		// print response

		// String responseBody = response.getBody().asString();
		// System.out.println("Response Body : " + responseBody);
		ValidatableResponse abc = given().get("https://reqres.in/api/users/2").then();
		JsonPath jsonPath = new JsonPath(abc.extract().asString());
		// System.out.println("ddf "+jsonPath.getMap("data"));
		Map<Object, Object> hm = jsonPath.getMap("data");
		System.out.println("using map :" + hm.get("first_name"));
		System.out.println("First Name :" + jsonPath.getString("first_name"));
		// validating header
		// System.out.println("Content type :"+response.header("Content-Type"));
		// System.out.println("Content Encoding
		// :"+response.header("Content-Encoding"));

	}
	//@Test
	void testCase2() {

		ValidatableResponse abc = given().get("https://reqres.in/api/users/").then();
		JsonPath jsonPath = new JsonPath(abc.extract().asString());
		// System.out.println("ddf "+jsonPath.getMap("data"));
		List<Object> listOfObject = jsonPath.getList("data");
		// System.out.println("using map :"+hm.get("first_name"));

		// System.out.println("First Name :" + listOfObject);
		//HashMap<Object, Object> hm = new HashMap<Object, Object>();
		for (Object ll : listOfObject) {
			//System.out.println(ll);
			Map<Object,Object> map = (Map<Object, Object>) ll;
			
			System.out.println("LastNAme :" + map.get("last_name") + "FirstNAme :" + map.get("first_name") + "ID :"
					+ map.get("id")+ "avatar :" + map.get("avatar") + "Email :" + map.get("email"));

		}

		// validating header
		// System.out.println("Content type :"+response.header("Content-Type"));
		// System.out.println("Content Encoding
		// :"+response.header("Content-Encoding"));

	}
	
	
	
//	@Test
	public void getRespFromOneAndSetToOther ()
	{
		
		RestAssured.baseURI = "https://reqres.in/api";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET, "/unknown");

		// print response

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}

/*	public class UserData {
		private String last_name;
		private String id;
		private String avatar;
		private String first_name;
		private String email;

		

		public String getLast_name() {
			return last_name;
		}

		public String getId() {
			return id;
		}

		public String getAvatar() {
			return avatar;
		}

		public String getFirst_name() {
			return first_name;
		}

		public String getEmail() {
			return email;
		}

	}*/

}
