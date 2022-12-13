package Utils;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.sql.SQLException;
import java.util.Scanner;

public class WordAdder {

  public static void main(String[] args) {
    addWords();
  }

  public static void addWords() {
    try {
      File myObj = new File("words.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        MySQLHandler.addWord(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("An error occurred.");
    }
  }
}
