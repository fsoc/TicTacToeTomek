package fsoc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardCounterTest {
  private BoardCounter b;

  @Before
  public void initialize() {
    b = new BoardCounter(3);
  }

  @Test
  public void addXTest() {
    b.addRowElement(0, 'X');
    assertEquals(b.getRows(Sign.X)[0], 1);
  }

  @Test
  public void addOTest() {
    b.addRowElement(0, 'O');
    assertEquals(b.getRows(Sign.O)[0], 1);
    assertEquals(b.getRows(Sign.X)[0], 0);
  }

  @Test
  public void addTwoXDiaTest() {
    // Add X to second diagonal
    b.addDiagElement(1, 'X');
    b.addDiagElement(1, 'X');
    assertEquals(b.getDiags(Sign.X)[1], 2);
  }

  @Test
  public void addTTest() {
    b.addRowElement(0, 'T');
    assertEquals(b.getRows(Sign.X)[0], 1);
    assertEquals(b.getRows(Sign.O)[0], 1);
  }

  @Test
  public void addDotTest() {
    assert(!b.hasUnsetElements());
    b.addRowElement(0, '.');
    assert(b.hasUnsetElements());
  }
}