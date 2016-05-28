package fsoc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {
  private BoardCounter bc;

  @Before
  public void initialize() {
    bc = mock(BoardCounter.class);
  }

  @Test
  public void XWonTest() {
    when(bc.getRows(Sign.X)).thenReturn(new int[]{3, 2, 1});
    assertEquals("X won", Calculator.process(bc));
  }

  @Test
  public void DiagWonTest() {
    when(bc.getRows(Sign.X)).thenReturn(new int[]{1, 2, 1});
    when(bc.getCols(Sign.X)).thenReturn(new int[]{1, 2, 1});
    when(bc.getDiags(Sign.X)).thenReturn(new int[]{3, 0});
    assertEquals("X won", Calculator.process(bc));
  }

  @Test
  public void DrawTest() {
    when(bc.getRows(any())).thenReturn(new int[]{0, 0, 0});
    when(bc.getCols(any())).thenReturn(new int[]{0, 0, 0});
    when(bc.getDiags(any())).thenReturn(new int[]{0, 0});
    when(bc.hasUnsetElements()).thenReturn(false);
    assertEquals("Draw", Calculator.process(bc));
  }
}