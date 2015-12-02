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
        Scanner in = new Scanner(System.in);

        Board board = new Board();

        boolean win = false;
        boolean tie = false;
        char curP = 'x';

        while (!win && !tie) {
            
            board.print();
            System.out.println("Turn: " + curP);

            System.out.print("Enter x,y coordinates: ");
            String[] newMoveString = in.next().split(",");
            
            int xInt = Integer.parseInt(newMoveString[0]);
            int yInt = Integer.parseInt(newMoveString[1]);
            
            if (board.move(curP, xInt, yInt)) {
                
                if (board.isWinner(curP)) win=true;
                if (board.isTied()) tie=true;
                
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

            } else {
                System.out.println("!!! INVALID MOVE !!!");
                System.out.println("Go again.");
            }
        }
        board.print();

        if (win == true) {
            System.out.println("YOU WON!");
            System.out.println("Winner: "+curP);
        } else if (tie == true) {
            System.out.println("You tied :/");
        }
    }
}
