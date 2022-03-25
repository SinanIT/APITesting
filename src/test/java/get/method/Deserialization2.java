package get.method;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Deserialization2 extends HerokuappBaseUrl {
    /*
    When
    I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
    Then
    Http status code should be 200
    AND
    response content type is "application/JSON"
    And
    response body should be like
    {
        "firstname": "Henri",
        "lastname": "ConcOn",
        "totalprice": 111,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2017-05-23",
            "checkout": "2019-07-02"
        }


     */

    @Test
    public void get01(){
        //sett the url
        spec.pathParams("first", "booking", "second", 28);

        //set the expected data we have two json data
        // 1- create inner map
        Map<String, String> bookinddates = new HashMap<>();
        bookinddates.put("checkin", "2017-05-23");
        bookinddates.put("checkout", "2019-07-02");

        //Outer Map

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname", "Henri");
        expectedDataMap.put("lastname", "Concon");
        expectedDataMap.put("totalprice", 111);
        expectedDataMap.put("depositpaid", false);
        expectedDataMap.put("bookingdates", bookinddates);

        System.out.println(expectedDataMap);//firstname=Henri, bookingdates={checkin=2017-05-23, checkout=2019-07-02}, totalprice=111, depositpaid=false, lastname=Concon}


        //send request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //deserialization using by GSON
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap); //firstname=Henri, bookingdates={checkin=2017-05-23, checkout=2019-07-02}, totalprice=111, depositpaid=false, lastname=Concon}

        //assert the output with java
        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));


    }
}
