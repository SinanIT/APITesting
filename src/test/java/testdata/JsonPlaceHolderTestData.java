package testdata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataSetup(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("userId", 98);
        expected.put("title", "clean your room");
        expected.put("completed", false);
        return expected;

    }
}
