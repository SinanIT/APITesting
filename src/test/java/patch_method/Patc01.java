package patch_method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import testdata.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class Patc01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
	        {
                "title": "new Title",
            }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */
    @Test
    public void patch01(){
        //set the url
        spec.pathParams("first","todos","second", 198);

        //set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();

        //Send Patch equest
        //send Put Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedPatchDataSetup()).when().patch("/{first}/{second}");
        response.prettyPrint();

        //assert
        response .then().assertThat().statusCode(200)
                .body("title", Matchers.equalTo(expected.expectedPatchDataSetup().get("title")),
                        "userId", Matchers.equalTo(expected.expectedDataSetup().get("userId")),
                        "completed", Matchers.equalTo(expected.expectedDataSetup().get("completed")));
    }
}
