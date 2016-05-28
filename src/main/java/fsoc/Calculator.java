package fsoc;

/**
 * Static class calculating which of the outcomes based on the data in a BoardCounter.
 */
class Calculator {
  public static String process(BoardCounter bc) {
    int maxRows = bc.getRows(Sign.X).length;

    for (int i = 0; i < maxRows; i++) {
      for (Sign sign : Sign.values()) {
        // If number of X o O's in a row equals the maximum posible then that row won
        if (bc.getRows(sign)[i] == maxRows || bc.getCols(sign)[i] == maxRows || (
                i < bc.getDiags(sign).length && // The diagonals only have 2 dimensions
                        bc.getDiags(sign)[i] == maxRows )) {
          return sign.name() + " won";
        }
      }
    }

    if (bc.hasUnsetElements()) {
      return "Game has not completed";
    } else {
      return "Draw";
    }
  }
}
