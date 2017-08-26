import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class QuestionController {

    @FXML
    private Text questionField;
    @FXML
    private Button answerA;
    @FXML
    private Button answerB;
    @FXML
    private Button answerC;
    @FXML
    private Button answerD;

    private ArrayList<Question> list;
    private Question currentQuestion;

    private Button[] answerList;

    @FXML
    public void initialize() {
        answerList = new Button[] {answerA, answerB, answerC, answerD};
        for (Button btn : answerList) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (((Button )actionEvent.getSource()).getText() == currentQuestion.right_answer) {
                        transitionIntoNextQuestion();
                    }
                }
            });
        }
    }

    @FXML
    public void createQuestions(QuestionFactory.Topics topic) {
        list = QuestionFactory.createQuestions(topic);
    }

    public void setNextQuestion() {
        if (!list.isEmpty()) {
            setCurrentQuestion();
            setQuestionText();
        }
    }

    private void setCurrentQuestion() {
        currentQuestion = list.remove(0);
    }

    private void setQuestionText() {
        questionField.setText(currentQuestion.qstn);
        answerA.setText(currentQuestion.answers.get(0));
        answerB.setText(currentQuestion.answers.get(1));
        answerC.setText(currentQuestion.answers.get(2));
        answerD.setText(currentQuestion.answers.get(3));
    }

    public void resetQuiz() {
        list.clear();
    }

    public void prepQuiz(QuestionFactory.Topics topic) {
        createQuestions(topic);
        setNextQuestion();
    }
}
