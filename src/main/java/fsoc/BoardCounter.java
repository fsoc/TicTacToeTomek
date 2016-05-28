package fsoc;

/**
 * Keeps track of the different counters of a board. The number of X and O elements in every row, column and diagonal
 * can be entered.
 */
class BoardCounter {
  // Arrays containing counter of X and O elements in rows, columns and diagonals.
  // The first dimension is 0 fo X and 1 for Oand the second is the row/col/diag number
  private final int[][] rowElements;
  private final int[][] colElements;
  private final int[][] diagElements;
  private boolean hasUnsetElements = false; // Becomes true if the sign '.' i entered

  public BoardCounter(int size) {
    rowElements = new int[2][size];
    colElements = new int[2][size];
    diagElements = new int[2][2];
  }

  public void addRowElement(int row, char element) {
    setElement(rowElements, row, element);
  }

  public void addColElement(int col, char element) {
    setElement(colElements, col, element);
  }

  public void addDiagElement(int dimension, char element) {
    setElement(diagElements, dimension, element);
  }

  public int[] getRows(Sign sign) {
    return rowElements[sign.getValue()];
  }

  public int[] getCols(Sign sign) {
    return colElements[sign.getValue()];
  }

  public int[] getDiags(Sign sign) {
    return diagElements[sign.getValue()];
  }

  public boolean hasUnsetElements() {
    return hasUnsetElements;
  }

  private void setElement(int[][] array, int dimension, char c) {
    if (c == 'X') {
      array[Sign.X.getValue()][dimension]++;
    } else if (c == 'O') {
      array[Sign.O.getValue()][dimension]++;
    } else if (c == 'T') {
      array[Sign.X.getValue()][dimension]++;
      array[Sign.O.getValue()][dimension]++;
    } else {
      hasUnsetElements = true;
    }
  }
}