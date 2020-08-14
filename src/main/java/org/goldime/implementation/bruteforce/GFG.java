package org.goldime.implementation.bruteforce;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Complexity - O(n^2)
public class GFG {
    public int getMaxGold(int[][] gold, int n, int m) {
        if (isEmpty(gold) || isInvalidParameters(gold, n, m)) {
            return 0;
        } else if (isOneD(gold)) {
            return Arrays.stream(m == 1 ? transpose(gold) : gold[0])
                    .sum();
        }

        for (int column = m - 2; column >= 0; --column) {
            gold[0][column] += Math.max(gold[0][column + 1], gold[1][column + 1]);
            for (int row = 1; row < n - 1; ++row) {
                gold[row][column] += Math.max(
                        Math.max(gold[row - 1][column + 1], gold[row][column + 1]), gold[row + 1][column + 1]);
            }
            gold[n - 1][column] += Math.max(gold[n - 1][column + 1], gold[n - 2][column + 1]);
        }

        return Stream.of(gold)
                .flatMapToInt(IntStream::of)
                .max()
                .orElse(0);
    }

    private boolean isEmpty(int[][] gold) {
        return gold == null || gold.length == 0 || gold[0].length == 0;
    }

    private boolean isInvalidParameters(int[][] gold, int n, int m) {
        return gold.length != n || gold[0].length != m;
    }

    private boolean isOneD(int[][] gold) {
        return gold.length == 1 || gold[0].length == 1;
    }

    private int[] transpose(int[][] gold) {
        int[] transpose = new int[gold.length];
        for (int i = 0; i < gold.length; ++i) {
            transpose[i] = gold[i][0];
        }
        return transpose;
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
