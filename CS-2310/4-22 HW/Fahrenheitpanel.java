
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fahrenheitpanel extends JPanel
{
   private JLabel inputLabel, outputLabel,resultLabel;
   private JButton pushmah;
   private JTextField fahrenheit;



   public Fahrenheitpanel()
   {
       inputLabel = new JLabel("Enter Fahrenheit temperature:");
       outputLabel = new JLabel("Temperature in Celsius: ");
       resultLabel = new JLabel("---");

       pushmah = new JButton("Convert");
       pushmah.addActionListener(new TempListener());

       fahrenheit = new JTextField(5);
       fahrenheit.addActionListener(new TempListener());

       add (inputLabel);
       add (fahrenheit);
       add (outputLabel);
       add (resultLabel);
       add (pushmah);
       setPreferredSize (new Dimension(300, 75));
       setBackground(Color.yellow);
   }


   private class TempListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
          int fahrenheitTemp, celsiusTemp;

           String text = fahrenheit.getText();

           fahrenheitTemp = Integer.parseInt (text);
           celsiusTemp = (fahrenheitTemp-32) * 5/9;

           resultLabel.setText (Integer.toString (celsiusTemp));
       }
   }
}
