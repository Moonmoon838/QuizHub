import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) throws IOException, ParseException {

        try {
            String fileLocation = "./src/main/resources/users.json";

            JSONParser parser = new JSONParser();
            JSONArray users_Array = (JSONArray) parser.parse(new FileReader(fileLocation));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username:");
            String username = scanner.next();
            System.out.println("Enter password:");
            String password = scanner.next();

            for (int i = 0; i < users_Array.size(); i++) {
                JSONObject userObject = (JSONObject) users_Array.get(i);
                String user_name = userObject.get("username").toString();
                String pass_word = userObject.get("password").toString();
                String role = userObject.get("role").toString();

                if (username.equals(user_name) && password.equals(pass_word)) {
                    if (role.equals("admin")) {
                        System.out.println("Welcome admin! Please create new questions in the question bank.");
                        CreateQuestionBank.createQuestion();
                        break;
                    } else if (role.equals("student")) {
                        System.out.println("Welcome " + user_name + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' for start.");
                        char ch = scanner.next().charAt(0);
                        if (ch == 's') {
                            QuizParticipate.quizParticipate();
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }
}