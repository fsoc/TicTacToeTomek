/**
 * https://code.google.com/codejam/contest/2270488/dashboard
 */

package fsoc;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.lang.Math;

public class TicTacToeTomek {
  public static void main(String[] args) {
    processBoard(System.in, System.out);
  }

  public static void processBoard(InputStream in, OutputStream out) {
    Kattio io = new Kattio(in, out);
    io.println("foo");

    io.flush();
    io.close();
  }
}
