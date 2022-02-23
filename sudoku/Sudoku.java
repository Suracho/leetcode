package com.suracho.sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    private static ArrayList<ArrayList<String>> sudoku = new ArrayList<ArrayList<String>>();
//    private static ArrayList<ArrayList<String>> dummySudoku = new ArrayList<ArrayList<String>>();
    static int terminator;

    public static void main(String[] args) {
        sudoku.add(new ArrayList<>(Arrays.asList("5","3",".",".","7",".",".",".",".")));
        sudoku.add(new ArrayList<>(Arrays.asList("6",".",".","1","9","5",".",".",".")));
        sudoku.add(new ArrayList<>(Arrays.asList(".","9","8",".",".",".",".","6",".")));
        sudoku.add(new ArrayList<>(Arrays.asList("8",".",".",".","6",".",".",".","3")));
        sudoku.add(new ArrayList<>(Arrays.asList("4",".",".","8",".","3",".",".","1")));
        sudoku.add(new ArrayList<>(Arrays.asList("7",".",".",".","2",".",".",".","6")));
        sudoku.add(new ArrayList<>(Arrays.asList(".","6",".",".",".",".","2","8",".")));
        sudoku.add(new ArrayList<>(Arrays.asList(".",".",".","4","1","9",".",".","5")));
        sudoku.add(new ArrayList<>(Arrays.asList(".",".",".",".","8",".",".","7","9")));

//        dummySudoku.add(new ArrayList<>(Arrays.asList("5","3","2",".","7",".",".",".",".")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList("5","7","4","1","9","5",".",".",".")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList("1","9","8",".",".",".",".","6",".")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList("8",".",".",".","6",".",".",".","3")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList("4",".",".","8",".","3",".",".","1")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList("7",".",".",".","2",".",".",".","6")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList(".","6",".",".",".",".","2","8",".")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList(".",".",".","4","1","9",".",".","5")));
//        dummySudoku.add(new ArrayList<>(Arrays.asList(".",".",".",".","8",".",".","7","9")));

        makeMeASudoku(sudoku);
        System.out.println(sudoku);
    }

    private static void makeMeASudoku(ArrayList<ArrayList<String>> sudoku){
        putNumbers(0,0);
    }
    
    private static void putNumbers( int row, int column){
        terminator = row;
        if(row==9){
            return;
        }
        Integer i;
        for ( i = 1; i < 10; i++) {
            if(terminator==9){
                break;
            }
            if(sudoku.get(row).get(column).equals(".")) {
                sudoku.get(row).set(column,i.toString());
                if (validateSudoku(sudoku.get(row).get(column),row,column)){
                    if (column+1==9){
                        putNumbers(row+1,0);
                    }else {
                        putNumbers(row,column+1);
                    }
                }  else {
                    sudoku.get(row).set(column,".");
                }
            }else {
                if (column+1==9){
                    putNumbers(row+1,0);
                    break;
                }else {
                    putNumbers(row,column+1);
                    break;
                }
            }

        }
        if(i==10){
            sudoku.get(row).set(column,".");
        }

    }

    private static boolean validateSudoku(String tile,int row,int column){
//        row check
        for (int i = 0; i <sudoku.get(row).size(); i++) {
            if(i==column){
                continue;
            }
            if(tile.equals(sudoku.get(row).get(i))){
                return false;
            }
        }

//        column check
        for (int i = 0; i <sudoku.size(); i++) {
            if(i==row){
                continue;
            }

            if(tile.equals(sudoku.get(i).get(column))){
                return false;
            }
        }

//        square check
        int apexRow = row - (row%3);
        int apexColumn = column - (column%3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if((apexRow+i==row)&&(apexColumn+j==column)){
                    continue;
                }
                if(tile.equals(sudoku.get(apexRow+i).get(apexColumn+j))){
                    return false;
                }
            }
        }

        return true;
    }
}
