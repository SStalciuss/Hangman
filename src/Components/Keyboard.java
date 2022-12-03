package Components;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel  {

    private char[][] buttonsList = {{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l'},{'z','x','c','v','b','n','m'}};
    private KeyboardButton[][] buttons;
    
    public Keyboard(){
        createButtons();
        addButtonsToPanel();
    }

    private void createButtons(){
        buttons = new KeyboardButton[buttonsList.length][20];
        for(int i = 0; i < buttonsList.length; i++){
            for(int j = 0; j < buttonsList[i].length; j++){
                buttons[i][j] = new KeyboardButton(""+buttonsList[i][j]);
            }
        }
    }

    private void addButtonsToPanel(){
        this.setLayout(new GridLayout(3, 1));
        for(KeyboardButton[] buttonsRow : buttons){
            JPanel row = new JPanel();
            for(KeyboardButton button : buttonsRow){
                if(button != null)
                row.add(button);
            }
            this.add(row);
        }

    }
}