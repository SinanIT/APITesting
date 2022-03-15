package get.method;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 extends HerokuappBaseUrl {

    /*
    when
    - I send a GET request the ure https://restful-booker.herokuapp.com/booking/1001
    then
    HTTP status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found

    And
    Response body containse "Not Found"
    And
    Response does not contain "TechnoProEd"
    And
    Server is "Cowboy"
     */
    @Test
    public void get02(){
        spec.pathParams("first", "booking",
                "second",1001);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //verification:
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechnoProEd"));
        assertEquals(response.getHeader("Server"), "Cowboy");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Status line: " + response.statusLine());
    }
}
