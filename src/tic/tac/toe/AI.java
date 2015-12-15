/*
 * AI Class for Tic-Tac-Toe in Java
 * Copyright (c) 2015 Alexander Balgavy <a.balgavy@gmail.com>
 * Distributed under the WTFNMF Public License
 *
 * The AI class for Tic-Tac-Toe, contains coordinate generation.
 *
 * Length: 40 lines
 */

package tic.tac.toe;

import java.util.Random;

/**
 *
 * @author Alex Balgavy
 */
public class AI {

    private char difficulty;

    public AI() {
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    public char getDifficulty() {
        return difficulty;
    }

    public int[] generateCoordinates() {
        Random rand = new Random();
        int x = rand.nextInt(3) + 0;
        int y = rand.nextInt(3) + 0;
        return new int[]{x, y};
    }
}
