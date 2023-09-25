import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUserList {
    public static void main(String[] args) throws IOException, ParseException {

        String fileLocation = "./src/main/resources/users.json";

        JSONParser parser = new JSONParser();
        JSONArray users_Array = (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject adminObject = new JSONObject();
        JSONObject studentObject = new JSONObject();

        adminObject.put("username", "admin");
        adminObject.put("password", "1234");
        adminObject.put("role", "admin");

        studentObject.put("username", "salman");
        studentObject.put("password", "1234");
        studentObject.put("role", "student");

        users_Array.add(adminObject);
        users_Array.add(studentObject);

        FileWriter fileWriter = new FileWriter(fileLocation);
        fileWriter.write(users_Array.toJSONString());
        fileWriter.flush();
        fileWriter.close();


    }
}