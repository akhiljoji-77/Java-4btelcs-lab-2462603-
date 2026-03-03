import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GamePanel extends VBox {
    private final Maze maze;
    private final Player player;
    private final Canvas canvas;
    private final Canvas timerCanvas;
    private boolean gameOver = false;

    public GamePanel(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
        this.canvas = new Canvas(maze.getCols() * Cell.SIZE, maze.getRows() * Cell.SIZE);
        this.timerCanvas = new Canvas(maze.getCols() * Cell.SIZE, 25);  // Reduced height to 25
        
        // Create centered wrapper for canvas
        StackPane canvasWrapper = new StackPane(canvas);
        canvasWrapper.setAlignment(Pos.CENTER);
        canvasWrapper.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(canvasWrapper, Priority.ALWAYS);
        
        // Set timer canvas to fill width and have fixed height
        timerCanvas.setHeight(25);
        
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(0);
        this.getChildren().addAll(canvasWrapper, timerCanvas);
        
        // Update timer canvas width when panel is resized
        this.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();
            if (width > 0 && width < 1000000) {  // Sanity check
                timerCanvas.setWidth(width);
            }
        });
        
        redraw();
    }

    public void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int y = 0; y < maze.getRows(); y++) {
            for (int x = 0; x < maze.getCols(); x++) {
                Cell cell = maze.getCell(x, y);
                double px = x * Cell.SIZE;
                double py = y * Cell.SIZE;

                if (cell.isWall()) {
                    gc.setFill(Color.DARKGRAY);
                    gc.fillRect(px, py, Cell.SIZE, Cell.SIZE);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(px, py, Cell.SIZE, Cell.SIZE);
                    if (cell.hasCoin()) {
                        gc.setFill(Color.GOLD);
                        gc.fillOval(px + 3, py + 3, 14, 14);
                    } else if (cell.isExit()) {
                        gc.setFill(Color.LIGHTGREEN);
                        gc.fillRect(px + 2, py + 2, Cell.SIZE - 4, Cell.SIZE - 4);
                    }
                }
            }
        }
        // Draw Player
        gc.setFill(Color.RED);
        gc.fillOval(player.getX() * Cell.SIZE + 2, player.getY() * Cell.SIZE + 2, 16, 16);
    }

    public void updateTimer(int timeLeft) {
        GraphicsContext gc = timerCanvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, timerCanvas.getWidth(), timerCanvas.getHeight());
        gc.setFill(Color.BLACK);
        gc.setFont(new Font(14));
        String timerText = "Time: " + timeLeft + "s";
        // Center the text horizontally
        double textWidth = gc.getFont().getSize() * (timerText.length() * 0.5);
        double timerX = (timerCanvas.getWidth() - textWidth) / 2;
        gc.fillText(timerText, timerX, 17);
    }

    public void showWinMessage() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(new Color(0, 0, 0, 0.7));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(40));
        gc.fillText("You Win!", canvas.getWidth()/2 - 80, canvas.getHeight()/2);
    }

    public void showGameOverMessage() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(new Color(0, 0, 0, 0.7));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.RED);
        gc.setFont(new Font(50));
        gc.fillText("GAME OVER", canvas.getWidth()/2 - 130, canvas.getHeight()/2);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(25));
        gc.fillText("Time's Up!", canvas.getWidth()/2 - 70, canvas.getHeight()/2 + 40);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }
} // End of GamePanel.java