package Components;

import Utils.MySQLHandler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterField extends JFrame {

  private TextField username = new TextField(10);
  private TextField password = new TextField(10);
  private JButton register = new JButton("Register");
  private JButton login = new JButton("Login");
  private JButton guest = new JButton("Play as a guest");
  private Label u = new Label("username:");
  private Label p = new Label("password:");
  private static JFrame parent = null;

  public RegisterField(JFrame parentComp) {
    parent = parentComp;
    setLayout(new FlowLayout());
    setResizable(false);
    setTitle("Register");
    addElementsToPanel();
    setSize(new Dimension(200, 160));
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void createRegisterButton() {
    register.setFont(new Font("Sans Serif", Font.BOLD, 14));
    register.setMargin(new Insets(0, 0, 0, 0));
    register.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String usernameString = username.getText();
          String passwordString = password.getText();
          if (MySQLHandler.checkIfUserExists(usernameString)) {
            JOptionPane.showMessageDialog(
              null,
              "User with this name already exists"
            );
            return;
          }
          MySQLHandler.addUser(usernameString, passwordString);
          System.out.println("you are registered!");
          setVisible(false);
          parent.setEnabled(true);
          parent.toFront();
          parent.setVisible(true);
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
          setVisible(false);
          new LoginField(parent);
        }
      }
    );
  }

  private void createGuestButton() {
    guest.setFont(new Font("Sans Serif", Font.BOLD, 14));
    guest.setMargin(new Insets(0, 0, 0, 0));
    guest.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          parent.setEnabled(true);
          parent.toFront();
          System.out.println("Guest!");
          setVisible(false);
          parent.setEnabled(true);
          parent.toFront();
          parent.setVisible(true);
          parent.repaint();
        }
      }
    );
  }

  private void addElementsToPanel() {
    createRegisterButton();
    createLoginButton();
    createGuestButton();

    add(u);
    add(username);

    add(p);
    add(password);

    add(login);
    add(register);
    add(guest);
  }
}
