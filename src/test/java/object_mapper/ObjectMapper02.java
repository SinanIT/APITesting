package object_mapper;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JasonUtil;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapper02 extends HerokuappBaseUrl {

    /* When
    I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/2
    Then
    Http status code should be 200
    AND
    response body should be like
    {
    "firstname": "Mark",
    "lastname": "Wilson",
    "totalprice": 380,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2016-12-06",
        "checkout": "2021-12-04"
    }
}

     */

    @Test
    public void get01(){
        //set the url
        spec.pathParams("first", "booking", "second", 2);

        //set the expected data
        String expected = "{\n" +
                "    \"firstname\": \"Susan\",\n" +
                "    \"lastname\": \"Wilson\",\n" +
                "    \"totalprice\": 178,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-12-26\",\n" +
                "        \"checkout\": \"2021-03-05\"\n" +
                "    }\n" +
                "}";

        //convert string to Java object
        HashMap<String, Object> expectedMap = JasonUtil.convertJsonToJava(expected, HashMap.class);

        //send request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        // conver response to java
        HashMap<String, Object> actualMap  = JasonUtil.convertJsonToJava(response.asString(), HashMap.class);

        //Assert
        //assertEquals(actualMap.get("firstname"), expectedMap.get("firstname"));
        //assertEquals(actualMap.get("lastname"), expectedMap.get("lastname"));
//        assertEquals(actualMap.get("totalprice"), expectedMap.get("totalprice"));
//        assertEquals(actualMap.get("depositpaid"), expectedMap.get("depositpaid"));
        //assertEquals(((Map)actualMap.get("bookingdates")).get("checkin"), ((Map)expectedMap.get("bookingdates")).get("checkin"));
        //assertEquals(((Map)actualMap.get("bookingdates")).get("checkout"), ((Map)expectedMap.get("bookingdates")).get("checkout"));
        //sec way
        assertEquals(actualMap.get("bookingdates.checkin"), expectedMap.get("bookingdates.checkin"));
        assertEquals(actualMap.get("bookingdates.checkout"), expectedMap.get("bookingdates.checkout"));
    }

    }
