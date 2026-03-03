import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameController {
    private Maze maze;
    private Player player;
    private GamePanel panel;
    private TimerManager timer;
    private Stage stage;

    public void initGame(Stage stage) {
        this.stage = stage;
        maze = new Maze(25, 25);
        player = new Player(maze.getStartX(), maze.getStartY());
        panel = new GamePanel(maze, player);
        timer = new TimerManager(panel);

        StackPane root = new StackPane(panel);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("-fx-font-smoothing-type: lcd;");

        scene.setOnKeyPressed(this::handleKeyPress);

        stage.setTitle("Coin Collector Maze Game - Press F for Fullscreen");
        stage.setScene(scene);
        stage.setWidth(550);
        stage.setHeight(650);
        stage.show();

        panel.requestFocus();
        timer.startCountdown();
    }

    private void handleKeyPress(KeyEvent e) {
        if (e.getCode() == KeyCode.F) {
            stage.setFullScreen(!stage.isFullScreen());
        } else if (!panel.isGameOver()) {
            // Only allow movement if game is not over
            if (e.getCode() == KeyCode.UP) {
                player.move(0, -1, maze);
            } else if (e.getCode() == KeyCode.DOWN) {
                player.move(0, 1, maze);
            } else if (e.getCode() == KeyCode.LEFT) {
                player.move(-1, 0, maze);
            } else if (e.getCode() == KeyCode.RIGHT) {
                player.move(1, 0, maze);
            }
            panel.redraw();
            checkGameState();
        }
    }

    private void checkGameState() {
        if (maze.allCoinsCollected() && player.isAt(maze.getExitX(), maze.getExitY())) {
            timer.stop();
            panel.showWinMessage();
        }
    }
}
