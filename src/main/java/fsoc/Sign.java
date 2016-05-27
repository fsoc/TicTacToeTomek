package fsoc;

/**
 *
 */
public enum Sign {
  X(0), O(1);

  private final int value;

  private Sign(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
