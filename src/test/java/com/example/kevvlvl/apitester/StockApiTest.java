package com.example.kevvlvl.apitester;

import com.example.kevvlvl.apitester.model.FinanceStock;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StockApiTest {

    private static final String API_HOST = "http://127.0.0.1";
    private static final String API_STOCK_ENDPOINT = "/fin/stock";
    private static final int API_PORT = 8080;

    private RequestSpecification requestSpec;
    private Response response;
    private FinanceStock responseData;


    @Given("a healthy API service")
    public void setup_healthyApiService() {

        requestSpec = RestAssured.given()
                .baseUri(API_HOST)
                .port(API_PORT);
    }

    @When("a user performs a GET request to stocks endpoint")
    public void userPerformsGetEndpoint() {

        response = requestSpec.when()
                .get(API_STOCK_ENDPOINT);
    }

    @Then("the status code is {int}")
    public void thenUserExpectsStatusCodeOk(int statusCode) {
        responseData = response.then()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath().getObject("", FinanceStock.class);
    }

    @Then("response body includes the following items")
    public void evaluateResponseBodyContents(List<Map<String, String>> stocksTable) {

        FinanceStock stock = stocksTable.stream()
                .map(t -> new FinanceStock(t.get("symbol"), t.get("name"), new BigDecimal("0"), new BigDecimal("0")))
                .findFirst()
                .get();

        Assert.assertNotNull(stock);
        Assert.assertEquals(stock.getSymbol(), responseData.getSymbol());
        Assert.assertEquals(stock.getName(), responseData.getName());
    }
}
