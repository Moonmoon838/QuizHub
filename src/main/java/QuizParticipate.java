import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuizParticipate {

    public static void quizParticipate() throws IOException, ParseException {

        Scanner scanner = new Scanner(System.in);
        char ch;
        do {
            int marks = 0;
            String fileLocation = "./src/main/resources/quiz.json";
            JSONParser jsonParser = new JSONParser();
            JSONArray questions_Array = (JSONArray) jsonParser.parse(new FileReader(fileLocation));


            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int var = random.nextInt(questions_Array.size() - 1);
                JSONObject questionObj = (JSONObject) questions_Array.get(var);

                String question = questionObj.get("question").toString();
                String option_1 = questionObj.get("option 1").toString();
                String option_2 = questionObj.get("option 2").toString();
                String option_3 = questionObj.get("option 3").toString();
                String option_4 = questionObj.get("option 4").toString();
                String answerKey = questionObj.get("answerkey").toString();

                System.out.println("[Question " + (i + 1) + " ] " + question);
                System.out.println("1. " + option_1);
                System.out.println("2. " + option_2);
                System.out.println("3. " + option_3);
                System.out.println("4. " + option_4);
                System.out.println("Enter your Answer:");
                String ans = scanner.next();

                if (answerKey.equals(ans)) {
                    System.out.println("Correct Answer");
                    marks++;
                } else {
                    System.out.println("Wrong Answer");
                    System.out.println("Correct Answer is option " + answerKey);
                }
            }
            if (marks >= 8) {
                System.out.println("Excellent! You have got " + marks + " out of 10");
            } else if (marks >= 5 && marks < 8) {
                System.out.println("Good. You have got " + marks + " out of 10");
            } else if (marks >= 2 && marks < 5) {
                System.out.println("Very poor! You have got " + marks + " out of 10");
            } else {
                System.out.println("Very sorry you are failed. You have got " + marks + " out of 10");
            }
            System.out.println("Would you like to start again? Press 's' for start or q for quit");
            ch = scanner.next().charAt(0);

            if (ch == 'q') {
                System.out.println("Thank you for participating the Quiz!");
                break;
            }
        }
        while (ch != 'q');

    }
}