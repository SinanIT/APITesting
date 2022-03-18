package get.method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Deserialization1 extends JsonPlaceHolderBaseUrl {
    /*
        ---- DE-SERIALIZATION: Converting json data to any java object.

        Data types is challenge in API.

        ----- SERIALIZATION : Converting Java objects to json data

        to do DE-SERIALIZATION and SERIALIZATION we have two methods.
        (we need dependencies)
        a- Using Gson
        b- Object Mapper

     */

    /*

     When
    I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
    then
    HTTP Status code should be 200
    And completed is false
    ANd userId is 1
    And title is "quiz nam facilis et officia qui"
    and heather Via is 1.1 Vegur
    and header Server is cloudflare
     */

    @Test
    public void get01(){
        spec.pathParams("first", "todos", "second", 2);

        // Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("completed", false);
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");

        //send request
        Response response =  given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class); // as method coming from GSON
        System.out.println(actualData);

        //assertion
        assertEquals(expectedData.get("statusCode"), response.getStatusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));

    }
}
