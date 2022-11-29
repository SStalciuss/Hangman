import Components.*;
import java.awt.*;
import javax.swing.*;

class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame("FrameDemo");

    //2. Optional: What happens when the frame closes?
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //3. Create components and put them in the frame.

    frame.add(new DrawField(), BorderLayout.CENTER);
    frame.add(new WordLine(), BorderLayout.CENTER);
    frame.add(new Keyboard(), BorderLayout.CENTER);
    // frame.add(new Dial(), BorderLayout.CENTER);

    //4. Size the frame.
    frame.setPreferredSize(new Dimension(800, 600));
    frame.setLayout(new GridLayout(3, 0));
    frame.pack();

    //5. Show it.
    frame.setVisible(true);
  }
}