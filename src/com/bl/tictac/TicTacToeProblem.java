package com.bl.tictac;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeProblem {

    public static Scanner userinput = new Scanner(System.in);

    //Method to Create Board
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int position = 1; position < board.length; position++) {
            board[position] = ' ';
        }
      //  board[2] = 'X';
        return board;
    }

    //Method to Choose Letter To Input
    public static char chooseLetter(char letter) {

        return Character.toUpperCase(letter);
    }

    //Method to Display Board
    public static void showBoard(char board[]) {
        System.out.println("\n" + board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("*****");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("*****");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);


    }

    //Method to get user move
    public static int getUserMove(char[] board) {
        ArrayList<Integer> availablecells = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            availablecells.add(i);
        }
        while (true) {
            System.out.println("Enter your preferred index: ");
            int index = userinput.nextInt();
            if (availablecells.contains(index) && board[index] == ' ')
                return index;
        }
    }

//    //Method to check whether cell is free or not
    public static boolean isCellFree(char[] board, int index) {
        if (board[index] == ' ')
            return true;
        else
            return false;
    }
//Making the move
    public static void makeMove(char[] board, int index, char letter){
        boolean cellfree=isCellFree(board,index);
        if(cellfree)
        {
            board[index]=letter;
        }
    }

    //MAIN
    public static void main(String[] args) {
        System.out.println("Enter letter: ");
        char letter = userinput.next().charAt(0);
        char[] board = createBoard();
        char userletter = chooseLetter(letter);
        char computerletter = (chooseLetter(letter) == 'X' ? 'O' : 'X');
        showBoard(board);
        int index = getUserMove(board);
        makeMove(board,index,userletter);
        showBoard(board);
        System.out.println(index);


    }
}
