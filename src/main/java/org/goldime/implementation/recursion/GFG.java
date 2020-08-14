package org.goldime.implementation.recursion;

import java.util.Arrays;

// Complexity - O(3^N)
public class GFG {
    private int maxGold;
    private int n;
    private int m;

    public int getMaxGold(int[][] gold, int n, int m) {
        if (isEmpty(gold) || isInvalidParameters(gold, n, m)) {
            return 0;
        } else if (isTranspose(gold)) {
            return Arrays.stream(transpose(gold))
                    .sum();
        }
        this.n = n;
        this.m = m;

        for (int i = 0, j = 0; i < n; ++i) {
            findMaxGold(gold, i, j, gold[i][j]);
        }
        return maxGold;
    }

    private boolean isEmpty(int[][] gold) {
        return gold == null || gold.length == 0 || gold[0].length == 0;
    }

    private boolean isTranspose(int[][] gold) {
        return gold[0].length == 1;
    }

    private int[] transpose(int[][] gold) {
        int[] transpose = new int[gold.length];
        for (int i = 0; i < gold.length; ++i) {
            transpose[i] = gold[i][0];
        }
        return transpose;
    }

    private boolean isInvalidParameters(int[][] gold, int n, int m) {
        return gold.length != n || gold[0].length != m;
    }

    private void findMaxGold(int[][] gold, int i, int j, int currentMaxGold) {
        if (j + 1 == m && currentMaxGold > maxGold) {
            maxGold = currentMaxGold;
            return;
        }

        if (i - 1 >= 0 && j + 1 < m) {
            findMaxGold(gold, i - 1, j + 1, currentMaxGold + gold[i - 1][j + 1]);
        }
        if (j + 1 < m) {
            findMaxGold(gold, i, j + 1, currentMaxGold + gold[i][j + 1]);
        }
        if (i + 1 < n && j + 1 < m) {
            findMaxGold(gold, i + 1, j + 1, currentMaxGold + gold[i + 1][j + 1]);
        }
    }

    public static void main(String[] args) {
        int[][] gold = { // 83
                {10, 33, 13, 15},
                {22, 21, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}
        };

        int maxAmountOfGold = new GFG().getMaxGold(gold, gold.length, gold[0].length);
        System.out.println("Res = " + maxAmountOfGold);
    }
}
