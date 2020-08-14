package org.goldime.implementation.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class GFGTest {
    private GFG gfg = new GFG();

    @Test
    public void shouldReturnZeroInCaseOfEmptyArray() {
        int[][] emptyGold = {{}};
        int maxGold = gfg.getMaxGold(emptyGold, emptyGold.length, emptyGold[0].length);
        assertEquals(0, maxGold);
    }

    @Test
    public void shouldReturnZeroInCaseOfInvalidInputParameters() {
        int[][] gold = {{1, 2, 4}};
        int maxGold = gfg.getMaxGold(gold, gold.length, 2);
        assertEquals(0, maxGold);
    }

    @Test
    public void shouldReturnMaxInCaseOfOneDArray() {
        int[][] gold = {{4, 6, 7, 2}};
        int maxGold = gfg.getMaxGold(gold, gold.length, gold[0].length);
        assertEquals(19, maxGold);
    }

    @Test
    public void shouldReturnMaxInCaseOfTransposeOneDArray() {
        int[][] gold = {
                {4},
                {6},
                {7},
                {2}
        };
        int maxGold = gfg.getMaxGold(gold, gold.length, gold[0].length);
        assertEquals(19, maxGold);
    }

    @Test
    public void shouldReturnMax() {
        int[][] gold = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2},
        };
        int maxGold = gfg.getMaxGold(gold, gold.length, gold[0].length);
        assertEquals(16, maxGold);
    }
}