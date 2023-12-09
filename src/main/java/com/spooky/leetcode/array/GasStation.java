package com.spooky.leetcode.array;

public class GasStation {

    // uses greedy algo, try to assume the current station will work if not, assume the next station
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int startStation = 0;
        int remainingGas = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            // currentGas = remainingGas + (gas from current station - cost for next station)
            remainingGas += gas[i] - cost[i];

            if (remainingGas < 0) {
                // if current station won't work, assume the next station is going to work
                remainingGas = 0;
                startStation = i + 1;
            }
        }

        if (totalCost > totalGas) {
            return -1;
        }
        return startStation;
    }

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int res = new GasStation().canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

}
