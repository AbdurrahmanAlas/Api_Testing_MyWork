package stepDefinitions.api.apiTekrarStep;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.Herokuapp2_Pojo.PojoHerokuapp2Booking;
import pojos.Herokuapp2_Pojo.PojoHerokuapp2BookingDate;
import pojos.Herokuapp2_Pojo.PojoHerokuapp2ExpectedBody;
import pojos.JsonPlace_Pojo.PojoHerokuappExpectedBody;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class HerokuApp2Step {
    private RequestSpecification spec;

    PojoHerokuapp2BookingDate BookingDate2;

    PojoHerokuapp2Booking reqBody2;
    PojoHerokuapp2ExpectedBody expectedBody2;

    Response response;

    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_herokuapp"))
                .build();
    }

    @Given("Herokuapp URL ve body hazirla")
    public void herokuapp_url_ve_body_hazirla() {

        //1 BURDA URL İ HAZIRLADIK URL DEN ONCE SPEC TANIMLADIK YUKARIDA BEFORE İLE URL CALISACAK SONRA BURDAN booking i alacak
        spec.pathParam("pp1", "booking");


        //2 BURDA REQUESTBODY VERİLMİŞSSE ONUN POJOSUNU AL VE BURAYA EKLE
        /*     Request body
                  {
                       "firstname" : "Ahmet",
                       "lastname" : “Bulut",
                       "totalprice" : 500,
                       "depositpaid" : false,
                       "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                         },
                       "additionalneeds" : "wi-fi"
                   }

            */

        BookingDate2 = new PojoHerokuapp2BookingDate("2021-06-01", "2021-06-10");

        reqBody2 = new PojoHerokuapp2Booking("Ahmet", "Bulut", 500, false, "wi-fi", BookingDate2);


    }

    @Given("Herokuapp Expected Data hazirla")
    public void herokuapp_expected_data_hazirla() {

        // 3 BURDA EXPECTED DATA HAZIRLANIR POJOSUNU AL BURAYA EKLE

          /*
    {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
     */


        expectedBody2 = new PojoHerokuapp2ExpectedBody(24, reqBody2);


    }

    @Given("Herokuapp Response kaydet")
    public void herokuapp_response_kaydet() {


        //4 RESPONSE İ KAYDET

        response = given().
                spec(spec).
                contentType(ContentType.JSON).
                when().
                body(reqBody2).
                post("/{pp1}");
        response.prettyPrint();


    }

    @Given("Assertion yap")
    public void assertion_yap() {

        //5 ASSERTİON YAP





        PojoHerokuapp2ExpectedBody respPojo2 = response.as(PojoHerokuapp2ExpectedBody.class);

        assertEquals(expectedBody2.getBooking().getFirstname(), respPojo2.getBooking().getFirstname());
        assertEquals(expectedBody2.getBooking().getLastname(), respPojo2.getBooking().getLastname());
        assertEquals(expectedBody2.getBooking().getTotalprice(), respPojo2.getBooking().getTotalprice());
        assertEquals(expectedBody2.getBooking().isDepositpaid(), respPojo2.getBooking().isDepositpaid());
        assertEquals(expectedBody2.getBooking().getAdditionalneeds(), respPojo2.getBooking().getAdditionalneeds());
        assertEquals(expectedBody2.getBooking().getBookingdates2().getCheckin(), respPojo2.getBooking().getBookingdates2().getCheckin());
        assertEquals(expectedBody2.getBooking().getBookingdates2().getCheckout(), respPojo2.getBooking().getBookingdates2().getCheckout());

    }

}
