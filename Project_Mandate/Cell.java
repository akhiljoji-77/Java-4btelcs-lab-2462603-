
public class Cell {
    public static final int SIZE = 20; // for drawing

    private boolean isWall;
    private boolean hasCoin;
    private boolean isExit;

    public Cell() {
        this.isWall = true;
        this.hasCoin = false;
        this.isExit = false;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean isWall) {
        this.isWall = isWall;
    }

    public boolean hasCoin() {
        return hasCoin;
    }

    public void setCoin(boolean hasCoin) {
        this.hasCoin = hasCoin;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }
} // End of Cell.java