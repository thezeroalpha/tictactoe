/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Random;
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
        AI myAI = new AI();

        // Set up variables for win/lose
        // curP is the current piece being used (x or o)
        boolean win = false;
        boolean tie = false;
        boolean ai = false;
        String difficulty;
        char curP;
        char winP='x';

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.print("How many players? ");
        int numPlayers = in.nextInt();

        boolean aiset = false;
        while (aiset == false) {
            if (numPlayers == 1) {
                ai = true;
                System.out.print("Easy? ");
                difficulty = in.next();
                if (difficulty.contains("y")) {
                    myAI.setDifficulty('e');
                } else {
                    myAI.setDifficulty('h');
                }
                aiset = true;
            } else if (numPlayers == 2) {
                ai = false;
                aiset = true;
            } else {
                System.out.println("Invalid entry.");
            }
        }

        if (ai == true && numPlayers == 1) {
            Random random = new Random();
            curP = (random.nextInt() % 2 == 0) ? 'x' : 'o';
        } else {
            curP = 'x';
        }

        // First turn
        if (curP == 'o' && ai && numPlayers == 1) {
            board.print();
            System.out.println("AI goes first");
            boolean moved = false;
            while (moved == false) {
                int[] coordinates = myAI.generateCoordinates();
                if (board.move('o', coordinates[0], coordinates[1])) {
                    moved = true;
                    if (board.isWinner(curP)) {
                        win = true;
                        winP = curP;
                    }
                    if (board.isTied()) {
                        tie = true;
                    }
                } else {
                    moved = false;
                }
            }

            switch (curP) {
                case 'x':
                    curP = 'o';
                    break;
                default:
                    curP = 'x';
                    break;

            }

        }
        
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
                    winP = curP;
                }
                if (board.isTied()) {
                    tie = true;
                }

                if (numPlayers == 1 && !win && !tie) {
                    boolean moved = false;
                    while (moved == false) {
                        int[] coordinates = myAI.generateCoordinates();
                        if (board.move('o', coordinates[0], coordinates[1])) {
                            moved = true;
                            if (board.isWinner('o')) {
                                win = true;
                                winP = 'o';
                                
                            }
                            if (board.isTied()) {
                                tie = true;
                            }
                        } else {
                            moved = false;
                        }
                    }
                } 
                else {
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
            if (ai && numPlayers==1 && winP=='o') {
                System.out.println("AI WON!");
            }
            else {
            System.out.println("YOU WON!");
            }
        } else if (tie == true) {
            System.out.println("You tied :/");
        }
    }

    public void AIMove() {

    }
}
