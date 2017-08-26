import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Controller cont = Controller.getInstance();
        cont.st = stage;

        cont.topicLoader = new FXMLLoader(getClass().getResource("TopicsGUI.fxml"));
        cont.questionLoader = new FXMLLoader(getClass().getResource("QuestionsGUI.fxml"));

        cont.tcp = new TopicChoicerController();
        cont.qc = new QuestionController();

        cont.topicLoader.setController(cont.tcp);
        cont.questionLoader.setController(cont.qc);

        cont.topics = cont.topicLoader.load();
        cont.questions = cont.questionLoader.load();

        cont.topicNode = cont.topics.getCenter();
        cont.questionNode = cont.questions.getCenter();

        cont.scene = new Scene(cont.topics);

        cont.st.setTitle("Quiz");
        cont.st.setScene(cont.scene);
        cont.st.show();
    }

    public static void main(String[] args) {
        QuizApplication.launch(args);
    }
}
