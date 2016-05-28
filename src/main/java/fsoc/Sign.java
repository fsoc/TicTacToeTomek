package fsoc;

/**
 * Enumerator for the two signs X and O.
 */
public enum Sign {
  X(0), O(1);

  private final int value;

  Sign(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
