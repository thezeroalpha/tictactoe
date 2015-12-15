/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author alex
 */
public class Board {
    
    // Define the board as a 3x3 grid (array)
    private char[][] board = new char[3][3];
    
    // Initialize the array with empty spaces (free spots on board)
    public Board() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = ' ';
            }
        }
    }
    
    // Getting piece in space
    public char getSpace(int x, int y) {
        return board[x][y];
    }
    // Printing (much fluff for pretty design)
    public void print() {
        System.out.println("- - - - - - - - -");
        System.out.println("| x:  0    1    2");
        System.out.println("| y");
        for (int y = 0; y < 3; y++) {
            System.out.print("| " + y + " ");
            for (int x = 0; x < 3; x++) {
                System.out.print(" |" + board[x][y] + "| ");
            }
            System.out.println("");
        }
        System.out.println("- - - - - - - - -");
        System.out.println("");
    }
    
    // Makes a move
    public boolean move(char piece, int x, int y) {

        // Is the space a thing?
        if (x > 2 || x < 0 || y > 2 || y < 0) {
            return false;
        }

        // Is the space empty?
        if (board[x][y] == ' ') {
            board[x][y] = piece; // Set the space to x or o
            return true; // Yes, move was executed
        } else {
            return false; // Not executed, sum ting wong
        }
    }
    
    // Tests for winning conditions
    public boolean isWinner(char piece) {
        
        // Checks rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) {
                return true;
            }
            if (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece) {
                return true;
            }
        }
        
        // Checks diagonal
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }
        
        // Checks diagonal
        if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece) {
            return true;
        }
        
        // Obviously, if not winning conditions, isWinner is false
        return false;
    }
    
    // Checks if all spaces are occupied
    public boolean isTied() {
        
        // If there's a winner, there can't be a tie!
        if (isWinner('x') || isWinner('o')) {
            return false;
        }
        
        // Goes through each space individually, checking if it's empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == ' ') {
                    return false;
                }
            }
        }

        return true; // If no empty spaces, it's a tie
    }
}
