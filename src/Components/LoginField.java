package Components;

import Utils.MySQLHandler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginField extends JFrame {

  private TextField username = new TextField(10);
  private TextField password = new TextField(10);
  private JButton login = new JButton("Login");
  private JButton back = new JButton("Register?");
  private Label u = new Label("username:");
  private Label p = new Label("password:");
  private JPanel panel = new JPanel();
  private static JFrame parent = null;

  public LoginField(JFrame parentComp) {
    parent = parentComp;
    parent.setEnabled(false);
    setTitle("Login");
    setResizable(false);
    createLoginButton();
    createBackButton();
    addToPanel();
    add(panel);
    setSize(new Dimension(240, 160));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void createLoginButton() {
    login.setFont(new Font("Sans Serif", Font.BOLD, 14));
    login.setMargin(new Insets(0, 0, 0, 0));
    login.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String usernameString = username.getText();
          String passwordString = password.getText();
          if (!MySQLHandler.checkLogin(usernameString, passwordString)) {
            JOptionPane.showMessageDialog(
              null,
              "Username or password is incorrect"
            );
            return;
          }

          System.out.println("you are logged!");
          setVisible(false);
          parent.setEnabled(true);
          parent.toFront();
        }
      }
    );
  }

  private void createBackButton() {
    back.setFont(new Font("Sans Serif", Font.BOLD, 14));
    back.setMargin(new Insets(0, 0, 0, 0));
    back.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new RegisterField(parent);
        }
      }
    );
  }

  public void addToPanel() {
    panel.add(u);
    panel.add(username);

    panel.add(p);
    panel.add(password);

    panel.add(login);
    panel.add(back);
  }
}
