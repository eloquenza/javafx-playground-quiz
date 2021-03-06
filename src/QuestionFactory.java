import java.util.ArrayList;
import java.util.Collections;

public class QuestionFactory {

    public enum Topics {
        HISTORY, MATH, RELIGION, POLITICS, OTHER
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
            case MATH:
                return MathQuestionsFactory.createQuestions();
            case RELIGION:
                return ReligionQuestionsFactory.createQuestions();
            case POLITICS:
                return PoliticsQuestionsFactory.createQuestions();
            case OTHER:
                return OtherQuestionsFactory.createQuestions();
        }
        return new ArrayList<Question>();
    }
}
