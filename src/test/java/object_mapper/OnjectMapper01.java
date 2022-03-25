package object_mapper;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JasonUtil;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.HashMap;

public class OnjectMapper01 extends JsonPlaceHolderBaseUrl {
    /*
    When
    I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
    then
    HTTP Status code should be 200
    And respond body is like
    {
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
     */

    @Test
    public void get01(){
        //set the url
        spec.pathParams("first", "todos", "second", "198");

        //set the expected data
        String expected ="{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "}";
        //covert expected data to java
        HashMap<String, Object> expectedData= JasonUtil.convertJsonToJava(expected, HashMap.class);

        //Send threquest
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //conver actual data to Java
        HashMap<String, Object> actualData = JasonUtil.convertJsonToJava(response.asString(), HashMap.class);

        //assert the output
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }

}
