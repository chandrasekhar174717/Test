package com.tv.api;
//import static org.hamcrest.Matchers.*;
//import static org.hamcr
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.hamcrest.core.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.matchers.IsJson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.tv.util.APIConstants;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
/**
 * @author 
 *
 */
@Test
public class APIAutomation {

	static Logger logger = Logger.getLogger(APIAutomation.class);
	public static void main(String[] args) throws JSONException, FileNotFoundException, InterruptedException, IOException, ParseException {
		}
	
	public Map<String, String> getToken() throws JSONException, InterruptedException {

		Response response = given()
				.formParam("Username").formParam("Paaword").post("http://localhost:8080/lotto");
	
		logger.info("  Login Cookies: " +response.cookies());
		logger.info("  StatusCode: " +response.getStatusCode());
		logger.info("  Response Body: " +response.getBody());

		return response.cookies();
	}
	
	public void apiCall(int transid)
			throws JSONException, InterruptedException, FileNotFoundException, IOException, ParseException {

		Map<String, String> LoginCookie = (Map<String, String>)getToken();

		Response response = given().contentType(ContentType.JSON).cookies(LoginCookie).post("http://localhost:8080/lotto");
		Map<String, String> apiLoginCookie = response.getCookies();
		logger.info("API Login Cookies:: " + response.getCookies());
	 given().
		expect().statusCode(200).
		         body("lotto.lottoId", equalTo(5)).
		         body("lotto.winners.winnderId", hasItems(23, 54)).
		when().
		       get("/lotto");
		


	}
}

