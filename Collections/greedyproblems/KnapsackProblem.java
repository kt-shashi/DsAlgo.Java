package com.shashi.dsalgo.greedyproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weights = {10, 40, 20, 30};
        int[] profits = {60, 40, 100, 120};
        int capacity = 50;

        int[] w2 = {10, 20, 30, 40, 50};
        int[] p2 = {5, 4, 3, 2, 1};

        System.out.println(solveKnapsack(weights, profits, capacity));
        System.out.println(solveKnapsack(w2,p2,80));
    }

    public static double solveKnapsack(int[] weight, int[] profit, int capacity) {

        List<ItemValue> itemValues = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            itemValues.add(new ItemValue(weight[i], profit[i]));
        }

        //Sort the list
        Collections.sort(itemValues, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost - o1.cost;
            }
        });

        double totalValue = 0d;

        for (ItemValue i : itemValues) {

            int currentWeight = i.getWeight();
            int currentProfit = i.getProfit();

            if (capacity - currentWeight >= 0) {
                //this weight can be picked
                capacity = capacity - currentWeight;
                totalValue += currentProfit;
            } else {
                //full item cannot be picked
                double fraction = (double) capacity / (double) currentWeight;
                totalValue += currentProfit * fraction;
                capacity = (int) (capacity - (currentWeight * fraction));
                break;
            }
        }

        return totalValue;

    }

}

class ItemValue {

    public int weight;
    public int profit;
    public int cost;

    public ItemValue(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.cost = profit / weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getProfit() {
        return profit;
    }

    public int getCost() {
        return cost;
    }
}