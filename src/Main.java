import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Components.*;

class Main  {
    public static void main (String[] args) {
        JFrame frame = new JFrame("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        DrawField drawField = new DrawField();
        WordLine workLine = new WordLine();
        Keyboard keyboard = new Keyboard();

        frame.getContentPane().add(drawField.getInput(), BorderLayout.CENTER);
        frame.getContentPane().add(workLine.getInput(), BorderLayout.CENTER);
        frame.getContentPane().add(keyboard.getButton(), BorderLayout.CENTER);

        //4. Size the frame.
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLayout(new GridLayout(3,0));
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }

    // imported form java.awt.event.*;  
    // public static ActionListener testListener(){
    //     ActionListener listener = new ActionListener(){
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //         System.out.println("Button clicked");
    //             // JOptionPane.showMessageDialog(this, textBox.getText());
    //         }
    //     };
    //     return listener;
    // }
}