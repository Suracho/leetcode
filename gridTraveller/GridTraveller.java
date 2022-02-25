package com.suracho.gridTraveller;
//refer to freecodecamps dynamic programming video for question
public class GridTraveller {
    static int[][] dp = new int[18][18];

    public static int gridTraveller(int row,int column){
        if(row == 0 || column == 0){
            return 0;
        }
        if(dp[row-1][column-1]!=0){
            return dp[row-1][column-1];
        }else if(row==1 && column==1){
            return 1;
        } else {
            dp[row-1][column-1]= gridTraveller(row-1,column)+gridTraveller(row,column-1);
            return dp[row-1][column-1];
        }
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(4,3));

    }
}
