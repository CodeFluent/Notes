// Execute the following

    import javax.swing.JFrame;
    import java.awt.*;
    import javax.swing;

    public class PushCounter {

        public static void main (String [] args) {
            JFrame frame = new JFrame("Push Counter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PushCounterPanel panel = new PushCounterPanel();
            frame.getContentPanel().add(panel);

            frame.pack();
            frame.setVisible(true);
        }
    }
