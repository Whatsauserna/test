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
      
      
      JFrame frame = new JFrame("This is a test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(true);
      
      CustomizedPanel screen3 = new CustomizedPanel();
      screen3.setBounds(0,0,CustomizedPanel.SIZE,CustomizedPanel.SIZE);
      
      frame.pack();
      
      frame.setLayout(null);
      frame.setSize(1000,1000);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.add(screen3);
      //frame.addKeyListener(screen3);
      frame.setContentPane(screen3);
      screen3.startGameThread();
      
   }
}