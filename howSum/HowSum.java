package com.suracho.howSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HowSum {

    static ArrayList<Integer> collectNum = new ArrayList<>();

    private static ArrayList<Integer> makeHowSum(int targetSum, ArrayList<Integer> numbers, HashMap<Integer,ArrayList<Integer>> memo) {
        if(targetSum==0){
            return collectNum;
        }

        if (memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }

        if (targetSum<0){
            return null;
        }

        for (int i = 0; i < numbers.size(); i++) {
            int remainder = targetSum - numbers.get(i);
            if(makeHowSum(remainder,numbers,memo)!=null){
                collectNum.add(numbers.get(i));
                memo.put(targetSum, collectNum);

                return memo.get(targetSum);
            }
        }

        memo.put(targetSum,null);
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(7,14));
        HashMap<Integer,ArrayList<Integer>> memo = new HashMap<>();
        System.out.println(makeHowSum(300,arr,memo));
    }
}
