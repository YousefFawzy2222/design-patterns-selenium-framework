package utils;
//Data generation has 2 types (Dynamic - Static (Hardcoded))


import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/*
1. static (best of the best)
    1.1 Database snapshot (restore)

//no collaboration or no connection between the test team and db team
2. dynamic
    2.1 Database queries (setup) // INSERT INTO user VALUES ("user1", "user2", "user3") // (fast execution)
    2.2 API endpoints (setup) //POST /users {"email" : "toBeModified@gmail.com"} // network request (slow execution)
    2.3 UI (setup) -> create user through the UI (slow execution) -> u go throw all the steps from the beginning to create a user //CRUD Operations
*/
// excel (not recommended) -> complex / no version control - csv (not recommended) -> complex / no version control - json - properties -> sys.get("email") -> take a key and return a value
public class JsonReader {
    String jsonReader;
    String jsonFileName;
    private final String test_data_path = "src/test/java/test-data/";
    public JsonReader(String jsonFileName){
        this.jsonFileName = jsonFileName;
        try{
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(test_data_path + jsonFileName+".json"));
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public String getJsonReader(String jsonPath) {
        try{
            return JsonPath.read(jsonReader, jsonPath).toString();
        }catch (Exception e){
            System.out.println("Error getting JSON data: " + e.getMessage());
            return "";
        }
    }

}
