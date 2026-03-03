import java.util.*;

public class Maze {
    private final int rows;
    private final int cols;
    private final Cell[][] grid;
    private int startX = 1, startY = 1;
    private int exitX, exitY;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        generateMaze();
        placeCoins(10);
        placeExit();
    }

    private void generateMaze() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[y][x] = new Cell();
            }
        }
        dfs(startX, startY);
    }

    private void dfs(int x, int y) {
        grid[y][x].setWall(false);
        int[][] dirs = {{0,-2},{0,2},{-2,0},{2,0}};
        Collections.shuffle(Arrays.asList(dirs));

        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (inBounds(nx, ny) && grid[ny][nx].isWall()) {
                grid[y + dir[1]/2][x + dir[0]/2].setWall(false);
                dfs(nx, ny);
            }
        }
    }

    private boolean inBounds(int x, int y) {
        return x > 0 && y > 0 && x < cols - 1 && y < rows - 1;
    }

    private void placeCoins(int count) {
        Random rand = new Random();
        int placed = 0;
        while (placed < count) {
            int x = rand.nextInt(cols);
            int y = rand.nextInt(rows);
            if (!grid[y][x].isWall() && !grid[y][x].hasCoin() && (x != startX || y != startY)) {
                grid[y][x].setCoin(true);
                placed++;
            }
        }
    }

    private void placeExit() {
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(cols);
            int y = rand.nextInt(rows);
            if (!grid[y][x].isWall() && !grid[y][x].hasCoin() && (x != startX || y != startY)) {
                grid[y][x].setExit(true);
                exitX = x;
                exitY = y;
                break;
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[y][x];
    }

    public int getStartX() { return startX; }
    public int getStartY() { return startY; }
    public int getExitX() { return exitX; }
    public int getExitY() { return exitY; }

    public boolean allCoinsCollected() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid[y][x].hasCoin()) return false;
            }
        }
        return true;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
} // End of Maze.java