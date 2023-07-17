//package org.example.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URLEncoder;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework {
//    1:

    @Test
    public void get1() {
        baseURI = "https://samples.openweathermap.org/data/2.5/weather";

        ExtractableResponse<Response> response = given()
                .param("q","London,uk")
                .param("appid", "b6 907d289e10d714a6e88b30761fae22")
                .get().then().extract();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals((float)response.body().path("coord.lat"), (float) 51.51);
        Assert.assertEquals((float)response.body().path("coord.lon"), (float) -0.13);
    }

    //2:
    @Test
    public void get2() {
        baseURI = "https://samples.openweathermap.org/data/2.5/weather";
        ExtractableResponse<Response> response =
                given().param("q", "London,uk").
                        param("appid", "b6 907d289e10d714a6e88b30761fae22").
                get().then().extract();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.body().path("base"),  "stations");
    }

    @Test
    public void get3() {
        baseURI = "https://samples.openweathermap.org/data/2.5/weather";
        ExtractableResponse<Response> response =
                given().param("q", "London,uk").
                        param("appid", "b6 907d289e10d714a6e88b30761fae22").
                        get().then().extract();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals((Integer) response.body().path("visibility"),  10000);
    }

    @Test
    public void get4() {
        baseURI = "https://samples.openweathermap.org/data/2.5/weather";
        ExtractableResponse<Response> response =
                given().param("q", "London,uk").
                        param("appid", "b6 907d289e10d714a6e88b30761fae22").
                        get().then().extract();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.body().path("name"),  "London");
    }


// 3: https://api.postman.com/collections/21768374-8c7369a6-e8d0-4f46-b5e4-8deb627160f9?access_key=PMAT-01GW4ME06PVFTZ8JAZFFZWFKS0
}

