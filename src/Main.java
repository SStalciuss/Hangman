import Components.*;
import java.awt.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("FrameDemo");
    frame.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.gridwidth = c.gridheight = 1;
    c.anchor = GridBagConstraints.NORTHWEST;
    c.fill = GridBagConstraints.BOTH;
    
    c.gridx = c.gridy = 0;
    c.weightx = c.weighty = 60;
    frame.getContentPane().add(new DrawField(),c);
    c.gridy = 1;
    c.weightx = c.weighty = 10;
    frame.getContentPane().add(new WordLine(),c);
    c.gridy = 2;
    c.weightx = c.weighty = 30;
    frame.getContentPane().add(new Keyboard(),c);


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(1000, 800));
    frame.pack();

    //5. Show it.
    frame.setVisible(true);
  }
}