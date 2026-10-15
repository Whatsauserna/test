import java.util.HashSet;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;                          //there is a swing timer and an awt timer, so we have to be specific and not use .*
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCustom extends JPanel implements KeyListener
{
   private final static int SIZE = 1000;
   private static Timer time;
   private static final int textSize = 25;         //font size
   private static final int DELAY = 0;
   private static HashSet<Integer> pressedKeys;    //collection of which keys are pressed down on the keyboard
   private static int playerX, playerY;
   private Player p;
   private static ImageIcon i;
   private static Timer t;							      //used to control what happens each frame (game code)
   
   public PanelCustom()
   {
      playerX = SIZE/2;
      playerY = SIZE/2;
      pressedKeys = new HashSet<Integer>();
      p = new Player(playerX,playerY);
      i = new ImageIcon();
      t = new Timer(DELAY, new Listener());	      //the higher the value of DELAY, the slower the refresh rate is
      t.start();
      
   }
   
   //post:  shows which keys are currently being pressed, and an orange dot that can be moved with arrow keys
   public void showGraphics(Graphics g)	
   {
      g.setColor(Color.pink);		            //draw a SIZExSIZE blue square
      g.fillRect(0, 0, SIZE, SIZE);
      i = p.show();
      g.drawImage(i.getImage(),playerX,playerY,i.getImageObserver());
      p.draw(g,playerX,playerY);
   }
   
   //inherited by JPanel - override to display the graphics we want to show
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      showGraphics(g);				      
   }
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)	   //this is called for each timer iteration
      {
         //have your game code method calls here - the ones that should be updated every frame
         repaint();                                   //repaint() automatically calls paintComponent(g) which calls showGraphics(g)
      }
   }

   public void keyTyped(KeyEvent e)                   //don't need this one
   {}
      
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode()==KeyEvent.VK_ESCAPE)	         //End the program	
         System.exit(1);
      pressedKeys.add(e.getKeyCode());                //add key to list of keys pressed
      p.keyPressed(e);
      p.checkCollisions(SIZE,SIZE);
      playerX = p.getXCoord();
      playerY = p.getYCoord();
   }
   
   public void keyReleased(KeyEvent e)
   {
      pressedKeys.remove((Integer)(e.getKeyCode()));  //remove key from list of keys pressed
      p.keyReleased(e);
   }
   
}