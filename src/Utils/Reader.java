package Utils;

import java.io.File;
import java.util.Scanner;

public class Reader {

  public static void main(String[] args) {
    try {
      File file = new File("words.txt");
      Scanner input = new Scanner(file);

      int count = 0;
      while (input.hasNext()) {
        String word = input.next();
        System.out.println(word);
        count = count + 1;
      }
      input.close();
      System.out.println("Word count: " + count);
    } catch (Exception e) {
      throw new IllegalStateException("Error reading file!", e);
    }
  }
}
