package com.suracho.bestSum;

import java.util.ArrayList;
import java.util.Arrays;

public class BestSum {
    static ArrayList<Integer> collectNum = new ArrayList<>();
    public static ArrayList<Integer> makeBestSum(int targetSum,ArrayList<Integer> numbers){
        if(targetSum==0){
            return collectNum;
        }

        if (targetSum<0){
            return null;
        }

        for (int i = 0; i < numbers.size(); i++) {
            int remainder = targetSum - numbers.get(i);
            if(makeBestSum(remainder,numbers)!=null){
                collectNum.add(numbers.get(i));
                return collectNum;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(5,3,4,7));
        System.out.println(makeBestSum(7,arr));
    }
}
