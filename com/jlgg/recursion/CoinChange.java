package com.jlgg.recursion;

public class CoinChange {

    // Returns the count of ways we can
    // sum coins[0...numCoins-1] coins to get sum targetMoney
    static int count(int coins[], int numCoins, int targetMoney) {
        // If targetMoney is 0 then there is 1 solution (do not include any coin)
        if (targetMoney == 0) {
            return 1;
        }
        // If targetMoney is less than 0 then no solution exists
        if (targetMoney < 0) {
            return 0;
        }
        // If there are no coins and targetMoney is greater than 0, then no solution exist
        if (numCoins <= 0 && targetMoney >= 1) {
            return 0;
        }

        // count is sum of solutions (a) including coins[numCoins-1] (b) excluding coins[numCoins-1]
        return count(coins, numCoins - 1, targetMoney) +
               count(coins, numCoins, targetMoney - coins[numCoins - 1]);
    }

    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        int solutions = count(denominations, denominations.length, targetMoney);
        return solutions >= 1 ? true : false;
    }

    public static void main(String[] args) {
        int targetMoney = 75;
        int[] denominations = {4, 17, 29};
        System.out.println(canGetExactChange(targetMoney, denominations));
    }
}
