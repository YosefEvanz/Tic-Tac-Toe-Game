// Yosyp Vasyliev
// Tic-Tac-Toe game

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        ArrayList<String> defTTT = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            defTTT.add("_");
        } // end of for loop

        Scanner scanner = new Scanner(System.in);

        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) {
                System.out.println("Computer's Turn:");
                makeComputerMove(defTTT);
            } else {
                System.out.println("Your Turn:");
                makeUserMove(defTTT, scanner);
            } // end of if/else statement
            printBoard(defTTT);

            // Check for draw
            if (turn == 8) {
                System.out.println("It's a draw!");
            } // end of if
        } // end of for loop

        scanner.close(); // Close the scanner when done
    } // end of main method

    // Method to make the computer's move
    public static void makeComputerMove(ArrayList<String> board) {
        Random rand = new Random();
        String compTurn = "x";
        int emptyIndex = -1;

        // Loop until the computer finds an empty spot
        while (emptyIndex == -1) {
            int placeNum = rand.nextInt(9); // Random index between 0 and 8
            if (board.get(placeNum).equals("_")) {
                emptyIndex = placeNum;
                board.set(emptyIndex, compTurn);
                System.out.println("Computer chooses index: " + emptyIndex); // Debugging output
            } // end of if statement
        } // end of while loop
    } // end of makeComputerMove loop

    // Method to let the user make their move
    public static void makeUserMove(ArrayList<String> board, Scanner scanner) {
        int userRow, userColumn, index;
        boolean validMove = false;

        // Loop until the user enters a valid move
        while (!validMove) {
            System.out.println("Enter the number of the row of the space you want to fill (1-3): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number between 1 and 3:");
                scanner.next(); // Consume invalid input
            } // end of while loop
            userRow = scanner.nextInt();
            while (userRow < 1 || userRow > 3) {
                System.out.println("Invalid row. Enter a number between 1 and 3:");
                userRow = scanner.nextInt();
            } // end of while loop
            System.out.println("Enter the number of the column of the space you want to fill (1-3): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number between 1 and 3:");
                scanner.next(); // Consume invalid input
            } // end of while loop
            userColumn = scanner.nextInt();
            while (userColumn < 1 || userColumn > 3) {
                System.out.println("Invalid column. Enter a number between 1 and 3:");
                userColumn = scanner.nextInt();
            } // end of while loop

            // Calculate the index based on row and column
            index = (userRow - 1) * 3 + (userColumn - 1);

            // Check if the spot is empty
            if (board.get(index).equals("_")) {
                board.set(index, "o");
                validMove = true;
            } else {
                System.out.println("This spot is already taken. Try another one!");
            } // end of if/else statement
        } // end of while loop
    } // end of makeUserMove method

    // Method to print the board after each move
    public static void printBoard(ArrayList<String> board) {
        for (int i = 0; i < 9; i++) {
            System.out.print(board.get(i));
            if ((i + 1) % 3 != 0) {
                System.out.print("|");
            } else {
                System.out.println();
            }// end of if/else
        } // end of for loop
    } // end of printBoard method
} // end of TicTacToe class