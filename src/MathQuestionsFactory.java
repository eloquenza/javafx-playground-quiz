import java.util.ArrayList;
import java.util.Arrays;

public class MathQuestionsFactory {
    public static ArrayList<Question> createQuestions() {
        Question q1 = new Question(
                "What number does \"giga\" stand for?",
                new String[]{
                        "One billion",
                        "One million",
                        "One hundred",
                        "One thousand"}
        );
        Question q2 = new Question(
                "What digit did Arab mathematician al-Khwarizmi give to the West around 800 B/B.?",
                new String[]{
                        "0",
                        "1",
                        "7",
                        "42"}
        );
        return new ArrayList<Question>(Arrays.asList(q1, q2));
    }
}
