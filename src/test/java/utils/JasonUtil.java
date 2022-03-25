package utils;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class JasonUtil {

    /**
     Converting Json Data to Java Object ==> DeSerialization
     */
    //1- create an object mapper class object

    private static ObjectMapper mapper;
    static{
        mapper = new ObjectMapper();
    }
    // 2- create deserialization method
    public static <T> T convertJsonToJava(String json, Class<T> cls){
        T javaResult = null;
        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            System.out.println("Json could not be converted to Java Object " + e.getMessage());
        }
        return javaResult;
    }

    // 2-  Converting Java Object to Json Data ==>Serialization
    public static String convertJavaToJson(Object obj){
        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("Java object could not be converted to Json data " + e.getMessage());
        }
        return jsonResult;
    }

}
