import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

public class Test
{
   

   public static void main(String[] args)
   {
      
      PanelCustom screen3 = new PanelCustom();
      screen3.setBounds(0,0,1000,1000);
      screen3.setBackground(Color.pink);
      
      JFrame frame = new JFrame("This is a test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.setSize(1000,1000);
      frame.setLocation(1,1);
      frame.setVisible(true);
      frame.addKeyListener(screen3);
      frame.setContentPane(screen3);
      
   }
}