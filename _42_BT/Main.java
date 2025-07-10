package _42_BT;

public class Main {
    public static void main(String[] args) {
        // Create a new board
        Board board = new Board();

        // Spawn food on the board
        board.spawnFood();
        board.spawnFood();

        // Print the initial state of the board
        System.out.println("Initial Board State:");
        board.printBoard();

        // Simulate movement and energy consumption for each BT
        for (BT bt : board.getBtList()) {
            System.out.println("\nBT Initial Position: (" + bt.getPosition().getX() + ", " + bt.getPosition().getY() + ")");
            board.
            bt.consumeEnergy();
            System.out.println("BT After Move Position: (" + bt.getPosition().getX() + ", " + bt.getPosition().getY() + ")");
            System.out.println("BT Energy: " + bt.getEnergy());
        }

        // Update and print the final state of the board
        board.updateBoard();
        System.out.println("\nFinal Board State:");
        board.printBoard();
    }
}