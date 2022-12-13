package Components;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LoginField extends JPanel {

    private TextField username = new TextField();
    private TextField password = new TextField();
    private JButton login = new JButton("Login");
    private Label u = new Label("username:");
    private Label p = new Label("password:");

    public LoginField(LoginActions actions) {
        addToPanel();
        createLoginButton(actions);
    }

    private void createLoginButton(LoginActions actions){
        login.setFont(new Font("Sans Serif", Font.BOLD, 14));
        login.setMargin(new Insets(0, 0, 0, 0));
        login.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actions.onButtonClickHandler("Login");
              }
            }
          );

    }
    

    private void addToPanel(){

        this.setLayout(new GridBagLayout());
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.fill = GridBagConstraints.BOTH;

        constrains.gridy = 0;
        constrains.weightx = constrains.weighty = 0;
        constrains.insets = new Insets(5, 40, 5, 0);
        this.add(u, constrains);
        constrains.weightx =20;
        constrains.insets = new Insets(5, 0, 5, 20);
        this.add(username, constrains);

        constrains.gridy = 1;
        constrains.weightx = constrains.weighty = 0;
        constrains.insets = new Insets(5, 40, 5, 0);
        this.add(p, constrains);
        constrains.weightx =20;
        constrains.insets = new Insets(5, 0, 5, 20);
        this.add(password, constrains); 

        constrains.gridy = 2;
        constrains.weightx = constrains.weighty = 0;
        constrains.gridx = 1; 
        constrains.insets = new Insets(5, 60, 0, 20);
        constrains.anchor = GridBagConstraints.CENTER;
        this.add(login, constrains);
    }
    
}
