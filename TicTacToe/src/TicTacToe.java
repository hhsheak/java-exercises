import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static String[] board;
    static String turn;

    static String checkWinner() {
        for (int i = 0; i <= 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
        

            if (line.equals("XXX")) {
                return "X wins!";
            } else if (line.equals("OOO")) {
                return "O wins!";
            } 

            for (int j = 0; j < 9; j++) {
                if (Arrays.asList(board).contains(String.valueOf(j + 1))) {
                    break;
                } else if (j == 8) {
                    return "Draw!";
                }
            }

    }
    return null;
}

    static void printBoard() {
        System.out.println("|"+board[0]+"|"+board[1]+"|"+board[2]+"|");
        System.out.println("|"+board[3]+"|"+board[4]+"|"+board[5]+"|");
        System.out.println("|"+board[6]+"|"+board[7]+"|"+board[8]+"|");
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        String winner = null;

        turn = "X";

        for (int i = 0; i < board.length; i++) {
            board[i] = String.valueOf(i+1);
        }

        printBoard();

        while (winner == null) {
            int numInput;

            try {
                System.out.println(turn + "'s turn!");
                System.out.print("Choose a slot: ");
                numInput = scanner.nextInt();

                if(board[numInput - 1] == "X" || board[numInput - 1] == "O") {
                    System.out.println("Already taken!");
                } else {
                    board[numInput - 1] = turn;
                    printBoard();
                    turn = turn.equals("X") ? "O" : "X";
                    winner = checkWinner();

                    System.out.println(winner);
                }
            } catch (Exception e) {
                if (e instanceof InputMismatchException) {
                    System.out.println("Enter a valid number!");
                    scanner.nextLine();
                } else if (e instanceof IndexOutOfBoundsException) {
                    System.out.println("Enter a valid number!");
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                }

            }
        }
    }
}
