package com.example.kevvlvl.apitester;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StockApiTest {

    private static final String API_HOST = "http://127.0.0.1";
    private static final int API_PORT = 8080;

    private static final String ENDPOINT_GET_STOCKS = "/fin/stock";

    private RequestSpecification requestSpec;
    private Response response;


    @Given("a healthy API service")
    public void setup_healthyApiService() {

        requestSpec = RestAssured.given()
                .baseUri(API_HOST)
                .port(API_PORT);
    }

    @When("a user performs a GET request to \\/fin\\/stock")
    public void userPerformsGetEndpoint() {

        response = requestSpec.when()
                .get(ENDPOINT_GET_STOCKS);
    }

    @Then("the status code is {int}")
    public void thenUserExpectsStatusCodeOk(int statusCode) {
        response.then()
                .statusCode(statusCode);
    }
}
