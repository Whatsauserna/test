import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class NewPlayer
{
   private int row, col; //data where player is at;
   int sizex, sizey; //Size of the image
   private ImageIcon placeholder;
   public int speed;
   private int xVelocity;
   private int yVelocity;
   private int jump;
   private Rectangle r;
   
   public NewPlayer(int ro, int col)
   {
      row = ro;
      this.col = col;
      placeholder = new ImageIcon("pixil-frame-0.png");
      sizex = placeholder.getIconWidth();
      sizey = placeholder.getIconHeight();
      speed = 5;
      jump = -10;
      r = new Rectangle(row, col, sizex, sizey);
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
   
   public void checkCollisions()
   {
      if(row < 0)
      {
         yVelocity = 0;
         row = 0;
      }
      else if(row >= CustomizedPanel.SIZE - r.getWidth())
      {
        yVelocity = 0;
        row =(int) (CustomizedPanel.SIZE - r.getWidth());  
      }
      
      if(col < 0)
      {
         xVelocity = 0;
         col = 0;
      }
      else if(col >= CustomizedPanel.SIZE - r.getHeight())
      {
         xVelocity = 0;
         col =(int) (CustomizedPanel.SIZE - r.getHeight());
      }
   }
   
   public void move()
   {
      row = row + xVelocity;
      xVelocity = 0;
      col = col + yVelocity;
      yVelocity = 0;
      checkCollisions();
      
   }
  /* public void jump()
   {
      col = (int) Math.sin(CustomizedPanel.FPS/10);
   }*/
   
   public void changePosition(int m)
   {
      if(m == 1)
      {
         setXDirection(speed);
         move();
      }
      if(m == 2)
      {
         setXDirection(-speed);
         move();
      }
      if(m == 3)
      {
         setYDirection(-speed);
         move();
      }
      if(m == 4)
      {
         setYDirection(speed);
         move();
      }
      /*if(m == 5)
      {
         jump();
      }*/
   }
   
   /*public void keyReleased(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_D)
      {
         setXDirection(0);
         move();
      }
      if(e.getKeyCode() == KeyEvent.VK_A)
      {
         setXDirection(0);
         move();
      }
      
      if(e.getKeyCode() == KeyEvent.VK_W)
      {
         setYDirection(0);
         move();
      }
      if(e.getKeyCode() == KeyEvent.VK_S)
      {
         setYDirection(0);
         move();
      }
   }*/
   
   public void draw(Graphics g, int ro, int col)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      placeholder = new ImageIcon("pixil-frame-0.png");
      row = ro;
      this.col = col;
      r.setLocation(ro,col);
   }
}