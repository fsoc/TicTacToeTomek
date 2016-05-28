package fsoc;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;
import java.io.ByteArrayOutputStream;

public class TicTacToeTomekTest {

  @Test
  public void smallIntegrationTest() throws IOException {
    testFiles("./samples/A-small-practice.in", "./samples/A-small-practice.out");
  }

  @Test
  public void largeIntegrationTest() throws IOException {
    testFiles("./samples/A-large-practice.in", "./samples/A-large-practice.out");
  }

  private void testFiles(String in, String out) throws IOException {
    File inFile = new File(in);
    File outFile = new File(out);
    InputStream inStream = new FileInputStream(inFile.toString());
    InputStream outStream = new FileInputStream(outFile.toString());

    String outString = streamToString(outStream);

    OutputStream output = new ByteArrayOutputStream();
    TicTacToeTomek.processBoards(inStream, output);
    String programAnswer = output.toString();

    assertEquals(outString.replace("\n",""), programAnswer.replace("\n",""));

    inStream.close();
    outStream.close();
  }

  private static String streamToString(java.io.InputStream is) throws IOException {
    StringBuilder builder = new StringBuilder();
    int ch;
    while ((ch = is.read()) != -1){
      if (ch != '\n')
        builder.append((char)ch);
    }
    return builder.toString();
  }

}
