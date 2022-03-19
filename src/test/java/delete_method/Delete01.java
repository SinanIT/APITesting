package delete_method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //set the url
        spec.pathParams("first", "todos","second", "198");

        //Set expected data
        Map<String,Object> expected = new HashMap<>();

        //send delete request
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //assertion Gson//deserialization
        Map<String,Object> actual = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expected, actual);// for delete no need to use get(). Or we can use size method after each map

    }
}
