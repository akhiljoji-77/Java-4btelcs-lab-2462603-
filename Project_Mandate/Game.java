import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameController controller = new GameController();
        controller.initGame(primaryStage);
    }
}
