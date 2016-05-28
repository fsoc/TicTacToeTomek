package fsoc;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * https://code.google.com/codejam/contest/2270488/dashboard
 * The main class, responsible for parsing and IO for the boards.
 */
class TicTacToeTomek {

  public static void main(String[] args) {
    processBoards(System.in, System.out);
  }

  public static void processBoards(InputStream in, OutputStream out) {
    Kattio io = new Kattio(in, out);
    int boards = io.getInt();

    int N = 4; // Size of the board
    for (int i = 0; i < boards; i++) {
      char[][] board = new char[N][N];
      for (int j = 0; j < 4; j++) {
        board[j] = io.getWord().toCharArray();
      }
      String answer = processBoard(board);
      io.print("Case #" + (i + 1) + ": ");
      io.println(answer);
    }

    io.flush();
    io.close();
  }

  /**
   * Processes a board and outputs its outcome.
   * @param board A 2-dimensional array with chars that represent
   * a square formed board.
   * @return The outcome string.
   */
  private static String processBoard(char[][] board) {
    BoardCounter boardCounter = new BoardCounter(board.length);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        // Check columns
        boardCounter.addColElement(j, board[i][j]);
        // Check rows
        boardCounter.addRowElement(i, board[i][j]);
        // Check diagonal
        if (i == j) {
          boardCounter.addDiagElement(0, board[i][j]);
        }
        // The top right to bottom left diagonal
        if (i + j == board.length - 1) {
          boardCounter.addDiagElement(1, board[i][j]);
        }
      }
    }
    return Calculator.process(boardCounter);
  }
}
