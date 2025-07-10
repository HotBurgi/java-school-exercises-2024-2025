package _42_BT;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final static int SIZE = 8;

    private int[][] board;
    private ArrayList<BT> btList;

    public Board() {
        this.board = new int[SIZE][SIZE];
        this.btList = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            addBT();
        }
    }

    public void movePopulation() {
        for (BT bt : btList) {
            if (bt.getEnergy() > 0) {
                bt.move(this);
            } else {
                removeBT(bt);
            }
        }

        updateBoard();
    }

    private void addBT() {
        Random random = new Random();

        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (board[x][y] == 1);

        BT bt = new BT(x, y);
        this.btList.add(bt);

        updateBoard();
    }

    public void updateBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] < 2)
                    board[i][j] = 0;
            }
        }

        for (BT bt : btList) {
            Position pos = bt.getPosition();
            board[pos.getX()][pos.getY()] = 1;
        }
    }

    public void removeBT(BT bt) {
        this.btList.remove(bt);
    }

    public void spawnFood() {
        Random random = new Random();
        boolean spawned = false;
        int x, y;

        while (!spawned) {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

            switch (this.board[x][y]) {
                case 0:
                    this.board[x][y] = 2;
                    spawned = true;
                    break;
                case 1:
                    for (BT bt : btList) {
                        Position pos = bt.getPosition();
                        if (pos.getX() == x && pos.getY() == y) {
                            bt.restoreEnergy(2);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.board[x][y] += 2;
                    spawned = true;
                    break;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public ArrayList<BT> getBtList() {
        return btList;
    }

    public void setBtList(ArrayList<BT> btList) {
        this.btList = btList;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
