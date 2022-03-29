package pojo_test;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;
import utils.JasonUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class PostRequestWithPost02 extends HerokuappBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
                                        {
                                        "bookingid": 11,
                                        "booking": {
                                            "firstname": "Mary",
                                            "lastname": "Smith",
                                            "totalprice": 647,
                                            "depositpaid": false,
                                            "bookingdates": {
                                                "checkin": "2016-02-05",
                                                "checkout": "2021-01-16"
                                            }
                                        }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "firstname": "Mary",
                                    "lastname": "Smith",
                                    "totalprice": 647,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2016-02-05",
                                        "checkout": "2021-01-16"
                                     }
                                     "additionalneeds": "Breakfast"
                                  }
     */

    @Test
    public void post01(){
        //spec.pathParam("first", "booking");

        //set the data
        BookingDatePojo bookingdatePojo = new BookingDatePojo("2016-02-05","2021-01-16");
        BookingPojo expectedPojo = new BookingPojo("Mary", "Smith", 647,false, bookingdatePojo);
        System.out.println(expectedPojo);

        //send post request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post();
        response.prettyPrint();
    }























}

