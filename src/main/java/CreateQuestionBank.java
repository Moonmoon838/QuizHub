import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateQuestionBank {

    public static void createQuestion() throws IOException, ParseException {
        char ch = 's';
        String fileLocation = "./src/main/resources/quiz.json";

        do {
            JSONParser jsonParser = new JSONParser();
            JSONArray questions_Array = (JSONArray) jsonParser.parse(new FileReader(fileLocation));

            JSONObject questionObject = new JSONObject();
            Scanner input = new Scanner(System.in);
            System.out.println("Input your question");
            questionObject.put("question", input.nextLine());
            System.out.println("Input option 1: ");
            questionObject.put("option 1", input.nextLine());
            System.out.println("Input option 2: ");
            questionObject.put("option 2", input.nextLine());
            System.out.println("Input option 3: ");
            questionObject.put("option 3", input.nextLine());
            System.out.println("Input option 4: ");
            questionObject.put("option 4", input.nextLine());
            System.out.println("What is the answer key?");
            questionObject.put("answer key", input.nextInt());


            questions_Array.add(questionObject);
            FileWriter file = new FileWriter(fileLocation);
            file.write(questions_Array.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            ch = input.next().charAt(0);

        }
        while (ch != 'q');
    }
}