package com.bl.tictac;

import java.util.Scanner;

public class TicTacToeProblem {

    public static Scanner s = new Scanner(System.in);

    //Method to Create Board
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int position = 1; position < board.length; position++) {
            board[position] = 'X';
        }
        return board;
    }

    //Method to Choose Letter To Input
    public static char chooseLetter(char letter) {

        return Character.toUpperCase(letter);
    }

    public static void showBoard(char board[]) {
        System.out.println("\n" + board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("*****");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("*****");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);


    }

    public static void main(String[] args) {
        System.out.println("Enter letter: ");
        char letter = s.next().charAt(0);
        char[] board = createBoard();
        char userletter = chooseLetter(letter);
        char computerletter = (chooseLetter(letter) == 'X' ? 'O' : 'X');
        showBoard(board);


    }
}
