package pojo_test;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;
import utils.JasonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class PojotestWithPostRequest extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 21,
            "id": 201
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 21,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post1(){
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        TodosPojo expectedPojo = new TodosPojo(21,"Clean your room", false);
        System.out.println(expectedPojo.getUserId());//21
        System.out.println(expectedPojo.getTitle());//clean your room
        System.out.println(expectedPojo.isCompleted());// false

        //send the request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{first}");
        response.prettyPrint();

                //assert GSON to convert response body to TodosPojo
//        TodosPojo actualPojo = response.as(TodosPojo.class);
//        System.out.println("Coming from GSON" + actualPojo);
//        assertEquals(201, response.getStatusCode());
//        assertEquals(expectedPojo.getUserId(), actualPojo.getUserId());
//        assertEquals(expectedPojo.getTitle(), actualPojo.getTitle());
//        assertEquals(expectedPojo.isCompleted(), actualPojo.isCompleted());

                // Object Mapper to convert response body TodosPojo
        TodosPojo actualPojo2 = JasonUtil.convertJsonToJava(response.asString(), TodosPojo.class);
        System.out.println("Coming from ObjectMapper " +actualPojo2);
        assertEquals(201, response.getStatusCode());
        assertEquals(expectedPojo.getUserId(), actualPojo2.getUserId());
        assertEquals(expectedPojo.getTitle(), actualPojo2.getTitle());
        assertEquals(expectedPojo.isCompleted(), actualPojo2.isCompleted());

    }

}
