import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class TopicChoicerController {

    @FXML
    private Button historyBtn;
    @FXML
    private Button religionBtn;
    @FXML
    private Button mathBtn;
    @FXML
    private Button politicsBtn;
    @FXML
    private Button swapmeBtn;
    @FXML
    private MenuItem restart;

    @FXML
    public void initialize() {
        Controller cont = Controller.getInstance();
        historyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cont.startQuiz(QuestionFactory.Topics.HISTORY);
            }
        });
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                restart();
            }
        });
    }

    private void restart() {
        Controller cont = Controller.getInstance();
        cont.resetQuiz();
    }
}
