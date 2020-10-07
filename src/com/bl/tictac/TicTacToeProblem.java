package com.bl.tictac;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeProblem {

    public static Scanner userinput = new Scanner(System.in);

    public enum Player {USER, COMPUTER};
    public static final int HEAD = 1;

    //Method to Create Board
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int position = 1; position < board.length; position++) {
            board[position] = ' ';
        }

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
            if (availablecells.contains(index) && isCellFree(board, index))
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
    public static void makeMove(char[] board, int index, char letter) {
        boolean cellFree = isCellFree(board, index);
        if (cellFree) {
            board[index] = letter;
        }
    }

    //Determine who starts first
    public static Player whoStartsFirst() {
        int toss = (int) Math.floor(Math.random() * 10 % 2);
        return (toss == HEAD) ? Player.USER : Player.COMPUTER;

    }

    //Determine winning position
    public static boolean isWinningPosition(char[] board, char letter) {
        if ((board[1] == letter && board[2] == letter && board[3] == letter)
                || (board[4] == letter && board[5] == letter && board[6] == letter)
                || (board[7] == letter && board[8] == letter && board[9] == letter)
                || (board[1] == letter && board[5] == letter && board[9] == letter)
                || (board[3] == letter && board[5] == letter && board[7] == letter)
                || (board[2] == letter && board[5] == letter && board[6] == letter)
                || (board[1] == letter && board[4] == letter && board[7] == letter)
                || (board[3] == letter && board[6] == letter && board[9] == letter))
            return true;
        else
            return false;
    }

    //MAIN
    public static void main(String[] args) {
//        System.out.println("Enter letter: ");
//        char letter = userinput.next().charAt(0);
//        char[] board = createBoard();
//        char userLetter = chooseLetter(letter);
//        char computerletter = (chooseLetter(letter) == 'X' ? 'O' : 'X');
//        showBoard(board);
//        int index = getUserMove(board);
//        makeMove(board, index, userLetter);
//        showBoard(board);
//        Player p = whoStartsFirst();
//        System.out.println(p);

        Player p = whoStartsFirst();
        System.out.println("Enter letter: ");
        char letter = userinput.next().charAt(0);
        char userLetter = chooseLetter(letter);
        char[] board = createBoard();

        while (true) {
            int index = getUserMove(board);
            makeMove(board, index, userLetter);
            showBoard(board);
            p = (p == Player.USER) ? Player.COMPUTER : Player.USER;
            String nameOfPlayer = (p == Player.USER) ? "User" : "Computer";
            if (isWinningPosition(board, userLetter)) {
                System.out.println(nameOfPlayer + " won");
                return;
            }
            userLetter = (userLetter == 'X' ? 'O' : 'X');
            System.out.println(nameOfPlayer + " is playing");


        }


    }
}
