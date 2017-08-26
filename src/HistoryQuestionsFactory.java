import java.util.ArrayList;
import java.util.Arrays;

public class HistoryQuestionsFactory {
    public static ArrayList<Question> createQuestions() {
        Question q1 = new Question(
                "Which American inventor is generally given credit for the invention of the lightning rod?",
                new String[]{
                        "Benjamin Franklin",
                        "Papa Joe",
                        "Donald Trump",
                        "Barack Obama"}
        );
        Question q2 = new Question(
                "Jimmy Carter was the first U.S. president born in a what?",
                new String[]{
                        "Hospital",
                        "Bathtub",
                        "Room full of people",
                        "Church"}
        );
        return new ArrayList<Question>(Arrays.asList(q1, q2));
    }
}
