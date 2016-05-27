/**
 * https://code.google.com/codejam/contest/2270488/dashboard
 */

package fsoc;
import java.io.InputStream;
import java.io.OutputStream;


public class TicTacToeTomek {
  private static final int N = 4;

  public static void main(String[] args) {
    processBoards(System.in, System.out);
  }

  public static void processBoards(InputStream in, OutputStream out) {
    Kattio io = new Kattio(in, out);
    int boards = io.getInt();

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

  private static String processBoard(char[][] board) {
    //TODO: check the N variable
    BoardCounter boardCounter = new BoardCounter(N);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        // Check columns
        boardCounter.addColElement(j, board[i][j]);
        // Check rows
        boardCounter.addRowElement(i, board[i][j]);
        // Check diagonals
        if (i == j) {
          boardCounter.addDiagElement(0, board[i][j]);
        }
        if (i + j == N - 1) {
          boardCounter.addDiagElement(1, board[i][j]);
        }
      }
    }
    return Calculator.process(boardCounter, N);
  }
}
