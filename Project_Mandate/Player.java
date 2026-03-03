public class Player {
    private int x, y;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(int dx, int dy, Maze maze) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= 0 && newY >= 0 && newX < maze.getCols() && newY < maze.getRows()) {
            Cell target = maze.getCell(newX, newY);
            if (!target.isWall()) {
                x = newX;
                y = newY;
                if (target.hasCoin()) {
                    target.setCoin(false);
                }
            }
        }
    }

    public boolean isAt(int tx, int ty) {
        return this.x == tx && this.y == ty;
    }

    public int getX() { return x; }
    public int getY() { return y; }
} // End of Player.java