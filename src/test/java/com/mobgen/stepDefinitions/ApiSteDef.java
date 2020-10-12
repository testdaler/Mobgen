package com.mobgen.stepDefinitions;

import com.mobgen.Utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiSteDef {

   static Response response;
   static String id;

    @Given("The user sets URI")
    public void the_user_sets_uri() {
        baseURI = ConfigReader.getProperty("URI");
    }
    @And("The user sends get request {string} {string} with endpoint {string}")
    public void TheUserSendsGetRequestWithEndpoint(String key, String name, String endPoint) {
        response = given().
                and().queryParam("key",ConfigReader.getProperty("api_key")).
                and().header("Authorization", ConfigReader.getProperty("token")).
                and().queryParam(key,name).
                when().get(endPoint);
        System.out.println(response.prettyPrint());

    }

    @Given("Verify the status code is {int}")
    public void verify_the_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }

    @Given("Verify the content type is {string}")
    public void verify_the_content_type_is(String contentType) {
      Assert.assertEquals(contentType,response.contentType());
    }

    @Then("Verify Mike is more then {int}")
    public void verify_mike_is_more_then(int num) {
        List<String> listOfId=response.path("id");
        Assert.assertThat(listOfId.size(), greaterThan(num));
    }


    @And("The user sends post request with {string} end point")
    public void TheUserSendsPostRequestWithEndPoint(String endPoint, Map<String,String> nameBoard) {
        response = given().
                and().queryParam("key",ConfigReader.getProperty("api_key")).
                and().queryParam("token", ConfigReader.getProperty("token")).
                and().queryParam("name",nameBoard.get("name")).body(nameBoard).
                when().post(endPoint);
            id = response.path("id");
    }

    @Then("Verify the board name is {string}")
    public void verifyTheBoardNameIs(String boardName) {
        Assert.assertEquals(boardName,response.path("name"));
    }


    @And("The user sends put request with {string} end point")
    public void TheUserSendsPutRequestWithEndPoint(String endPoint,Map<String,String> nameBoard) {
        response = given().
                and().queryParam("key",ConfigReader.getProperty("api_key")).
                and().queryParam("token", ConfigReader.getProperty("token")).
                and().queryParam("name",nameBoard.get("name")).body(nameBoard).
                when().put(endPoint+"/"+id);
           }

    @And("The user sends delete request with {string} end point")
    public void TheUserSendsDeleteRequestWithEndPoint(String endPoint) {
        response = given().
                and().queryParam("key",ConfigReader.getProperty("api_key")).
                and().queryParam("token", ConfigReader.getProperty("token")).
                and().
                when().delete(endPoint+"/"+id);
        System.out.println(response.prettyPrint());

    }
    @Then("Verify the message value is null")
    public void verify_the_message_is_displayed( ) {
        Assert.assertNull(response.path("_value"));
    }
}
