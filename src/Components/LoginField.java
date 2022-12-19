package Components;

import Utils.MySQLHandler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginField extends JPanel {

  static JFrame Login = new JFrame("Login");
  private TextField username = new TextField(10);
  private TextField password = new TextField(10);
  private JButton login = new JButton("Login");
  private JButton back = new JButton("Don't have a account?");
  private Label u = new Label("username:");
  private Label p = new Label("password:");
  private JPanel panel = new JPanel();

  public LoginField() {
    createLoginButton();
    createBackButton();
    addToPanel();
    Login.add(panel);
    Login.setSize(new Dimension(250, 150));
    Login.setLocationRelativeTo(null);
    Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Login.setVisible(true);
  }

  private void createLoginButton() {
    login.setFont(new Font("Sans Serif", Font.BOLD, 14));
    login.setMargin(new Insets(0, 0, 0, 0));
    login.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String usernameString = username.getText();
          String passwordString = password.getText();
          System.out.println("you are logged!");
          Login.setVisible(false);
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
          //          login.setVisible(true);
          Login.setVisible(false);
          RegisterField registerField = new RegisterField();
          //  actions.onButtonClickHandler("Have an account?");
        }
      }
    );
  }

  public void addToPanel() {
    panel.setLayout(new FlowLayout());
    GridBagConstraints constrains = new GridBagConstraints();
    constrains.fill = GridBagConstraints.BOTH;

    constrains.gridy = 0;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 40, 5, 0);
    panel.add(u, constrains);
    constrains.weightx = 20;
    constrains.insets = new Insets(5, 0, 5, 20);
    panel.add(username, constrains);

    constrains.gridy = 1;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 40, 5, 0);
    panel.add(p, constrains);
    constrains.weightx = 20;
    constrains.insets = new Insets(5, 0, 5, 20);
    panel.add(password, constrains);

    constrains.gridy = 2;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 10, 0, 10);
    panel.add(login, constrains);
    constrains.insets = new Insets(5, 20, 0, 20);
    panel.add(back, constrains);
  }
}
