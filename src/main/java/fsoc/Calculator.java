package fsoc;

/**
 *
 */
public class Calculator {
  public static String process(BoardCounter bc, int maxRows) {
    char[] chars = {'O', 'X'};

    for (int i = 0; i < maxRows; i++) {
      for (Sign sign : Sign.values()) {
        if (bc.getRows(sign)[i] == maxRows || bc.getCols(sign)[i] == maxRows || (
                i < bc.getDiags(sign).length && bc.getDiags(sign)[i] == maxRows )) {
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

