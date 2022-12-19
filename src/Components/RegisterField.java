package Components;

import Utils.MySQLHandler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterField extends JPanel {

  static JFrame Register = new JFrame("Register");
  private TextField username = new TextField(10);
  private TextField password = new TextField(10);
  private JButton register = new JButton("Register");
  private JButton login = new JButton("Have an account?");
  private Label u = new Label("username:");
  private Label p = new Label("password:");
  private JPanel panel = new JPanel();

  public RegisterField() {
    createRegisterButton();
    createLoginButton();
    addToPanel();
    Register.add(panel);
    Register.setSize(new Dimension(250, 150));
    Register.setLocationRelativeTo(null);
    Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Register.setVisible(true);
    //setVisible(true);
  }

  private void createRegisterButton() {
    register.setFont(new Font("Sans Serif", Font.BOLD, 14));
    register.setMargin(new Insets(0, 0, 0, 0));
    register.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String usernameString = username.getText();
          String passwordString = password.getText();
          MySQLHandler.addUser(usernameString, passwordString);
          System.out.println("you are registered!");
          Register.setVisible(false);
        }
      }
    );
  }

  private void createLoginButton() {
    login.setFont(new Font("Sans Serif", Font.BOLD, 14));
    login.setMargin(new Insets(0, 0, 0, 0));
    login.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //          login.setVisible(true);
          Register.setVisible(false);
          LoginField loginField = new LoginField();
          //  actions.onButtonClickHandler("Have an account?");
        }
      }
    );
  }

  private void addToPanel() {
    panel.setLayout(new FlowLayout());
    GridBagConstraints constrains = new GridBagConstraints();
    constrains.fill = GridBagConstraints.BOTH;

    constrains.gridy = 0;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 40, 5, 0);
    panel.add(u, constrains);
    constrains.weightx = 50;
    constrains.insets = new Insets(100, 0, 5, 20);
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
    panel.add(register, constrains);
  }
}
