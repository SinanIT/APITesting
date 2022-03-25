package put_method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class Put01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
	        {
                "userId": 21,
                "title": "Wash the dishes",
                "completed": false
            }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */
    @Test
    public void put01(){
        //set the url
        spec.pathParams("first","todos","second", 195);

        //set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();

        //send Put Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedDataSetup()).when().put("/{first}/{second}");
        response.prettyPrint();

        //aseert GSON
        Map<String, Object> actual = response.as(HashMap.class);
        System.out.println(actual);

        assertEquals(expected.expectedDataSetup().get("completed"), actual.get("completed"));
        assertEquals(expected.expectedDataSetup().get("title"), actual.get("title"));
        assertEquals(expected.expectedDataSetup().get("userId"), actual.get("userId"));

    }
}
