package com.devsavant;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getTime {

    @BeforeSuite
    void setUp() {
        System.out.println("start");
    }

    @AfterSuite
    void tearDown() {
        System.out.println("finish");
    }

    @Test
    void getTimeWorldtimeapi() {
        RestAssured.baseURI = "http://worldtimeapi.org/api/timezone/";
        given().
                queryParam("Africa/Abidjan")
                .body("")
                .when()
                .get()
                .then()
                .assertThat().statusCode(200);
    }
}
