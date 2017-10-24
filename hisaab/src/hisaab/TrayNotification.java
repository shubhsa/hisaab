package hisaab;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImagingOpException;

import javax.swing.ImageIcon;

public class TrayNotification implements MouseListener, ActionListener
{
 TrayIcon trayIcon;
 SystemTray tray;

 public static void main(String[] args) throws AWTException
 {
  
  TrayNotification td = new TrayNotification();
  td.displayTray();

 }

 public void displayTray() throws AWTException
 {
  // Obtain only one instance of the SystemTray object
  tray = SystemTray.getSystemTray();
  // Creating a tray icon
  ImageIcon icon = new ImageIcon(getClass().getResource("./img/hisaab.png"));
  Image image = icon.getImage();
  // System.out.println(image);
  trayIcon = new TrayIcon(image, "Hisaab Tray");
  // Let the system resizes the image if needed
  trayIcon.setImageAutoSize(true);
  // Set tooltip text for the tray icon
  trayIcon.setToolTip("Hisaab!");
  tray.add(trayIcon);
  trayIcon.displayMessage("Hello "+LoginFrame.userName, "Some people need to pay today", MessageType.INFO);
  
 // trayIcon.addMouseListener(this);
  trayIcon.addActionListener(this);
  trayIcon.addMouseListener(this);

 }

 @Override
 public void mouseClicked(MouseEvent e)
 {
  // new LoginFrame().setVisible(true);
   System.out.println("clicked");
 }

 @Override
 public void mouseEntered(MouseEvent e)
 {
  if (e.getSource() == trayIcon)
  {
   new payerFrame().setVisible(true);
   System.out.println("hello");
  }

 }

 @Override
 public void mouseExited(MouseEvent e)
 {
  // TODO Auto-generated method stub

 }

 @Override
 public void mousePressed(MouseEvent e)
 {
  // TODO Auto-generated method stub

 }

 @Override
 public void mouseReleased(MouseEvent e)
 {
  // TODO Auto-generated method stub

 }

 @Override
 public void actionPerformed(ActionEvent e)
 {
   new payerFrame().setVisible(true);
   System.out.println("clickeds");
   trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.INFO);

 }
}