package Components;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KeyboardButton extends JButton{
    
    private char symbol;

    KeyboardButton(String text){
        super(text);
        symbol = text.charAt(0);
        this.addActionListener(new ButtonActionListener());
    }

    private void onButtonClick(){
        this.setBackground(Color.GRAY);
        this.setEnabled(false);
    }


    class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(symbol);
            onButtonClick();
        }    
    }



}
