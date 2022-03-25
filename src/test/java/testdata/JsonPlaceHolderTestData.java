package testdata;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataSetup(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("userId", 10);
        expected.put("title", "clean your room");
        expected.put("completed", true);
        return expected;


    }
    public Map<String, Object> expectedPatchDataSetup(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("title", "This my new Title");
        return expected;


    }
}
