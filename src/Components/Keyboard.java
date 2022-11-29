package Components;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel  {

    public static JComponent getKeyboard(){
        return new JButton("test button");
    }
    public Keyboard(){
        this.add(getButtons());
    }
    private static JPanel getButtons(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 10));

        for(char i = 'a'; i < 'z'; i++){
            panel.add(new JButton(""+i));
        }
        return panel;
    }
}

