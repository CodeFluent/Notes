


import javax.swing.JFrame;

public class EmailClient
{

   public static void main (String[] args)
   {
       JFrame frame = new JFrame("Email");
       frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       

       EmailPanel panel = new EmailPanel();

       frame.add(panel);
       frame.pack();
       frame.setVisible(true);
   }
}
