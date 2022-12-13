package Components;

import Interfaces.ButtonActions;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterField extends JPanel {

  private TextField username = new TextField();
  private TextField password = new TextField();
  private JButton register = new JButton("Register");
  private JButton login = new JButton("Have an account?");
  private Label u = new Label("username:");
  private Label p = new Label("password:");

  public RegisterField(ButtonActions<String> actions) {
    addToPanel();
    createRegisterButton(actions);
    createLoginButton(actions);
  }

  private void createRegisterButton(ButtonActions<String> actions) {
    register.setFont(new Font("Sans Serif", Font.BOLD, 14));
    register.setMargin(new Insets(0, 0, 0, 0));
    register.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          actions.onButtonClickHandler("Register");
        }
      }
    );
  }

  private void createLoginButton(ButtonActions<String> actions) {
    login.setFont(new Font("Sans Serif", Font.BOLD, 14));
    login.setMargin(new Insets(0, 0, 0, 0));
    login.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          actions.onButtonClickHandler("Have an account?");
        }
      }
    );
  }

  private void addToPanel() {
    this.setLayout(new GridBagLayout());
    GridBagConstraints constrains = new GridBagConstraints();
    constrains.fill = GridBagConstraints.BOTH;

    constrains.gridy = 0;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 40, 5, 0);
    this.add(u, constrains);
    constrains.weightx = 20;
    constrains.insets = new Insets(5, 0, 5, 20);
    this.add(username, constrains);

    constrains.gridy = 1;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 40, 5, 0);
    this.add(p, constrains);
    constrains.weightx = 20;
    constrains.insets = new Insets(5, 0, 5, 20);
    this.add(password, constrains);

    constrains.gridy = 2;
    constrains.weightx = constrains.weighty = 0;
    constrains.insets = new Insets(5, 10, 0, 10);
    this.add(login, constrains);
    constrains.insets = new Insets(5, 20, 0, 20);
    this.add(register, constrains);
  }
}
