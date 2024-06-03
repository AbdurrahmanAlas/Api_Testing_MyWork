package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.JsonPlace_Pojo.PojoHerokuappBooking;
import pojos.JsonPlace_Pojo.PojoHerokuappBookingdate;
import pojos.JsonPlace_Pojo.PojoHerokuappExpectedBody;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HerokuApp_Stepdefinitions {

    private RequestSpecification spec;

    PojoHerokuappBookingdate bookingdate;

    PojoHerokuappBooking reqBody;

    PojoHerokuappExpectedBody expectedBody;
    Response response;
    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_herokuapp"))
                .build();
    }


    @Given("URL ve body hazirla")
    public void url_ve_body_hazirla() {

        spec.pathParams("pp1","booking");

 bookingdate = new PojoHerokuappBookingdate("2021-06-01","2021-06-10");
         reqBody= new PojoHerokuappBooking("Ahmet","Bulut",500,false,"wi-fi",bookingdate);

    }
    @Given("Expected Data hazirla")
    public void expected_data_hazirla() {

         expectedBody=new PojoHerokuappExpectedBody(24,reqBody);



    }
    @Given("Response'i kaydet")
    public void response_i_kaydet() {

        response = given().
                spec(spec).
                contentType(ContentType.JSON).
                when().
                body(reqBody).
                post("/{pp1}");
        response.prettyPrint();


    }
    @Given("Assertion")
    public void assertion() {

        PojoHerokuappExpectedBody respPojo=response.as(PojoHerokuappExpectedBody.class);

        assertEquals(expectedBody.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        assertEquals(expectedBody.getBooking().getLastname(),respPojo.getBooking().getLastname());
        assertEquals(expectedBody.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        assertEquals(expectedBody.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
        assertEquals(expectedBody.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
        assertEquals(expectedBody.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedBody.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());




    }

}
