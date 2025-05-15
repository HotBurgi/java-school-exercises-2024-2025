package _42_BT;

import java.util.ArrayList;
import java.util.Random;

public class BT {
    private int energy;
    private int existenceTime;
    private final Position position;
    private boolean alive;

    public BT(int x, int y) {
        this.energy = new Random().nextInt(11) + 50; // Random energy between 50 and 60
        this.existenceTime = 0;
        this.position = new Position(x, y);
        this.alive = true;
    }

    public void move(Board board) {
        if (!alive) return;

        int moves = 0;
        while (moves < 3) {
            ArrayList<String> directions = searchFood(board);
            if (!directions.isEmpty()) {
                moveInDirection(directions.get(new Random().nextInt(directions.size())), board);
                break;
            } else {
                if (moveToAdjacent(board)) break;
            }
            moves++;
        }

        consumeEnergy();
        if (energy <= 0) {
            alive = false;
        }
    }

    private void moveInDirection(String direction, Board board) {
        int x = position.getX();
        int y = position.getY();

        switch (direction) {
            case "up":
                position.setX(x - 1);
                break;
            case "down":
                position.setX(x + 1);
                break;
            case "left":
                position.setY(y - 1);
                break;
            case "right":
                position.setY(y + 1);
                break;
        }
    }

    private boolean moveToAdjacent(Board board) {
        Random random = new Random();
        int x = position.getX();
        int y = position.getY();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {
            int dx = directions[i][0];
            int dy = directions[i][1];
            int newX = x + dx;
            int newY = y + dy;

            if (newX >= 0 && newX < board.getBoard().length && newY >= 0 && newY < board.getBoard()[0].length
                    && board.getBoard()[newX][newY] == 0) {
                position.setX(newX);
                position.setY(newY);
                return true;
                }
        }
        return false;
    }

    public ArrayList<String> searchFood(Board board) {
        ArrayList<String> directions = new ArrayList<>();
        int x = position.getX();
        int y = position.getY();
        int[][] grid = board.getBoard();

        if (x > 0 && grid[x - 1][y] == 2) directions.add("up");
        if (x < grid.length - 1 && grid[x + 1][y] == 2) directions.add("down");
        if (y > 0 && grid[x][y - 1] == 2) directions.add("left");
        if (y < grid[0].length - 1 && grid[x][y + 1] == 2) directions.add("right");

        return directions;
    }

    public void consumeEnergy() {
        energy -= 1;
    }

    public void restoreEnergy(int restored) {
        energy += restored;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public void incrementExistenceTime() {
        existenceTime++;
    }
    }