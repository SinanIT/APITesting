package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {
    //create requestSpecification object
    protected RequestSpecification spec;

    // create a setup method
    @Before// this method will be executed before every test method
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }
}
