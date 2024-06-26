package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Dummy_Pojo.PojoDummyExpectedBody;
import pojos.Dummy_Pojo.Pojo_Dummy_Data;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Dummy01_Stepdefinitions {


    private RequestSpecification spec;
    public Response response;
    PojoDummyExpectedBody expectedBody;

    Pojo_Dummy_Data data;

    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_dummy"))
                .build();
    }

    @Given("Dummy icin gerekli path params {string} hazırla")
    public void dummy_icin_gerekli_path_params_hazırla(String string) {

        //1-a)  http://dummy.restapiexample.com/api/v1/employee/3

        spec.pathParams("pp1","employee","pp2",3);

       //1-b) RESPONSE BODY OLMAZ GET de

    }
    @Given("Dummy get sorgusu icin Expected Data hazirla")
    public void dummy_get_sorgusu_icin_expected_data_hazirla() {

        //2 EXPECTED DATA HAZIRLIYORUZ. BUNUN İÇİNDE POJO HAZIRLARIZ

        /*

        "data":{
                           "id":3,
                           "employee_name":"Ashton Cox",
                           "employee_salary":86000,
                           "employee_age":66,
                           "profile_image":""
                           },

      */

        /*
           {
                    "status":"success",
                    "data":{
                            "id":3,
                            "employee_name":"Ashton Cox",
                            "employee_salary":86000,
                            "employee_age":66,
                            "profile_image":""
                            },
                    "message":"Successfully! Record has been fetched."
                    }
         */

         data=new Pojo_Dummy_Data(3,"Ashton Cox",86000,66,"");
         expectedBody=new PojoDummyExpectedBody("success",data,"Successfully! Record has been fetched.");

    }


    @Given("Get Request icin Response i kaydet")
    public void get_request_icin_response_i_kaydet() {

        // 3- RESPONSE İ KAYDEDİYORUZ.

        response=given().
                spec(spec).
                when().
                get("/{pp1}/{pp2}");
    }


    @Given("Donen Response in Expected ile karsilastirmasini yap")
    public void donen_response_in_expected_ile_karsilastirmasini_yap() {


        PojoDummyExpectedBody respPojo= response.as(PojoDummyExpectedBody.class);
        assertEquals(expectedBody.getStatus(),respPojo.getStatus());
        assertEquals(expectedBody.getMessage(),respPojo.getMessage());
        assertEquals(expectedBody.getData().getEmployee_name(),respPojo.getData().getEmployee_name());
        assertEquals(expectedBody.getData().getEmployee_salary(),respPojo.getData().getEmployee_salary());
        assertEquals(expectedBody.getData().getEmployee_age(),respPojo.getData().getEmployee_age());
        assertEquals(expectedBody.getData().getProfile_image(),respPojo.getData().getProfile_image());
        assertEquals(expectedBody.getData().getId(),respPojo.getData().getId());




    }
}
