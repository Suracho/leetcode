package com.suracho.KThGrammer;

import java.util.ArrayList;

public class KThGrammar {
    static ArrayList<ArrayList<Integer>> pyramid = new ArrayList<ArrayList<Integer>>();
    public static int kthGrammar(int n, int k) {
        if(n<= pyramid.size()){
            return pyramid.get(n - 1).get(k-1);
        }else{
            makePyramid(n,pyramid, new ArrayList<Integer>());
            return pyramid.get(n - 1).get(k-1);
        }
    }
    public static void makePyramid(int n,ArrayList<ArrayList<Integer>>  pyramid,ArrayList<Integer> prev){
        if(n==0){
            return;
        }

        ArrayList<Integer> row =  new ArrayList<Integer>();

        if(prev.isEmpty()){
            row.add(0);
        }else{
            for(Integer i:prev){
                if(i==0){
                    row.add(0);
                    row.add(1);
                }else{
                    row.add(1);
                    row.add(0);
                }
            }
        }

        pyramid.add(row);
        prev=row;
        makePyramid(--n,pyramid,prev);

    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(30,434991989));
    }
}
