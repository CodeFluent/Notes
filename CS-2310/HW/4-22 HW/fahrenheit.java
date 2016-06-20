// Modify the Fahrenheit program so that it displays a button that,when pressed,
// also causes the conversion calculation to take place.That is, the user will
// now have the option of pressing enter in the text field or pressing the button.
// Have the listener that is already defined for the text field also listen for the buttonpush.


import javax.swing.JFrame;

public class fahrenheit
{

   public static void main (String[] args)
   {
       JFrame frame = new JFrame("Fahrenheit");
       frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


       Fahrenheitpanel panel = new Fahrenheitpanel();

       frame.add(panel);
       frame.pack();
       frame.setVisible(true);
   }
}
