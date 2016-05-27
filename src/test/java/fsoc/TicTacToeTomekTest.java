package fsoc;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Collection;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;

public class TicTacToeTomekTest {

  @Test
  public void integrationTest() throws IOException {
    File inFile = new File("./samples/A-small-practice.in");
    File outFile = new File("./samples/A-small-practice.out");
    InputStream inStream = new FileInputStream(inFile.toString());
    InputStream outStream = new FileInputStream(outFile.toString());

    String outString = streamToString(outStream);

    OutputStream output = new ByteArrayOutputStream();
    TicTacToeTomek.processBoard(inStream, output);
    String programAnswer = output.toString();

    assertEquals(outString.replace("\n",""), programAnswer.replace("\n",""));

    inStream.close();
    outStream.close();
  }

  static String streamToString(java.io.InputStream is) throws IOException {
    StringBuilder builder = new StringBuilder();
    int ch;
    while ((ch = is.read()) != -1){
      if (ch != '\n')
        builder.append((char)ch);
    }
    return builder.toString();
  }

}
