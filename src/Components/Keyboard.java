package Components;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Keyboard extends JPanel  {

    private char[][] buttonsList = {{'Q','W','E','R','T','Y','U','I','O','P'},{'A','S','D','F','G','H','J','K','L'},{'Z','X','C','V','B','N','M'}};
    private KeyboardButton[][] buttons;
    
    public Keyboard(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        createButtons();
        addButtonsToPanel();

    }

    private void createButtons(){
        buttons = new KeyboardButton[buttonsList.length][20];
        for(int i = 0; i < buttonsList.length; i++){
            for(int j = 0; j < buttonsList[i].length; j++){
                buttons[i][j] = new KeyboardButton(""+buttonsList[i][j]);
                buttons[i][j].setFont(new Font("Sans Serif", Font.BOLD, 24));

            }
        }
    }

    private void addButtonsToPanel(){
        this.setLayout(new GridLayout(3, 1, 0 ,0));
        for(KeyboardButton[] buttonsRow : buttons){
            JPanel row = new JPanel();
            row.setLayout(new GridLayout(1,0));
            row.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            for(KeyboardButton button : buttonsRow){
                if(button != null){
                    row.add(button);
                }

            }
            this.add(row);
        }

    }
}