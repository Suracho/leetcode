package com.suracho.nqueens;

import java.util.*;

public class Nqueens {

    static ArrayList<ArrayList<Integer>> queensBoard = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Tell me number of queens");
        Scanner scanner = new Scanner(System.in);
        int queens = scanner.nextInt();
        queensPlacer(queens);
        System.out.println("queens placements are " + queensBoard + "and the number of solutions are " + queensBoard.size());
    }
    public static void queensPlacer(int n){
        ArrayList<Integer> board = new ArrayList<>();
        queenBackTrack(board,0, n);
    }

    private static void queenBackTrack(ArrayList<Integer> board, int row, int n) {
        if(row==n){
            queensBoard.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
//            if(board.size()-1==row){
//                board.set(row,col);
//            }else {
            board.add(col);
//            }
            if(queensHelp(board)){
                queenBackTrack(board,row+1,n);
            }
            board.remove(board.size()-1);

        }
    }

    public static boolean queensHelp(ArrayList<Integer> board){
        if (board.size()==1){
            return true;
        }
        if (checkColumn(board)){
            return checkDiagonal(board);
        }
        return false;
    }

    private static boolean checkDiagonal(ArrayList<Integer> board) {
        for (int i=0;i<board.size();i++){
            for (int j=1;j<board.size()-i;j++){
                if((board.get(i+j)==board.get(i)+j)||(board.get(i)-j==board.get(i+j))){
                    return false;
                }
            }
        }
        return true;
    }



    public static boolean checkColumn(ArrayList<Integer> board){

        Map<Integer,Integer> dups = new HashMap<>();
        for (int i=0;i<board.size();i++){
            if(!dups.containsKey(board.get(i))){
                dups.put(board.get(i),0);
            }else {
                return false;
            }
        }
        return true;
    }
}
//this is nqueens solution of mine