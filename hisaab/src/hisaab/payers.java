package hisaab;

import java.awt.*;
import javax.swing.*;

class payerFrame extends JDialog
{
 payerFrame()
 {
  super(new HisaabFrame(), "Payers");
  setLocation(500,200);
  setSize(500,200);
  
  payerPanel p=new payerPanel(10,10,10,10);
  p.setLayout(new BorderLayout(10,10));
  
  
  payerPanel p1=new payerPanel(10,10,10,10);
  p1.setLayout(new GridLayout(2,2,10,10));
  
  p.add(p1);
 }
}

class payerPanel extends JPanel
{
 int top,left,bottom,right;
 
 payerPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }
 
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(Color.ORANGE);
 }

 public Insets getInsets()
 {
  return new Insets(top,left, bottom,right);
 }
}


public class payers
{

 public payers()
 {
  // TODO Auto-generated constructor stub
 }

 public static void main(String[] args)
 {
  payerFrame pf=new payerFrame();
  pf.setVisible(true);
 }

}
