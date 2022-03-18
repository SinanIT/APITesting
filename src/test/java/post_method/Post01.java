package post_method;

import BaseUrls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.HerokuAppTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post01 extends HerokuappBaseUrl {
    /*
        Given
	        https://restful-booker.herokuapp.com/booking
	        {
                "firstname": "Selim",
                "lastname": "Ak",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
                 }
              }
        When
	 		I send POST Request to the Url
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
     */

    @Test
    public void post01(){
        //set the url
        spec.pathParam("first", "booking");
        //Set the expected Data
        HerokuAppTestData herokuAppTestData = new HerokuAppTestData();

        //send post request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(herokuAppTestData.expectedDataSetUp()).when().post("/{first}");
        response.prettyPrint();

        //asertion by GSON
        Map<String, Object> actualData = response.as(HashMap.class);

//        assertEquals(200, response.getStatusCode());
//        assertEquals(herokuAppTestData.expectedDataSetUp().get("firstname"), ((Map)actualData.get("booking")).get("firstname"));
//        assertEquals(herokuAppTestData.expectedDataSetUp().get("lastname"), ((Map)actualData.get("booking")).get("lastname"));
//        assertEquals(herokuAppTestData.expectedDataSetUp().get("totalprice"), ((Map)actualData.get("booking")).get("totalprice"));
//        assertEquals(herokuAppTestData.expectedDataSetUp().get("depositpaid"), ((Map)actualData.get("booking")).get("depositpaid"));
//        assertEquals(herokuAppTestData.bookingDatesSetUp().get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
//        assertEquals(herokuAppTestData.bookingDatesSetUp().get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));


        // Assertion by JSON
        JsonPath jp = response.jsonPath();
        assertEquals(herokuAppTestData.expectedDataSetUp().get("firstname"), jp.getString("booking.firstname"));
        assertEquals(herokuAppTestData.expectedDataSetUp().get("lastname"), jp.getString("booking.lastname"));
        assertEquals(herokuAppTestData.expectedDataSetUp().get("totalprice"), jp.getInt("booking.totalprice"));
        assertEquals(herokuAppTestData.expectedDataSetUp().get("depositpaid"), jp.getBoolean("booking.depositpaid"));
        assertEquals(herokuAppTestData.bookingDatesSetUp().get("checkin"), jp.getString("booking.bookingdates.checkin"));
        assertEquals(herokuAppTestData.bookingDatesSetUp().get("checkout"), jp.getString("booking.bookingdates.checkout"));


    }
}
