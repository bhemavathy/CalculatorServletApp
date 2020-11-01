package servletTest;

import junit.framework.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.*;
import org.junit.Test;



public class CalcRestAssured {

	
	@Test
	public void verifyAddStatus(){
		
		RestAssured.baseURI = "http://localhost:8080/CalcWebApp/";
		
		RequestSpecification req = RestAssured.given();
			
		Response res = req.queryParam("input1", 2)
							.queryParam("input2", 8)
							.request(Method.GET, "/add");
		
		String resBody = res.getBody().asString();
		
		System.out.println("Response Body is: " + resBody);
		Assert.assertTrue(resBody.contains("result"));
		 
		Assert.assertEquals(200, res.getStatusCode());
		Assert.assertEquals("HTTP/1.1 200 OK", res.getStatusLine());
	
		
	}
	
	@Test
	public void verifySubStatus(){
		
		RestAssured.baseURI = "http://localhost:8080/CalcWebApp/";
		
		RequestSpecification req = RestAssured.given();
			
		Response res = req.queryParam("input1", 2)
							.queryParam("input2", 8)
							.request(Method.GET, "/sub");
		
		String resBody = res.getBody().asString();
		
		System.out.println("Response Body is: " + resBody);
		Assert.assertTrue(resBody.contains("result"));
		 
		Assert.assertEquals(200, res.getStatusCode());
		Assert.assertEquals("HTTP/1.1 200 OK", res.getStatusLine());
	
		
	}
	
	
}

