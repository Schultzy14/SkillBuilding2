import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menuscreen {

public static void main (String[] args){    
  JFrame frame = new JFrame("Menu");
  frame.setVisible(true);
  frame.setSize(200,500);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  JPanel panel = new JPanel();
  frame.add(panel);
  
  JButton button1 = new JButton("New Receipts(1)");
  panel.add(button1);
  button1.addActionListener (new Action1());

  JButton button2 = new JButton("Friends");
  panel.add(button2);
  button2.addActionListener (new Action2()); 

  JButton button3 = new JButton("Account Settings");
  panel.add(button3);
  button3.addActionListener (new Action3()); 

}


static class Action1 implements ActionListener {        
  public void actionPerformed (ActionEvent e) {     
    JFrame frame2 = new JFrame("New Receipts");
    frame2.setVisible(true);
    frame2.setSize(200,200);
    JLabel label = new JLabel("Wegmans - 11/16/2015");
    JPanel panel = new JPanel();
    frame2.add(panel);
    panel.add(label);       
  }
}   
static class Action2 implements ActionListener {        
  public void actionPerformed (ActionEvent e) {     
    JFrame frame3 = new JFrame("Friends");
    frame3.setVisible(true);
    frame3.setSize(200,200);

    JLabel label = new JLabel("Keith");
    JPanel panel = new JPanel();
    frame3.add(panel);
    panel.add(label);
  }
}

static class Action3 implements ActionListener {        
  public void actionPerformed (ActionEvent e) {     
    JFrame frame2 = new JFrame("Account Settings");
    frame2.setVisible(true);
    frame2.setSize(200,200);
    JLabel label = new JLabel("Security Settings");
    JPanel panel = new JPanel();
    frame2.add(panel);
    panel.add(label);       
  }
}  
}
