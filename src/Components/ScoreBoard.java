package Components;

import java.util.ArrayList;
import Utils.MySQLHandler;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ScoreBoard extends JFrame {
    private static JFrame parent = null;
    private JButton close = new JButton("Close");
    ArrayList<String> scores = new ArrayList<String>();
    public ScoreBoard(JFrame parentComp) {
        parent = parentComp;
        parent.setEnabled(false);
        setTitle("Scoreboard");
        setResizable(false);
        addElementsToPanel();
        setSize(new Dimension(140, 210));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
      }

      private void createCloseButton() {
        close.setFont(new Font("Sans Serif", Font.BOLD, 14));
        close.setMargin(new Insets(0, 0, 0, 0));
        close.addActionListener(
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
              parent.setVisible(true);
              parent.setEnabled(true);
              parent.toFront();
            }
          }
        );
      }

      private void addElementsToPanel() {
        createCloseButton();
        this.setLayout(new FlowLayout());
       
        scores = MySQLHandler.getLeaders();
        for(int i=0; i<scores.size(); i++){
            Label p = new Label(Integer.toString(i+1) +
            ") " + scores.get(i));
            add(p);
        }
        add(close);
      }  

}
