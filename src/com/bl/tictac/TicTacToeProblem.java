package com.bl.tictac;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeProblem {

    public static Scanner userinput = new Scanner(System.in);
    public enum Player {USER, COMPUTER};
    public enum GamePosition {WINNING, TIED, CONTINUE};
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
        ArrayList<Integer> availableCells = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            availableCells.add(i);
        }
        while (true) {
            System.out.println("Enter your preferred index: ");
            int index = userinput.nextInt();
            if (availableCells.contains(index) && isCellFree(board, index))
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

    //Method to get computer act like me i.e to play for a win
    public static int getComputerMove(char[] board, char computerLetter, char userletter) {
        int winMove = getWinningMove(board, computerLetter);
        if (winMove != 0) return winMove;
        int userWinMove = getWinningMove(board, userletter);
        if (userWinMove != 0) return userWinMove;
        int[] cornerMoves = {1, 3, 7, 9};
        int cornerMove = getRandomMove(board, cornerMoves);
        if (cornerMove != 0) return cornerMove;
        if (isCellFree(board, 5)) return 5;
        int[] remainingMoves = {2, 4, 6, 8};
        int remainingMove = getRandomMove(board, remainingMoves);
        if (remainingMove != 0) return remainingMove;

        return 0;
    }

    //method of getting random move in case no one's winning
    public static int getRandomMove(char[] board, int[] moves) {
        for (int index = 1; index < board.length; index++) {
            if (isCellFree(board, moves[index]))
                return moves[index];
        }
        return 0;
    }

    //Method of getting the winning Move
    public static int getWinningMove(char[] board, char letter) {
        for (int index = 1; index < board.length; index++) {
            char[] copyOfBoard = getCopyOfBoard(board);
            if (isCellFree(copyOfBoard, index))
                makeMove(copyOfBoard, index, letter);
            if (isWinningPosition(copyOfBoard, letter))
                return index;
        }
        return 0;
    }

    //Method of getting copy of the board
    public static char[] getCopyOfBoard(char[] board) {
        char[] copyBoard = board.clone();
        return copyBoard;
    }

    //Method to check game status
    public static GamePosition getGameCondition(char[] board, int index, char letter, String msg) {
        makeMove(board, index, letter);
        if (isWinningPosition(board, letter)) {
            showBoard(board);
            System.out.println(msg);
            return GamePosition.WINNING;
        }
        if (isBoardFull(board)) {
            showBoard(board);
            System.out.println("It's a tie");
            return GamePosition.TIED;

        }
        return GamePosition.CONTINUE;
    }

    //Method to check for Tie
    public static boolean isBoardFull(char[] board) {
        for (int index = 1; index < board.length; index++) {
            if (isCellFree(board, index))
                return false;
        }
        return true;
    }


    //Method to play the tictactoe between user and computer
    public static void PlayTicTacToeGame() {
        System.out.println("Enter the letter of your choice: ");
        char letter = userinput.next().charAt(0);
        char userLetter = chooseLetter(letter);
        char computerLetter = (chooseLetter(letter) == 'X' ? 'O' : 'X');
        char[] board = createBoard();
        Player player = whoStartsFirst();
        System.out.println(player);
        boolean gameGoingOn = true;
        GamePosition gameStatus;
        while (gameGoingOn) {
            if (player == Player.USER) {
                showBoard(board);
                int userMove = getUserMove(board);
                String winningMessage = "Congrats!You Won!";
                gameStatus = getGameCondition(board, userMove, userLetter, winningMessage);
                player = Player.COMPUTER;
            } else {
                String winningMessage = "OOps!You lost to the computer!";
                int computerMove = getComputerMove(board, computerLetter, userLetter);
                gameStatus = getGameCondition(board, computerMove, computerLetter, winningMessage);
                player = Player.USER;
            }
            if (gameStatus == GamePosition.CONTINUE) continue;
            gameGoingOn = false;

        }
    }

    //MAIN
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int wannaPlayMore = 1;
        while (wannaPlayMore == 1) {
            PlayTicTacToeGame();
            System.out.println("Wanna play one more game?(yes or no)");
            String ans = userInput.nextLine();
            if (ans.equals("yes"))
                wannaPlayMore = 1;
            else
                wannaPlayMore = 0;
        }


    }


}





