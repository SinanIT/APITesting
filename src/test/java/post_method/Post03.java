package post_method;

import BaseUrls.AgroMonitoringApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.AgroMonitoringTestData;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class Post03 extends AgroMonitoringApiBaseUrl {

    @Test
    public void post03() {

        //1.Step: Set the url
        spec.pathParams("first", "agro", "second", 1.0, "third", "polygons").
                queryParam("appid", "f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //2.Step: Set the expected data
        AgroMonitoringTestData requestBody = new AgroMonitoringTestData();
        Map<String, Object> requestBodyMap = requestBody.requestBodySetUp();

        //3.Step: Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().post("/{first}/{second}/{third}");
        response.prettyPrint();

        //Add more key-values into the request body
        requestBodyMap.put("area", 190.9484);

        //Use GSON to convert response to a Map
        Map<String, Object> responseBody = response.as(HashMap.class);
        System.out.println(responseBody);

//        assertEquals(requestBodyMap.get("area"), responseBody.get("area"));
//        assertEquals(requestBodyMap.get("name"), responseBody.get("name"));
//        assertEquals(requestBody.geometrySetUp().get("type"), ((Map) ((Map) responseBody.get("geo_json")).get("geometry")).get("type"));
//
//        assertEquals(String.valueOf(requestBody.coordinates[0][1][0]), ((Map) ((Map) responseBody.get("geo_json")).get("geometry")).get("coordinates").toString().substring(25, 34));
    }
}
