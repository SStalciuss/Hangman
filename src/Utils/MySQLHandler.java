package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MySQLHandler {

  static Connection con = null;
  static PreparedStatement statement;
  static ResultSet res;

  public MySQLHandler() {
    System.out.println("test");
  }

  public static void connect() {
    if (con != null) return;
    System.out.println("Connecting database...");
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con =
        DriverManager.getConnection(
          "jdbc:mysql://sql7.freemysqlhosting.net/sql7584318",
          "sql7584318",
          "vfjFJuDrkr"
        );
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

  public static void addWord(String word) throws SQLException {
    statement = con.prepareStatement("INSERT INTO Words (word) VALUES(?)");
    statement.setString(1, word);
    statement.execute();
  }

  public static void addScore(String score) throws SQLException {
    statement = con.prepareStatement("INSERT INTO Scores (score) VALUES(?)");
    statement.setString(1, score);
    statement.execute();
  }

  public static Vector<String> getAllNames() throws SQLException {
    statement = con.prepareStatement("SELECT name FROM Users");
    res = statement.executeQuery();
    Vector<String> temp = new Vector<String>();

    while (res.next()) temp.add(res.getString("name"));
    return temp;
  }

  public static Vector<String> getAllScores() throws SQLException {
    statement = con.prepareStatement("SELECT score FROM scores");
    res = statement.executeQuery();
    Vector<String> temp = new Vector<String>();

    while (res.next()) temp.add(res.getString("score"));
    return temp;
  }

  public static Vector<String> getAllWords() throws SQLException {
    statement = con.prepareStatement("SELECT word FROM Words");
    res = statement.executeQuery();
    Vector<String> temp = new Vector<String>();

    while (res.next()) temp.add(res.getString("word"));
    return temp;
  }
}
