/*In the below project, instead of a bird playing the game, we have a small red-dot.*/
/*Apart from the red-dot, everything else looks and feels like same as the flappy-bird game app, including the background, pillars, etc.*/
/*The aim of the game is to control the bird(red-dot) and move into the spaces between the pillars.*/
/*The hard part is to control the bird. You will score 1 point every time if you pass the green pillar successfully.*/
/*This project has used more colors than any other previous game projects.*/
/*There is extensive use of java swing classes and of course OOPs concepts.*/

package FlappyBird;

import javax.swing.Jframe;
import java.util.Timer;
import java.awt.Graphics;

public class FlappyBird
{

  public static FlappyBird flappyBird;
  
  public Renderer renderer;
  
  public Rectangle bird;
  
  public final int WIDTH=800, HEIGHT=800;
  
  public ArrayList<Rectangle> columns;
  
  public Random rand;
  
  
  
        /*Constructor*/
        public FlappyBird()
        {
          Jframe jframe = new Jframe(); 
          Timer timer = new Timer();

          renderer= new Renderer();

          jframe=add(renderer);

          jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
          jframe.setSize(WIDTH, HEIGHT);
          jframe.setVisible(true);
          bird = new Rectangle(WIDTH/2 -10, HEIGHT/2 -10, 20, 20);
          timer.start();
          
          columns= new ArrayList<Rectangle>();

        }

        public void addColumn()
        {
           int space= 300 ;
           int width= 100 ;
           int height= 50 + rand.nextInt(300);
          
          columns.add( new Rectangle(WIDTH+ width+  columns.size()*300, height));
          
          
        }
        
  
        public void paintColumn(Graphics g, Rectangle column)
        {
           g.setColor(Color.green.darker());
           g.fillRect(column.x, column.y, column.width, column.height);
          
        
        }
 
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         renderer.repaint();
        }
  
  
        public void repaint(Graphics g)
        {
          g.setColor(Color.cyan);
          g.fillRect(0,0,WIDTH, HEIGHT);
          
          g.setColor(Color.orange);
          g.fillRect(0,HEIGHT-150, WIDTH, 150);
          
          g.setColor(Color.green);
          g.fillRect(0,HEIGHT-150, WIDTH, 20);
         
          g.setColor(Color.red);
          g.fillRect(bird.x,bird.y, bird.width, bird.height);
          
        }

  
 
  
  
  public static void main(String[] args)
  {
    flappyBird = new FlappyBird();
    
  }
 
