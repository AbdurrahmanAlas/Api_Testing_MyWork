package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class HerokuApp2_Stepdefinitions {
    private RequestSpecification spec;
    public Response response;

    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_herokuapp"))
                .build();
    }


    @Given("Herokuapp Api gerekli URL icin {string} path param ve {string} query param hazirla")
    public void herokuapp_api_gerekli_url_icin_path_param_ve_query_param_hazirla(String pathParam, String queryParam) {

        spec.pathParam("pp1", pathParam).queryParam("firstname", queryParam);

    }

    @Given("Herokuapp Api Get Request donen Response i kaydet")
    public void herokuapp_api_get_request_donen_response_i_kaydet() {

        response = given().
                spec(spec).
                when().
                get("/{pp1}");


    }

    @Given("Herokuapp Api Get Request donen Response i assert et")
    public void herokuapp_api_get_request_donen_response_i_assert_et() {


        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid", hasItem(113));

    }

}
