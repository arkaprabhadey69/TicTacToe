package com.bl.tictac;

public class TicTacToeProblem {

    private static char[] CreateBoard()
    {
        char [] board = new char[10];
        for(int i=1;i<board.length;i++)
        {
            board[i]=' ';
        }
        return board;
    }

    public static void main(String[] args) {
        char[] board= CreateBoard();
        for(int i=1;i<board.length;i++)
        {
            System.out.println(board[i]);
        }
    }
}
