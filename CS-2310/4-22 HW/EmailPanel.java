// Develop an application that implements a prototype
// user interface for composing an email message. The application should have text
// fields for the To, Cc, and Bcc address lists and subject line, and one for the
// message body. Include a button labeled Send. When the send button is pushed, the
// program should print the contents of all fields to standard output using println
// statements.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmailPanel extends JPanel
{
   private JLabel toLabel, ccLabel, bccLabel, subjectLabel, messageLabel;
   private JButton sendButton;
   private JTextField toBox, ccBox, bccBox, subjectBox;
   private JTextArea messageBox;



   public EmailPanel()
   {
       toLabel= new JLabel("To:");
       ccLabel = new JLabel("CC: ");
       bccLabel = new JLabel("Bcc:");

       subjectLabel = new JLabel("Subject: ");
       messageLabel = new JLabel("Message: ");


       sendButton = new JButton("Send");
       sendButton.addActionListener(new TempListener());

       toBox = new JTextField(5);

       ccBox = new JTextField(5);

       bccBox = new JTextField(5);

       subjectBox = new JTextField(20);

       messageBox = new JTextArea(20, 30);

    //    setLayout(new GridBagLayout());


       add(subjectLabel);
       add(subjectBox);

       add (toLabel);
       add (toBox);

       add (ccLabel);
       add (ccBox);

       add (bccLabel);
       add (bccBox);

       add(messageLabel);
       add(messageBox);

       add (sendButton);
       setPreferredSize (new Dimension(680, 780));
       setBackground(Color.yellow);
   }


   private class TempListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {

           // don't loop becuz it will cause issues with printing

           String subjectPrint = subjectBox.getText();
           String toPrint = toBox.getText();
           String ccPrint = ccBox.getText();
           String bccPrint = bccBox.getText();
           String messagePrint = messageBox.getText();

           System.out.println();
           System.out.println("Subject: " + subjectPrint);
           System.out.println();
           System.out.println("To: " + toPrint);
           System.out.println();
           System.out.println("CC: " + ccPrint);
           System.out.println();
           System.out.println("BCC: " + bccPrint);
           System.out.println();
           System.out.println("Message: ");
           System.out.println();
           System.out.println("\t" + messagePrint);



       }
   }
}
