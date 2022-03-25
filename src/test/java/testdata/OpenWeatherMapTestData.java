package testdata;

import java.util.*;

public class OpenWeatherMapTestData {

    public Map<String, Float> coordSeteup(){
        Map<String, Float> coord = new HashMap<>();
        coord.put("lon", -0.1257f);
        coord.put("lat", 51.5085f);
        return coord;
    }

    public Map<String, Object> weatherSetup(){
        Map<String, Object> weather = new HashMap<>();
        weather.put("id", 802);
        weather.put("main", "Clouds");
        weather.put("description", "scattered clouds");
        weather.put("icon", "03n");
        return weather;
    }
    List<Map> weather = Arrays.asList(weatherSetup());

    public Map<String, Float> mainSetup(){
        Map<String, Float> main = new HashMap<>();
        main.put("feels_like", 273.51f);
        main.put("temp_min", 276f);
        main.put("temp_max", 279.26f);
        main.put("pressure", 1026f);
        main.put("humidity", 88f);
        return main;
    }
    public Map<String, Float> windSetup() {
        Map<String, Float> wind = new HashMap<>();
        wind.put("speed", 5.66f);
        wind.put("deg", 270f);
        return wind;
    }
//    public Map<String, Float> rainSetup() {
//        Map<String, Float> rain = new HashMap<>();
//        rain.put("all", 40f);
//        return cloud;
//    }
    public Map<String, Float> cloudSetup() {
        Map<String, Float> cloud = new HashMap<>();
        cloud.put("all", 40f);
        return cloud;
    }

    public Map<String, Object> sysSetup() {
        Map<String, Object> sys = new HashMap<>();
        sys.put("type", 2);
        sys.put("id", 2019646);
        sys.put("country", "GB");
        sys.put("sunrise", 1647497428);
        sys.put("sunset", 1647540444);
        return sys;
    }

    public Map<String, Object> expectedDataSetup(){
        Map<String, Object> expected = new HashMap<>();
        expected.put("coord", coordSeteup());
        expected.put("weather", weatherSetup());
        expected.put("base", "stations");
        expected.put("main", mainSetup());
        expected.put("visibility", 10000);
        expected.put("wind", windSetup());
        expected.put("dt", 1647487665);
        expected.put("timezone", 0);
        expected.put("id", 2643743);
        expected.put("name", "London");
        expected.put("cod", 200);

        return expected;
    }

}
