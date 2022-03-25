package get.method;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;


public class Get05 extends HerokuappBaseUrl {
    /*
    When
    I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
    Then
    Http status code should be 200
    AND
    response content type is "application/JSON"
    And
    response body should be like
    { "firstname": "Sally",
      "lastname": "Ericsson",
      "totalprice": 111,
      "depositpaid": false,
      "bookingdates": { "checkin": "2017-05-23",
                        "checkout": "2019-07-02" }


     */

    @Test
    public void get01(){
        spec.pathParams("first", "booking", "second", 24);
        //set the expected data

        //send request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //assert output
//        response.then().assertThat()
//                .statusCode(200).contentType(ContentType.JSON)
//                .body("firstname", equalTo("CEMCEM"),
//                        "lastname", equalTo("YILMAZ"),
//                        "totalprice", equalTo(111),
//                        "depositpaid", equalTo(false),
//                        "bookingdates.checkin", equalTo("2017-05-23"),
//                        "bookingdates.checkout", equalTo("2019-07-02"));

        //JSON PATH CLASS we use it to navigate inside jason data
        JsonPath json = response.jsonPath();
//        //second assert way
//        assertEquals("Status code is not matching", 200, response.getStatusCode());
//        assertEquals("Contents type is not application/json", "application/json; charset=utf-8", response.getContentType());
//        assertEquals("First name is not matching", "CEMCEM", json.getString("firstname"));
//        assertTrue("Last name is not matching", json.getString("lastname").equals("YILMAZ"));
//        assertTrue("Total Price is not matching", json.getInt("totalprice")==111);
//        assertTrue("Depositpaid is not matching", json.getBoolean("depositpaid")==false);
//        assertEquals("Checkin date is not matching", "2017-05-23", json.getString("bookingdates.checkin"));
//        assertEquals("Checkout date is not matching","2019-07-02", json.getString("bookingdates.checkout"));
//        assertTrue("Checkout date is not matching",json.getString("bookingdates.checkout").equals("2019-07-02")); // asserTrue version


        //Soft Assertion (Verification) Execution won't stop in failure
        /*
            Steps:
            1- Create an object from SoftAssert class
            2-by using the object, use asserEquals(), assertTrue(), assertFalse()
            3-DO NOT FORGET to use assertAll() method at the end.
         */
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(json.getString("firstname"), "CEMCEM", "Firstname is not matching");
        sa.assertEquals(json.getString("lastname"), "YILMAZ", "Lastname is not matching");
        sa.assertEquals(json.getInt("totalprice"), 111, "totalprice is not matching");
        sa.assertEquals(json.getString("bookingdates.checkin"),"2017-05-23", "Checkin date is not matching");
        sa.assertEquals(json.getString("bookingdates.checkout"),"2019-07-02", "Checkout date is not matching");
        sa.assertAll();//always use this method when do soft assertion




    }




}
