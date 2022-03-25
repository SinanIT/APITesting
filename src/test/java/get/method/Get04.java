package get.method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class Get04 extends JsonPlaceHolderBaseUrl {

    /*
    When
    I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
    then
    HTTP Status code should be 200
    And
    Response format should be "application/json
    And
    there should be 200 todos
    And
    "quis eius est sint explicabo" should be on of todos
    And
    2, 7 and 9 should be amaong the userIDs

     */

    @Test
    public void get04(){
        //set the url
        spec.pathParam("first", "todos");

        //set the expected data
        Response response = given().spec(spec).accept("application/JSON").when().get("/{first}");
        response.prettyPrint();

        //assert the output
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)// we can also use "application/json" inside the content type method
                .body("id", hasSize(200), "title", hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2 ,7 ,9));
    }

}
