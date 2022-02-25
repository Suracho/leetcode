package com.suracho.canSum;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    static Map<Integer,Boolean> hm = new HashMap<>();


    public static boolean canSum(int sum,int[] sumArr){
        if(sum<0){
            return false;
        }

        if (sum==0){
            return true;
        }

        for (int i = 0; i < sumArr.length; i++) {
            if(canSum(sum-sumArr[i],sumArr)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s = new int[]{3};
        System.out.println(canSum(7,s));

    }
}
