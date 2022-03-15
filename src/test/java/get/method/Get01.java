package get.method;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    IN API test cases and automation scripts we use
        - given: it declares pre-request
        - when: It declares the action which user perform
        - and: It can be use after the others when we have multple test cases,
        - then: It declares outputs

     */

    /*
    when
    - I send a GET request the ure https://restful-booker.herokuapp.com/booking/3
    then
    HTTP status code should be 200
    And
    Contetnt type should be JSON
    And
    Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){
        //* 1- Set the URL

        String url = "https://restful-booker.herokuapp.com/booking/3";

        // 2- Set the expected data==> for post, put, and patch

        // 3- Type Automation Script to send get request

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assert the output



    }
}
