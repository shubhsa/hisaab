package hisaab;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.swing.*;

class MenuFrame extends JFrame implements ActionListener,MouseListener
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton newRec,oldRec,myRec;  //declaring global references of JButtons for adding new or accessing old records and settings.
 JLabel title,uname,uset;     //declaring two global references of JLabels for displaying welcome message and the username of the logged person.
 JLabel spiral,topDesign,bottomDesign;  //Declaring three global JLabel references for top,bottom and side spiral design. 
 JPopupMenu p;                   //declaring global variable for the popup menu.
 JMenuItem pm1,pm2,pm3,pm4;     //declaring global variables for menuItems in popup menu.
 
 MenuFrame()
 { 
  super("Hisaab");                                 //setting title of the frame as "Hisaab"
  setSize(780,600);                                  //setting size of the Menu frame as 800*600
  setLocation(140,40);                               //setting the location of the frame at coordinates (140,40)
  setResizable(false);                               //setting window as not resizable
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/hisaab.png"))); //setting the application icon
  
  title=new JLabel("Welcome to Hisaab");              //adding welcome message on title JLabel
  title.setFont(new Font("Georgia",Font.BOLD,40));    //setting the font as Georgia with bold attribute and font size 40 
  title.setForeground(Color.DARK_GRAY);               //setting the foreground color as Dark Gray
  title.setHorizontalAlignment(JLabel.CENTER);        //Aligning Label to center
  
  uname=new JLabel("Mr."+LoginFrame.userName);        //adding user-name on uname JLabel with String userName declared as static at loginFrame
  uname.setHorizontalTextPosition(JLabel.LEFT);
  uname.setFont(new Font("Georgia",Font.BOLD,40));    //setting the font as Georgia with bold attribute and font size 40 
  uname.setForeground(Color.darkGray);                //setting the foreground color as Dark Gray
  uname.setHorizontalAlignment(JLabel.RIGHT);        //Aligning Label to RIGHT so that it can be aligned to the setting button
  
  newRec=new JButton("Naya Hisaab");                   //adding newRec button with Label "Naya Hisaab meaning new record"
  newRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/newRec.png")))); //adding ImageIcon to the Label newRec
  newRec.setFont(new Font("georgia",Font.PLAIN,20));   //setting the font as Georgia with bold attribute and font size 20
  newRec.setBackground(new Color(128, 0, 64));         //adding custom background to the button newRec
  newRec.setForeground(Color.white);                   //adding white foreground to the button newRec
  newRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //setting HAND Cursor for newRec button
  newRec.setFocusable(false);                          //setting button as not focusable
  
  oldRec=new JButton("Poorana Hisaab");                 //adding newRec button with Label "Naya Hisaab meaning new record"
  oldRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/oldRec.png"))));  //adding ImageIcon to the Label oldRec
  oldRec.setFont(new Font("georgia",Font.PLAIN,20));    //setting the font as Georgia with bold attribute and font size 20
  oldRec.setBackground(new Color(128, 0, 64));          //adding custom background to the button oldRec
  oldRec.setForeground(Color.WHITE);                    //adding white foreground to the button oldRec
  oldRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //setting HAND Cursor for oldRec button
  oldRec.setFocusable(false);                          //setting button as not focusable
  
  myRec=new JButton("Mera Hisaab(BETA)");                   //adding newRec button with Label "Naya Hisaab meaning new record"
  myRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/wallet.png"))));   //adding ImageIcon to the Label newRec
  myRec.setFont(new Font("georgia",Font.PLAIN,20));   //setting the font as Georgia with bold attribute and font size 20
  myRec.setBackground(new Color(128, 0, 64));         //adding custom background to the button newRec
  myRec.setForeground(Color.white);                   //adding white foreground to the button newRec
  myRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //setting HAND Cursor for newRec button
  myRec.setFocusable(false);     //setting button as not focusable
  
  
  uset=new JLabel();                                  //creating JLabel for user settings
  uset.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/settings.png"))));//adding settings icon to link settigns menu
  uname.setToolTipText("User Settings");             //adding tooltip for user Settings
  uset.setHorizontalAlignment(JLabel.LEFT);           //Aligning it to the left of uname
  
  //adding design elements using JLabels
  
  spiral=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/spiral.png"))));
  topDesign=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/topp.png"))));
  bottomDesign=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/bottom.png"))));

  /**
   *We will be creating total 7 JPanels.
   */
  
  MenuPanel main=new MenuPanel(0,0,0,0);           //Main panel
  main.setLayout(new BorderLayout(0,0));
  
   MenuPanel m=new MenuPanel(0,0,0,0);            //Sub-MainPanel where we will be adding buttons and Labels.
   m.setLayout(new BorderLayout(0,0));
   
    MenuPanel m1=new MenuPanel(30,0,0,0);          //Panel for welcome message,user-name labels and buttons
    m1.setLayout(new GridLayout(3,1,0,0));
   
     MenuPanel m11=new MenuPanel(0,0,0,0);        //Panel for welcome message
     m11.setLayout(new GridLayout(2,1,0,0));
     
     MenuPanel m111=new MenuPanel(0,200,0,0);        //Panel for user-name label and settings menu
     m111.setLayout(new GridLayout(1,2,10,0));
    
     MenuPanel m12=new MenuPanel(40,60,20,60);   //panels for the two buttons i.e newRec and oldRec 
     m12.setLayout(new GridLayout(1,2,70,0));
     
     MenuPanel m15=new MenuPanel(20,200,40,250);   //panels for the two buttons i.e newRec and oldRec 
     m15.setLayout(new GridLayout(1,1,0,0));
   
     MenuPanel m13=new MenuPanel(0,0,0,0);        //Panel to add Top design at NORTH
     m13.setLayout(new GridLayout(1,1,0,0));
   
     MenuPanel m14=new MenuPanel(0,20,0,0);       //panel to add bottom design to SOUTH
     m14.setLayout(new GridLayout(1,1,0,0)); 
    
   MenuPanel m2=new MenuPanel(0,0,0,0);           //panel to add Spiral on the WEST
   m2.setLayout(new GridLayout(1,1,0,0));
   
   
   m11.add(title);
   m11.add(m111);
   
   m111.add(uname);
   m111.add(uset);
   
   m12.add(newRec);
   m12.add(oldRec);
   
   m15.add(myRec);
   
   m13.add(topDesign);
   m14.add(bottomDesign);
   
   m1.add(m11);
   m1.add(m12);
   m1.add(m15);
  
   m.add(m13,BorderLayout.NORTH);
   m.add(m1,BorderLayout.CENTER);
   m.add(m14,BorderLayout.SOUTH);
 

   m2.add(spiral);
   
   main.add(m);
   main.add(m2,BorderLayout.WEST);
   add(main);
   
   //registering for events
   newRec.addActionListener(this);
   oldRec.addActionListener(this);
   myRec.addActionListener(this);
   uset.addMouseListener(this);
   //new HisaabFrame().notifyCheck(); //for tray notification
   
   p=new JPopupMenu();
   
   
   pm1=new JMenuItem("Delete My Account");
   pm2=new JMenuItem("Delete My Records");
   pm3=new JMenuItem("Change Password");
   pm4=new JMenuItem("Logout");
   
   p.add(pm1);
   p.add(pm2);
   p.add(pm3);
   p.add(pm4);

   pm1.addActionListener(this);
   pm2.addActionListener(this);
   pm3.addActionListener(this);
   pm4.addActionListener(this);
 }


 @Override
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==newRec)
  {
   newRecFrame nrf=new newRecFrame();
   nrf.setVisible(true);
  }
  else
  if(e.getSource()==oldRec)
  {
   HisaabFrame hf=new HisaabFrame();
   hf.setVisible(true);
   dispose();
  }
  if(e.getSource()==myRec)
  {
   JOptionPane.showMessageDialog(this,"Coming soon");
  }
  if(e.getSource()==pm1)
  {
   actions(1);
  }
  if(e.getSource()==pm2)
  {
   actions(2);
  }
  if(e.getSource()==pm3)
  {
   actions(3);
  }
  if(e.getSource()==pm4)
  {
   dispose();
   new Login();
  }

 }
 
  private void actions(int option)
  {
   LoginFrame lf=new LoginFrame();
   String input=JOptionPane.showInputDialog(this, "Enter your Password to proceed","Critical Action", JOptionPane.WARNING_MESSAGE);
   try
   {
    ResultSet rs = Connect.selLog.executeQuery();
    while (rs.next())
    {
     try
     {
      lf.ibyte = input.getBytes();
      lf.ebyte = LoginFrame.encrypt(rs.getString(3).getBytes(), lf.ibyte);
      lf.encrypted = new String(lf.ebyte);
     }
     catch (BadPaddingException be)
     {
      System.out.println("Wrong key");
     }
     catch(Exception ee)
     {
      ee.printStackTrace();
     }
     if(lf.encrypted.equals(rs.getString(2)))
     {
      if(option==1)
      {
       int opt=JOptionPane.showConfirmDialog(this,"This Action Cannot be Undone, Are you sure you want to delete your account?","WARNING!", JOptionPane.OK_CANCEL_OPTION);
       if(opt==0)
       {
        Connect.st.executeUpdate("truncate login");
        Connect.st.executeUpdate("truncate people");
        JOptionPane.showMessageDialog(this,"Your Account has been Deleted Successfully\nThanks for using Hisaab Mr"+LoginFrame.userName+"\nFor any feedback - ishubhsa@gmail.com");
        dispose();
        new LoginFrame().setVisible(true);
        break;
       }
      }
      else
      if(option==2)
      {
       int opt=JOptionPane.showConfirmDialog(this,"This Action Cannot be Undone, Are you sure you want to delete all your Records?","WARNING!", JOptionPane.OK_CANCEL_OPTION);
       if(opt==0)
       {
        Connect.st.executeUpdate("truncate people");
        JOptionPane.showMessageDialog(this,"All records have been Deleted Successfully!");
        break;
       }
      }
      else
      if(option==3)
      {
       char[] npass=JOptionPane.showInputDialog("Please Enter your new password").toCharArray();
       char[] rnpass=JOptionPane.showInputDialog("Please Enter your new password again").toCharArray();
       if(Arrays.equals(npass,rnpass))
       {
        lf.generateSymmetricKey();
        lf.ibyte = new String(npass).getBytes();
        lf.ebyte = LoginFrame.encrypt(LoginFrame.raw, lf.ibyte);
        Connect.resPass.setString(1,new String(lf.ebyte));
        Connect.resPass.setString(2,new String(LoginFrame.raw));
        Connect.resPass.executeUpdate();
        JOptionPane.showMessageDialog(this, "Password Changed Successfully,Please Login again.");
        dispose();
        new LoginFrame().setVisible(true);
       }
       else
       {
        JOptionPane.showMessageDialog(this,"passwords do not match!");
       }
      }
     }
     else
     {
      JOptionPane.showMessageDialog(this, "Wrong Password!");
     }
    }
   }
   catch (SQLException se)
   {
    System.err.print("SQL ALERT[login] - " + se.getMessage());
   }
   catch(Exception e)
   {
    e.getStackTrace();
   }
  }
  


 @Override
 public void mouseClicked(MouseEvent me)
 {
  if(me.getSource()==uset)
  {
  // JOptionPane.showMessageDialog(this,"Upcoming Feature","User Settings",JOptionPane.INFORMATION_MESSAGE);
   p.show(this,555,215);
  }
 }

 @Override
 public void mouseEntered(MouseEvent arg0){}
 @Override
 public void mouseExited(MouseEvent arg0){}
 @Override
 public void mousePressed(MouseEvent arg0){}
 @Override
 public void mouseReleased(MouseEvent arg0){}
 
}

class MenuPanel extends JPanel
{
 int top,left,bottom,right;                           //variables for insets
 
 MenuPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }
 
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  //setBackground(new Color(235,235,234));
  setBackground(Color.ORANGE);
 }
 
 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }
}

public class HisaabMenu
{
 public static void main(String arg[])
 {
  MenuFrame mf=new MenuFrame();                    //creating a frame object
  mf.setVisible(true);                             //making the frame visible on the screen
 }
}
