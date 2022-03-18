package post_method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testdata.JsonPlaceHolderTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
public class Post02 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01(){
        //set the url
        spec.pathParam("first", "todos");

        //set expected data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();

        //send request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData.expectedDataSetup()).when().post("/{first}");
        response.prettyPrint();

        //assert
        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.expectedDataSetup().get("userId"), jsonPath.getInt("userId"));
        assertEquals(expectedData.expectedDataSetup().get("title"), jsonPath.getString("title"));
        assertEquals(expectedData.expectedDataSetup().get("completed"), jsonPath.getBoolean("completed"));

        //assert2
        //GSON
//        Map<String, Object> actualData= response.as(HashMap.class);
//        System.out.println(actualData);
//        assertEquals(201, response.getStatusCode());
//        assertEquals(expectedData.expectedDataSetup().get("completed"), actualData.get("completed"));
//        assertEquals(expectedData.expectedDataSetup().get("title"), actualData.get("title"));
//        assertEquals(expectedData.expectedDataSetup().get("userId"), actualData.get("userId"));

        //soft assertion with jason path (verification)
//        SoftAssert sa = new SoftAssert();
//        sa.assertEquals(jsonPath.getInt("userId"), expectedData.expectedDataSetup().get("userId"), "UserIs does not match");
//        sa.assertEquals(jsonPath.getBoolean("completed"), expectedData.expectedDataSetup().get("completed"), "completed does not match");
//        sa.assertEquals(jsonPath.getString("title"), expectedData.expectedDataSetup().get("title"), "title does not match");
//        sa.assertAll();// always execute this after soft assertion

        //assertion by using body method
        response.then().assertThat()
                .statusCode(201)
                .body("completed", equalTo(false),
                        "userId", equalTo(98),
                        "title", equalTo("clean your room"));

    }

}
