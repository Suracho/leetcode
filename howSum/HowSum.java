package com.suracho.howSum;

import java.util.ArrayList;
import java.util.Arrays;

public class HowSum {

    static ArrayList<Integer> collectNum = new ArrayList<>();

    private static ArrayList<Integer> makeHowSum(int targetSum, ArrayList<Integer> numbers) {
        if(targetSum==0){
            return collectNum;
        }

        if (targetSum<0){
            return null;
        }

        for (int i = 0; i < numbers.size(); i++) {
            int remainder = targetSum - numbers.get(i);
            if(makeHowSum(remainder,numbers)!=null){
                collectNum.add(numbers.get(i));
                return collectNum;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(5,3,4,7));
        System.out.println(makeHowSum(7,arr));
    }
}
