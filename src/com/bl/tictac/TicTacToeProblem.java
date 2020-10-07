package com.bl.tictac;

import java.util.Scanner;

public class TicTacToeProblem {

    public static Scanner s = new Scanner(System.in);
//Method to Create Board
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int position = 1; position < board.length; position++) {
            board[position] = ' ';
        }
        return board;
    }
//Method to Choose Letter To Input
    public static char chooseLetter() {
        System.out.println("Enter letter: ");
        char letter = s.next().charAt(0);
        return Character.toUpperCase(letter);
    }

    public static void main(String[] args) {
        char[] board = createBoard();
        char letter = chooseLetter();
        System.out.println(letter);
    }
}
