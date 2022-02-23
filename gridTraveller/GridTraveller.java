package com.suracho.gridTraveller;
//refer to freecodecamps dynamic programming video for question
public class GridTraveller {
    public static int gridTraveller(int row,int column){
        if(row == 0 || column == 0){
            return 0;
        }

        if(row==1 || column==1){
            return 1;
        }

        return gridTraveller(row-1,column) + gridTraveller(row,column-1);

    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(3,3));
    }
}
