package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class TimerField extends JPanel implements ActionListener {
    private int minutes;
    private int seconds;
    private Label label = new Label("");
    private Label text = new Label("Time since start:");

    Timer timer;

    public TimerField() {
        addToPanel();
        setStartTime();

        timer = new Timer(1000, this);
        timer.setInitialDelay(0);
    }

    public void addToPanel() {
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        text.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        this.setLayout(new FlowLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridy = constraints.gridx = 0;
        constraints.weightx = constraints.weighty = 0;
        constraints.anchor=GridBagConstraints.WEST;

        this.add(text, constraints);
        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.weightx = constraints.weighty = 0;
        this.add(label, constraints);
    }
    public void startTimer(){
        timer.start();
    }
    public void setStartTime() {
        minutes = 0;
        seconds = 0;
        label.setText("0" + Integer.toString(minutes) + ":"
                + "0" + Integer.toString(seconds));
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }

    public void actionPerformed(ActionEvent e) {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (seconds < 10 && minutes < 10)
            label.setText("0" + Integer.toString(minutes) + ":"
                    + "0" + Integer.toString(seconds));
        if (seconds >= 10 && minutes < 10)
            label.setText("0" + Integer.toString(minutes) + ":"
                    + Integer.toString(seconds));
        if (seconds < 10 && minutes >= 10)
            label.setText(Integer.toString(minutes) + ":"
                    + "0" + Integer.toString(seconds));
        if (seconds >= 10 && minutes >= 10)
            label.setText(Integer.toString(minutes) + ":"
                    + Integer.toString(seconds));
    }
}
