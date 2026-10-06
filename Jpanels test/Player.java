import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Player
{
   private int row, col; //data where player is at;
   private int sizex, sizey;
   private ImageIcon placeholder;
   private int xVelocity;
   private int yVelocity;
   
   public Player(int ro, int col)
   {
      row = ro;
      this.col = col;
      sizex = 100;
      sizey = 100;
      placeholder = new ImageIcon("pixil-frame-0.png");
   }
   
   public ImageIcon show()
   {
      return placeholder;
   }
   
   public void setXDirection(int x)
   {
      xVelocity = x;
   }
   
   public int getXCoord()
   {
      return row;
   }
   
   public void setYDirection(int Y)
   {
      yVelocity = Y;
   }
   
   public int getYCoord()
   {
      return col;
   }
   
   public void checkCollisions(int h, int w)
   {
      if(row < 0)
      {
         row = 0;
      }
      else if(row > h)
      {
        row = h;  
      }
      
      if(col < 0)
      {
         col = 0;
      }
      else if(col > w)
      {
         col = w;
      }
   }
   
   public void move()
   {
      row = row + xVelocity;
      xVelocity = 0;
      col = col + yVelocity;
      yVelocity = 0;
   }
   
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_D)
      {
         setXDirection(10);
         move();
      }
      else if(e.getKeyCode() == KeyEvent.VK_A)
      {
         setXDirection(-10);
         move();
      }
      if(e.getKeyCode() == KeyEvent.VK_W)
      {
         setYDirection(-10);
         move();
      }
      else if(e.getKeyCode() == KeyEvent.VK_S)
      {
         setYDirection(10);
         move();
      }
   }
   
   public void keyReleased(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_D)
      {
         setXDirection(0);
         move();
      }
      else if(e.getKeyCode() == KeyEvent.VK_A)
      {
         setXDirection(0);
         move();
      }
      
      if(e.getKeyCode() == KeyEvent.VK_W)
      {
         setYDirection(0);
         move();
      }
      else if(e.getKeyCode() == KeyEvent.VK_S)
      {
         setYDirection(0);
         move();
      }
   }
   
   public void draw(Graphics g, int ro, int col)
   {
      placeholder = new ImageIcon("pixil-frame-0.png");
      row = ro;
      this.col = col;
   }
}