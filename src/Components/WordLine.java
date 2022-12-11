package Components;

import javax.swing.*;

import java.awt.*;

public class WordLine extends JPanel  {
    
    public WordLine(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        // this.setLayout(new GridLayout(1,0));

        JLabel letter = new JLabel("test");
        letter.setFont(new Font("Sans Serif", Font.BOLD, 24));

        this.add(letter);
    }
}