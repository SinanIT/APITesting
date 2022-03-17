package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class OpenWeatherBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://api.openweathermap.org").build();
    }
}
