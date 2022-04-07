package com.suracho.climbStairs;

public class ClimbStairs {
    static int climb = 0;
    public static int climbStairs(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            climb++;
        }
        climbStairs(n-1);
        climbStairs(n-2);
        return climb;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
