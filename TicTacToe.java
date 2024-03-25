import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][]board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();
        display();
        while (!isWin("X") && !isWin("O") && !isTie()) {
            int[] move = getMove();
            int row = move[0];
            int col = move[1];
            if (!isValidMove(row, col)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            board[row][col] = currentPlayer;
            display();
            if (isWin(currentPlayer)) {
                System.out.println(currentPlayer + " wins!");
                break;
            }
            if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }
            togglePlayer();
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < ROW; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("  -----");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
        move[0] = scanner.nextInt() - 1;
        move[1] = scanner.nextInt() - 1;
        return move;
    }

    private static void togglePlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }
}
