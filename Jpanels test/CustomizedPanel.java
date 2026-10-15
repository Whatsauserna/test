import java.util.HashSet;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;                          //there is a swing timer and an awt timer, so we have to be specific and not use .*
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

public class CustomizedPanel extends JPanel implements Runnable
{
   public final static int SIZE = 1000;
   
   Thread gameThread;
   KeyHandler keyH = new KeyHandler();
   
   //Sets FPS
   int FPS = 60;
   
   //creates player
   NewPlayer p;
   ImageIcon i;
   
   //Set player's default position
   int playerX = SIZE/2;
   int playerY = SIZE/2;
   
   public CustomizedPanel()
   {
      this.setPreferredSize(new Dimension(SIZE,SIZE));
      this.setBackground(Color.green);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
      p = new NewPlayer(playerX,playerY);
      i = new ImageIcon();
   }
   
   public void  startGameThread()
   {
      gameThread = new Thread(this);
      gameThread.start();
   }
   
   @Override
   public void run()
   {
      double drawInterval = 1000000000/FPS;
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;
   
      while(gameThread != null)
      {
         currentTime = System.nanoTime();
         
         delta += (currentTime - lastTime)/drawInterval;
         
         lastTime = currentTime;
         
         if(delta > 1)
         {
            //Update : update info such as character positions
            update();
            //draw the screen with the updated information
            repaint();
            delta--;
         }
         
      }
   }
   
   public void update()
   {
      if(keyH.upPressed == true)
      {
         p.changePosition(3);
         playerX = p.getXCoord();
         playerY = p.getYCoord();
      }
      if(keyH.downPressed == true)
      {
         p.changePosition(4);
         playerX = p.getXCoord();
         playerY = p.getYCoord();
      }
      if(keyH.leftPressed == true)
      {
         p.changePosition(2);
         playerX = p.getXCoord();
         playerY = p.getYCoord();
      }
      if(keyH.rightPressed == true)
      {
         p.changePosition(1);
         playerX = p.getXCoord();
         playerY = p.getYCoord();
      }
      if(keyH.spacePressed == true)
      {
         p.changePosition(5);
         playerX = p.getXCoord();
         playerY = p.getYCoord();
      }
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      
      Graphics2D g2 = (Graphics2D) g;
      
      g2.setColor(Color.white);
      
      //g2.fillRect(playerX,playerY,p.sizex,p.sizey);
      
      i = p.show();
      g2.drawImage(i.getImage(),playerX,playerY,i.getImageObserver());
      p.draw(g,playerX,playerY);
      
      g2.dispose();
   }
}