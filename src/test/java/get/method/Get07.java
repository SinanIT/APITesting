package get.method;

import BaseUrls.OpenWeatherBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.OpenWeatherMapTestData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get07 extends OpenWeatherBaseUrl {
    /*

     */

    @Test
    public void get01(){
        //https://api.openweathermap.org/data/2.5/weather?q=London&appid=8947c516ec2a26a6845025c87752719e

        spec.pathParams("first", "data", "second",2.5, "third", "weather")
                .queryParams("q","London", "appid", "8947c516ec2a26a6845025c87752719e");

        // set the expected data
        OpenWeatherMapTestData expectedData = new OpenWeatherMapTestData();

        //send the request
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //navigate to response
        JsonPath jp = response.jsonPath();

        // assert output
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.coordSeteup().get("lat"), (Float) jp.getFloat("coord.lat") );
        assertEquals(expectedData.weatherSetup().get("main"), jp.getString("weather[0].main"));
        assertEquals(expectedData.expectedDataSetup().get("base"), jp.getString("base"));
        assertEquals(expectedData.mainSetup().get("humidity"), (Float)jp.getFloat("main.humidity") );
        assertEquals(expectedData.expectedDataSetup().get("visibility"), jp.getInt("visibility"));

    }
}
