package stepDefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Api_5_Get_ResponseBodyTesti {


    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in

             status code'unun 200,
             ve content type'inin ContentType.JSON,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
             oldugunu test edin.
     */



    @Test
    public void get01(){

        // 1 - Endpoint hazirla

        String url = "https://jsonplaceholder.typicode.com/posts/33";

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response=given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(4))
                .body("title", Matchers.equalTo("qui explicabo molestiae dolorem"));

    }





}
