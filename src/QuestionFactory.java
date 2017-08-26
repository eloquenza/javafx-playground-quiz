import java.util.ArrayList;
import java.util.Collections;

public class QuestionFactory {

    public enum Topics {
        HISTORY
    }

    public static ArrayList<Question> createQuestions(Topics topic) {
        ArrayList<Question> list = createQuestionsImpl(topic);
        Collections.shuffle(list);
        return list;
    }

    private static ArrayList<Question> createQuestionsImpl(Topics topic) {
        switch (topic) {
            case HISTORY:
                return HistoryQuestionsFactory.createQuestions();
        }
        return new ArrayList<Question>();
    }
}
