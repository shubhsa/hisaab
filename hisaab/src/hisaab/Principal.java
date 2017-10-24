package hisaab;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Principal
{
 Principal()
 {
  initialize();
 }

 private void initialize()
 {
  Image trayImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("./img/hisaab.png"));
  TrayIcon tray = new TrayIcon(trayImage, "Tray Icon Example");
  SystemTray sysTray = SystemTray.getSystemTray();
  tray.setImageAutoSize(true);
  tray.addActionListener(new ActionListener()
  {
   @Override
   public void actionPerformed(ActionEvent e)
   {
    JOptionPane.showMessageDialog(null, "it works");
    System.out.println("hello");
   }
  });
  try
  {
   sysTray.add(tray);
  }
  catch (AWTException e)
  {
   e.printStackTrace();
  }
  tray.displayMessage("Attention", "displayMessage.", TrayIcon.MessageType.INFO);
 }

 public static void main(String[] args)
 {
  new Principal();
 }
}