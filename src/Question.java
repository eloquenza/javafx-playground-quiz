import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {

    public String qstn;
    public List<String> answers;
    public String right_answer;

    public Question(String question, String[] answers) {
        qstn = question;
        right_answer = answers[0];
        this.answers = Arrays.asList(answers);
        Collections.shuffle(this.answers);
    }
}
