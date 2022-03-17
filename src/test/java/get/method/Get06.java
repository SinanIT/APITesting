package get.method;

import BaseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get06 extends JsonPlaceHolderBaseUrl {
    /*
    When
    I send GET request https://jsonplaceholder.typicode.com/todos
    Then
    Status code is 200
    1- Print all ids greater than 190 on the console
    Assert that there are 10 ids grater then 190
    2- Print all userIds less than 5
    Assert that maximum age less than 5 is 4
    3- Print all titles whose ids are less than 11
    Assert that "delectus aut autem" is one titles whose is less than 5
     */

    @Test
    public void get01(){
        spec.pathParam("first", "todos");

        //set expected data

        // send the request
        Response response = given().spec(spec).when().get("/{first}");
       // response.prettyPrint();

//        1- Print all ids greater than 190 on the console
//        Assert that there are 10 ids grater then 190
        JsonPath jp= response.jsonPath();
        List<Integer> idList =  jp.getList("findAll{it.id>190}.id");//==>groovy language looking ids // [191, 192, 193, 194, 195, 196, 197, 198, 199, 200]
        List<Integer> titleIDList =  jp.getList("findAll{it.id>190}.title");//==>groovy language looking titles which their ids grater than 190 //[temporibus atque distinctio omnis eius impedit tempore molestias pariatur, ut quas possimus exercitationem sint voluptates, rerum debitis voluptatem qui eveniet tempora distinctio a, sed ut vero sit molestiae, rerum ex veniam mollitia voluptatibus pariatur, consequuntur aut ut fugit similique, dignissimos quo nobis earum saepe, quis eius est sint explicabo, numquam repellendus a magnam, ipsam aperiam voluptates qui]
        List<Integer> userIDList =  jp.getList("findAll{it.id>190}.userId");//==>groovy language looking titles which their ids grater than 190 //[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
//        System.out.println(idList);
//        System.out.println(titleIDList);
//        System.out.println(userIDList);
        assertEquals(10, idList.size());

//        2- Print all userIds less than 5
//        Assert that maximum age less than 5 is 4
        List<Integer> userIdList= jp.getList("findAll{it.userId<5}.userId");
        //System.out.println(userIdList);
        Collections.sort(userIdList);
        assertEquals((Integer)4, userIdList.get(userIdList.size()-1));

//        3- Print all titles whose ids are less than 11
//        Assert that "delectus aut autem" is one titles whose is less than 5

        List<String > titleLIst = jp.getList("findAll{it.id<5}.title");
        System.out.println(titleLIst);//[delectus aut autem, quis ut nam facilis et officia qui, fugiat veniam minus, et porro tempora]
        assertTrue(titleLIst.stream().anyMatch(t->t.equals("delectus aut autem")));

    }
}
