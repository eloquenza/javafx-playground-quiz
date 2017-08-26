import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    Stage st;

    TopicChoicerController tcp;
    QuestionController qc;

    FXMLLoader topicLoader;
    FXMLLoader questionLoader;

    Scene scene;

    BorderPane topics;
    BorderPane questions;

    Node topicNode;
    Node questionNode;

    final Label l = new Label("Quiz over!");
    StackPane overlay;

    // Pay attention to volatile
    private static volatile Controller INSTANCE = null;

    private Controller() {
        createOverlay();
    }

    public static Controller getInstance() {
        if (INSTANCE == null) { // Check 1
            synchronized (Controller.class) {
                if (INSTANCE == null) { // Check 2
                    INSTANCE = new Controller();
                }
            }
        }
        return INSTANCE;
    }

    public void createOverlay() {
        overlay = new StackPane();
        StackPane.setAlignment(l, Pos.CENTER);
        overlay.getChildren().add(l);
    }

    public void fadeIntoScene(Duration time, Node node) {
        FadeTransition ft = new FadeTransition(time, node);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    public void swapToQuestions() {
        topics.setCenter(questionNode);
    }

    public void swapToTopics() {
        topics.setCenter(topicNode);
    }

    public void swapToFinishOverlay() {
        topics.setCenter(overlay);
    }

}
