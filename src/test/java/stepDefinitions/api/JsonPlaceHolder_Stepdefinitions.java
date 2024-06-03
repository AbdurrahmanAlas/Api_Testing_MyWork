package stepDefinitions.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pojos.JsonPlace_Pojo.PojoJsonPlace;
import utilities.ConfigReader;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class JsonPlaceHolder_Stepdefinitions {

    private RequestSpecification specJsonPlace;

    PojoJsonPlace requestBody;
    PojoJsonPlace expData;
    Response response;

    @Before
    public void beforeAPIScenario() {
        specJsonPlace = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_jsonplaceholder"))
                .build();
    }


    @Given("JsonPlaceHolder Api Put request icin gerekli URL ve Body hazirla")
    public void json_place_holder_api_put_request_icin_gerekli_url_ve_body_hazirla() {
        specJsonPlace.pathParams("pp1","posts","pp2",70);

       requestBody=new PojoJsonPlace("Ahmet","Merhaba",10,70);


    }


    @Given("JsonPlaceHolder Api Put request icin Expected Data hazirla")
    public void json_place_holder_api_put_request_icin_expected_data_hazirla() {

         expData=requestBody;


    }
    @Given("JsonPlaceHolder Api Put request sonucunda donen Response'i kaydet")
    public void json_place_holder_api_put_request_sonucunda_donen_response_i_kaydet() {

        response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(requestBody).put("/{pp1}/{pp2}");

        response.prettyPrint();
    }
    @Given("JsonPlaceHolder Api Put request sonucunda donen Response'i assert et")
    public void json_place_holder_api_put_request_sonucunda_donen_response_i_assert_et() {
        /*
          {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
         */

        PojoJsonPlace respPojo = response.as(PojoJsonPlace.class);

        assertEquals(expData.getTitle(),respPojo.getTitle());
        assertEquals(expData.getBody(),respPojo.getBody());
        assertEquals(expData.getId(),respPojo.getId());
        assertEquals(expData.getUserId(),respPojo.getUserId());
    }
}
