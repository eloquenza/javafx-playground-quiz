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
                        fadeButtonBackground(btn, true);
                        transitionIntoNextQuestion();
                    } else {
                        fadeButtonBackground(btn, false);
                    }
                }
            });
        }
    }

    private void transitionIntoNextQuestion() {
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished( event -> {
            setNextQuestion();
        } );
        delay.play();
    }

    private void fadeButtonBackground(Button btn, boolean green) {
        String backGroundCSS = "-fx-background-color: rgb(";
        if (green) {
            backGroundCSS += "0,%f,0);";
        } else {
            backGroundCSS += "%f,0,0);";
        }
        final DoubleProperty color = new SimpleDoubleProperty(0);
        btn.styleProperty().bind(
                Bindings.format(backGroundCSS, color)
        );

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(color, 40)),
                new KeyFrame(Duration.millis(100), new KeyValue(color, 80)),
                new KeyFrame(Duration.millis(200), new KeyValue(color, 100)),
                new KeyFrame(Duration.millis(300), new KeyValue(color, 150)),
                new KeyFrame(Duration.millis(400), new KeyValue(color, 200)),
                new KeyFrame(Duration.millis(500), new KeyValue(color, 255))
        );
        timeline.play();
    }

    @FXML
    public void createQuestions(QuestionFactory.Topics topic) {
        list = QuestionFactory.createQuestions(topic);
    }

    public void setNextQuestion() {
        if (!list.isEmpty()) {
            resetAnswerButtons();
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

    public void resetAnswerButtons() {
        for (Button btn : answerList) {
            btn.styleProperty().unbind();
            btn.setStyle(null);
        }
    }

    public void resetQuiz() {
        list.clear();
        resetAnswerButtons();
    }

    public void prepQuiz(QuestionFactory.Topics topic) {
        createQuestions(topic);
        setNextQuestion();
    }
}
