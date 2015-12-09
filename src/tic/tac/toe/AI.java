/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Random;

/**
 *
 * @author alex
 */
public class AI {
    private char difficulty;
    
    public AI(char difficulty) {
        this.difficulty = difficulty;
    }
    
    public int[] generateCoordinates() {
        Random rand = new Random();
        int x = rand.nextInt(3)+0;
        int y = rand.nextInt(3)+0;
        return new int[]{x,y};
    }
}
