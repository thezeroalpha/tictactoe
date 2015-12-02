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

    private char[][] board = new char[3][3];

    public Board() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("- - - - - - - - -");
        System.out.println("|     0    1    2");
        System.out.println("|");
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

    public boolean move(char piece, int x, int y) {

        // Is the space a thing?
        if (x > 2 || x < 0 || y > 2 || y < 0) {
            return false;
        }

        // Is the space empty?
        if (board[x][y] == ' ') {
            board[x][y] = piece;
            return true;
        } else {
            return false;
        }
    }

    public boolean isWinner(char piece) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) {
                return true;
            }
            if (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece) {
                return true;
            }
        }

        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }

        if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece) {
            return true;
        }
        return false;
    }

    public boolean isTied() {
        if (isWinner('x') || isWinner('o')) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
