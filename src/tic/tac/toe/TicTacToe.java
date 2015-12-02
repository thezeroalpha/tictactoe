/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Scanner;

/**
 *
 * @author alex
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Set up class instances
        Scanner in = new Scanner(System.in);
        Board board = new Board();

        // Set up variables for win/lose
        // curP is the current piece being used (x or o)
        boolean win = false;
        boolean tie = false;
        char curP = 'x';

        // While there is a free space and nobody's won
        while (!win && !tie) {

            // Show the board to the user
            board.print();
            System.out.println("Turn: " + curP);

            // Collect user input from 'x,y' form
            // Split it into an array
            System.out.print("Enter x,y coordinates: ");
            String[] newMoveString = in.next().split(",");

            // Must convert to int to use in board[][] array
            int xInt = Integer.parseInt(newMoveString[0]);
            int yInt = Integer.parseInt(newMoveString[1]);

            // If you can make this move
            if (board.move(curP, xInt, yInt)) {

                // Check for win & tie right at the beginning
                // Must be done right after move was made, before next turn
                if (board.isWinner(curP)) {
                    win = true;
                }
                if (board.isTied()) {
                    tie = true;
                }

                // Switch the turn (change the piece used) if neither win nor tie
                if (!win && !tie) {
                    switch (curP) {
                        case 'x':
                            curP = 'o';
                            break;
                        default:
                            curP = 'x';
                            break;

                    }
                }

            } // You can't make this move
            // Happens if space is occupied or doesn't exist
            else {
                System.out.println("!!! INVALID MOVE !!!");
                System.out.println("Go again.");
            }
        }

        // Print out the board
        board.print();

        // Show a message depending on what condition occurred
        if (win == true) {
            System.out.println("YOU WON!");
            System.out.println("Winner: " + curP);
        } else if (tie == true) {
            System.out.println("You tied :/");
        }
    }
}
