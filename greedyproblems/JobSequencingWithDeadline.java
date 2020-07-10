package com.shashi.dsalgo.greedyproblems;

import java.util.*;

//Sort jobs according to profit
//Process sorted jobs
//for every job, find a time slot i, such that slot is empty and i < deadline
// and i is greatest.Put the job in this slot and mark this slot filled.
//if not free slot, skip the job

class ItemJob {

    public char id;        //Job id
    public int deadline;   //Deadline
    public int profit;     //profit

    public ItemJob(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

}

class MyJobComparator implements Comparator<ItemJob> {

    @Override
    public int compare(ItemJob o1, ItemJob o2) {
        return o2.profit - o1.profit;
    }

}

public class JobSequencingWithDeadline {

    public static void main(String[] args) {

        char[] jobId = {'a', 'b', 'c', 'd', 'e'};
        int[] jobDealine = {3, 3, 3, 4, 4};
        int[] jobprofit = {2, 4, 3, 1, 10};

        printJobsequencing(jobId, jobDealine, jobprofit);

    }

    public static void printJobsequencing(char[] jobsArray, int[] deadlineArray, int profitArray[]) {

        int totalProfit = 0;

        //Sort all jobs
        List<ItemJob> itemJobList = new ArrayList<>();
        for (int i = 0; i < profitArray.length; i++)
            itemJobList.add(new ItemJob(jobsArray[i], deadlineArray[i], profitArray[i]));

        Collections.sort(itemJobList, new MyJobComparator());

        int[] result = new int[profitArray.length];     //To store the seqeuence of Jobs done
        Arrays.fill(result, -1);

        //iterate through all given jobs
        for (int i = 0; i < profitArray.length; i++) {

            //Find a free slot for the job from last possible slot
            for (int j = itemJobList.get(i).deadline - 1; j >= 0; j--) {
                //free slot found
                if (result[j] == -1) {
                    totalProfit += itemJobList.get(i).profit;
                    result[j] = i;
                    break;
                }
            }

        }

        //Print the result
        for (int i = 0; i < itemJobList.size(); i++) {
            if (result[i] != -1) {
                System.out.print(itemJobList.get(result[i]).id + " ");
            }
        }
        System.out.println("\nTotal profit: " + totalProfit);
    }

}
