package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLHandler {

  static Connection con = null;
  static PreparedStatement statement;
  static ResultSet res;

  private static String url =
    "jdbc:mysql://sql7.freemysqlhosting.net/sql7584318";
  private static String name = "sql7584318";
  private static String password = "vfjFJuDrkr";

  public static void connect() {
    if (con != null) return;
    System.out.println("Connecting database...");
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, name, password);
      System.out.println("Database connected!");
    } catch (Exception e) {
      throw new IllegalStateException("Cannot connect the database!", e);
    }
  }

  public static void addUser(String name, String password) {
    try {
      statement =
        con.prepareStatement("INSERT INTO Users (name, password) VALUES(?,?)");
      statement.setString(1, name);
      statement.setString(2, password);
      statement.execute();
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static void addWord(String word) {
    try {
      statement = con.prepareStatement("INSERT INTO Words (word) VALUES(?)");
      statement.setString(1, word);
      statement.execute();
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static void addScore(String score) {
    try {
      statement = con.prepareStatement("INSERT INTO Scores (score) VALUES(?)");
      statement.setString(1, score);
      statement.execute();
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static int getRowsCount() {
    try {
      statement = con.prepareStatement("SELECT COUNT(*) FROM Words");
      res = statement.executeQuery();
      res.next();
      return res.getInt(1);
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static int getRowsCount2() {
    try {
      statement = con.prepareStatement("SELECT COUNT(*) FROM ThemeWords");
      res = statement.executeQuery();
      res.next();
      return res.getInt(1);
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static String getWord(int id) {
    try {
      statement = con.prepareStatement("SELECT word FROM Words WHERE id = (?)");
      statement.setInt(1, id);
      res = statement.executeQuery();
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static String getThemeWord(int id) {
    try {
      statement =
        con.prepareStatement("SELECT word FROM ThemeWords WHERE id = (?)");
      statement.setInt(1, id);
      res = statement.executeQuery();
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static String getTheme(int id) {
    try {
      statement =
        con.prepareStatement("SELECT theme FROM ThemeWords WHERE id = (?)");
      statement.setInt(1, id);
      res = statement.executeQuery();
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static Boolean checkIfUserExists(String name) {
    try {
      statement =
        con.prepareStatement("SELECT name FROM Users WHERE name = (?)");
      statement.setString(1, name);
      res = statement.executeQuery();
      return res.next();
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }

  public static Boolean checkLogin(String name, String password) {
    try {
      statement =
        con.prepareStatement(
          "SELECT name FROM Users WHERE name = (?) AND password =(?)"
        );
      statement.setString(1, name);
      statement.setString(2, password);
      res = statement.executeQuery();
      return res.next();
    } catch (Exception e) {
      throw new IllegalStateException("Cant add user!", e);
    }
  }
}
