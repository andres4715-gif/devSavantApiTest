package com.devsavant;

import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class devsavantAPITest {
    @Test(enabled = true, priority = 1, description = "Easy and first way to check body")
    public void CheckBodyFirstOption() {
        RestAssured.baseURI = "http://worldtimeapi.org/api/timezone/";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Africa/Abidjan");
        responseAndres.getBody().prettyPrint();
        Assert.assertTrue(responseAndres.body().asString().contains("unixtime"),
                "Check because this response doesn't have this specific text");
    }

    @Test(enabled = true, priority = 2, description = "Read JSON Response Body using Rest Assured")
    public void checkJsonBodyResponse() {
        RestAssured.baseURI = "http://worldtimeapi.org/api/timezone/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/Africa/Abidjan");
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Printing
        System.out.println(response.body().asString());
        String timeZone = jsonPathEvaluator.get("timezone");
        System.out.println("timeZone: " + timeZone);
        Assert.assertTrue(timeZone.equals("Africa/Abidjan"),
                "Please check the timeZone " + jsonPathEvaluator.get("timezone")
                        + " is not the good response.");
    }

    @Test(enabled = true, priority = 2, description = "Read JSON Response Body using Rest Assured")
    public void checkJsonBodyResponse2() {
        RestAssured.baseURI = "http://worldtimeapi.org/api/timezone/";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Africa/Abidjan");
        JsonPath jsonPathEvaluator = responseAndres.jsonPath();

        // Printing
        System.out.println(responseAndres.body().asString());
        String timeZone = jsonPathEvaluator.get("timezone");
        System.out.println("timeZone: " + timeZone);
        Assert.assertFalse(timeZone.equals("Africa/Casablanca"),
                "negative test");
    }
}

