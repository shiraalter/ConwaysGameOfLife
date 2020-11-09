package touro.ConwaysGameOfLife;

public class Grid {

    private boolean[][] board;
    private Direction[] directions = Direction.values();

    private final int WIDTH = 40;
    private final int HEIGHT = 40;


    public Grid() {
        this.board = new boolean[WIDTH][HEIGHT];
    }


    public void makeMove() {
        boolean[][] tempBoard = new boolean[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int aliveNeighbors = countAliveNeighbors(x, y);

                if (board[x][y]) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        board[x][y] = false;
                        //setDead(x, y);
                    } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        board[x][y] = true;
                        //setAlive(x, y);
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        board[x][y] = true;
                        //setAlive(x, y);
                    }
                }
            }
        }
        board = tempBoard;
    }

    public int countAliveNeighbors(int x, int y) {
        int aliveNeighborCount = 0;
        for (Direction d : directions) {
            boolean isAlive = checkDirection(d, x, y);      //check neighbor status
            if (isAlive) {                                    //if neighbor cell is has true val, increment live neighbors
                aliveNeighborCount++;
            }
        }
        return aliveNeighborCount;
    }

    public boolean isAlive(int x, int y) {
        return board[x][y];
    }

    public void setAlive(int x, int y) {
        board[x][y] = true;
    }

    /**
     * @return value of cell is 0 - dead
     */
    public void setDead(int x, int y) {
        board[x][y] = false;

    }


    public boolean checkDirection(Direction direction, int x, int y) {
        switch (direction) {
            case North:
                boolean inBounds = checkInBounds(x, y + 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x][y + 1];
                }

            case East:
                inBounds = checkInBounds(x + 1, y);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x + 1][y];
                }

            case South:
                inBounds = checkInBounds(x, y - 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x][y - 1];
                }

            case West:
                inBounds = checkInBounds(x - 1, y);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x - 1][y];
                }

            case NorthEast:
                inBounds = checkInBounds(x + 1, y + 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x + 1][y + 1];
                }
            case NorthWest:
                inBounds = checkInBounds(x - 1, y + 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x - 1][y + 1];
                }
            case SouthEast:
                inBounds = checkInBounds(x + 1, y - 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x + 1][y - 1];
                }
            case SouthWest:
                inBounds = checkInBounds(x - 1, y - 1);
                if (!inBounds) {
                    return false;
                } else {
                    return board[x - 1][y - 1];
                }
            default:
                throw new RuntimeException(direction + " is not a known Direction");    //why does this prevent needing a return statement?
        }
    }


    /**
     * @param x,y
     * @return checks if a cell is in bounds
     */
    public boolean checkInBounds(int x, int y) {
        return !(x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT);
    }

    public void clearBoard() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setDead(x, y);
            }

        }
    }

    public boolean[][] getBoard() {
        return board;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    public int getWidth() {
        return this.WIDTH;
    }

}
