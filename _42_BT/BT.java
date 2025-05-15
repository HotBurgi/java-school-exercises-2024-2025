package _42_BT;

import java.util.ArrayList;
import java.util.Random;

public class BT {
    private int energy;
    private int existenceTime;
    private Position position;
    private boolean alive;

    public BT(int x, int y) {
        this.energy = 100;
        this.existenceTime = 0;
        this.position = new Position(x, y);
        this.alive = true;
    }

    public void move(Board board) {
        Random random = new Random();
        ArrayList<String> possibleDirections = searchFood(board);
        boolean moved = false;

        if (possibleDirections.isEmpty()) {
            while (!moved) {
                moved = moveDiagonally(board);
            }
            return;
        }

        int direction = random.nextInt(possibleDirections.size());
        String moveDirection = possibleDirections.get(direction);

        switch (moveDirection) {
            case "up":
                if (this.position.getX() - 1 >= 0 && board.getBoard()[this.position.getX() - 1][this.position.getY()] != 1) {
                    this.position.setX(this.position.getX() - 1);
                    moved = true;
                }
                break;
            case "down":
                if (this.position.getX() + 1 < board.getBoard().length && board.getBoard()[this.position.getX() + 1][this.position.getY()] != 1) {
                    this.position.setX(this.position.getX() + 1);
                    moved = true;
                }
                break;
            case "left":
                if (this.position.getY() - 1 >= 0 && board.getBoard()[this.position.getX()][this.position.getY() - 1] != 1) {
                    this.position.setY(this.position.getY() - 1);
                    moved = true;
                }
                break;
            case "right":
                if (this.position.getY() + 1 < board.getBoard().length && board.getBoard()[this.position.getX()][this.position.getY() + 1] != 1) {
                    this.position.setY(this.position.getY() + 1);
                    moved = true;
                }
                break;
        }
    }

    private boolean moveDiagonally(Board board) {
        boolean moved = false;
        Random random = new Random();
        int x = this.position.getX();
        int y = this.position.getY();
        int direction = random.nextInt(4);

        switch (direction) {
            case 0: //top-left
                if (x - 1 >= 0 && y - 1 >= 0 && board.getBoard()[x - 1][y - 1] != 1) {
                    this.position.setX(x - 1);
                    this.position.setY(y - 1);
                    moved = true;
                }
                break;
            case 1: //top-right
                if (x - 1 >= 0 && y + 1 < board.getBoard().length && board.getBoard()[x - 1][y + 1] != 1) {
                    this.position.setX(x - 1);
                    this.position.setY(y + 1);
                    moved = true;
                }
                break;
            case 2: //bottom-left
                if (x + 1 < board.getBoard().length && y - 1 >= 0 && board.getBoard()[x + 1][y - 1] != 1) {
                    this.position.setX(x + 1);
                    this.position.setY(y - 1);
                    moved = true;
                }
                break;
            case 3: //bottom-right
                if (x + 1 < board.getBoard().length && y + 1 < board.getBoard().length && board.getBoard()[x + 1][y + 1] != 1) {
                    this.position.setX(x + 1);
                    this.position.setY(y + 1);
                    moved = true;
                }
                break;
        }
        return false;
    }

    public ArrayList<String> searchFood(Board board) {
        int x = this.position.getX();
        int y = this.position.getY();

        ArrayList<String> possibleDirections = new ArrayList<>();
        // Check down (x++)
        for (int i = x + 1; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][y] == 2) {
                break;
            } else if (board.getBoard()[i][y] == 2) {
                possibleDirections.add("down");
                break;
            }
        }
        // Check up (x--)
        for (int i = x - 1; i > 0; i--) {
            if (board.getBoard()[i][y] == 2) {
                break;
            } else if (board.getBoard()[i][y] == 2) {
                possibleDirections.add("up");
                break;
            }
        }
        // Check right (y++)
        for (int i = y + 1; i < board.getBoard().length; i++) {
            if (board.getBoard()[x][i] == 2) {
                break;
            } else if (board.getBoard()[x][i] == 2) {
                possibleDirections.add("right");
                break;
            }
        }
        // Check left (y--)
        for (int i = y - 1; i > 0; i--) {
            if (board.getBoard()[x][i] == 2) {
                break;
            } else if (board.getBoard()[x][i] == 2) {
                possibleDirections.add("left");
                break;
            }
        }

        return possibleDirections;
    }

    public void consumeEnergy() {
        this.energy -= 10;
    }

    public void restoreEnergy(int mult) {
        this.energy += 10 * mult;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getExistenceTime() {
        return existenceTime;
    }

    public void setExistenceTime(int existenceTime) {
        this.existenceTime = existenceTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
