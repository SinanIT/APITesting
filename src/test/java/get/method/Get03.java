package get.method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get03 extends JsonPlaceHolderBaseUrl {
    /*
    When
    I send a GET request to REST API URL https://jsonplaceholder.tupicode.com/todos/23
    then
    HTTP Status code should be 200
    And
    Response format should be "application/json
    And
    "Title" is "et itaque necessitatibus maxime malestiae qui ouas velit"
    And "completed" is false
    And userId is 2

     */

    @Test
    public void get01(){
        //set the url
        spec.pathParams("first", "todos",
                "second",23);
        Response response = given().spec(spec).accept("application/JSON").when().get("/{first}/{second}");
        response.prettyPrint();
        System.out.println("Satatus code: " + response.statusCode());

        //1- first way  assert the output
//        response.
//                then()
//                .assertThat().statusCode(200)
//                .contentType("application/JSON")
//                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
//                .body("completed", equalTo(false))
//                .body("userId", equalTo(2));

        // when a test fail if JAva does not execute the next steps it is called hard assertion
        // for soft assertion java execetes all tests and gives you report about tje passed and failed ones.

        // if you use body() method for every step it uses hard assertion.
        // if you use just a single body() method with multiple steps, you can see a repeort for every failed test


        // Second Way to assertion
        response.
                then()
                .assertThat().statusCode(200)
                .contentType("application/JSON")
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));


        //Third way to assert
        //HTTP STATUS CODE
        assertEquals("Status code must be 200 but it is not",200, response.statusCode());
        //Response format should be "application/jason
        //assertEquals("application/JSON", response.getContentType());// this one failed

        assertTrue(response.getContentType().contains("application/json"));

        // "Title" is "et itaque necessitatibus maxime malestiae qui ouas velit"

        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));

        // And "completed" is false
        assertTrue(response.asString().contains("\"completed\": false"));

        //userId is 2
        assertTrue(response.asString().contains(" \"userId\": 2"));
    }

}
