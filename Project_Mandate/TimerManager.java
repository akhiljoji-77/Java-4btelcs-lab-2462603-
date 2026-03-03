import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TimerManager {
    private int timeLeft = 100; // seconds
    private final Timeline timeline;
    private final GamePanel panel;

    public TimerManager(GamePanel panel) {
        this.panel = panel;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> tick()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void startCountdown() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    private void tick() {
        timeLeft--;
        panel.updateTimer(timeLeft);
        panel.redraw();
        if (timeLeft <= 0) {
            stop();
            panel.setGameOver(true);
            panel.showGameOverMessage();
        }
    }
} // End of TimerManager.java