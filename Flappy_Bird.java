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

public class FlappyBird implements ActionListener, MouseListener
{

  public static FlappyBird flappyBird;
  
  public Renderer renderer;
  
  public Rectangle bird;
  
  public final int WIDTH=800, HEIGHT=800;
  
  public boolean gameOver;
  
  public ArrayList<Rectangle> columns;
  
  public Random rand;
  
  public int ticks, yMotion;
  
  
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
          jframe.addMouseListener(this);
          bird = new Rectangle(WIDTH/2 -10, HEIGHT/2 -10, 20, 20);
          timer.start();
          
          columns= new ArrayList<Rectangle>();
          addColumn(true);
          addColumn(true);
          addColumn(true);
          addColumn(true);

        }

        public void addColumn()
        {
           int space= 300 ;
           int width= 100 ;
           int height= 50 + rand.nextInt(300);
          
           if (start)
           {
             columns.add( new Rectangle(WIDTH+ width+  columns.size()*300, Height-height-120, width, height));
             columns.add(new Rectangle(WIDTH+ width+  (columns.size()-1)*300,0,width Height-height-space));
           
           }
           else 
           {
             columns.add( new Rectangle(columns.get(columns.size()-1).x+600,HEIGHT-height-120,width,height);
             columns.add(new Rectangle(columns.get(columns.size()-1).x,0,width Height-height-space));
           }
         
          
          
          
          
          
        }
        
  
        public void paintColumn(Graphics g, Rectangle column)
        {
           g.setColor(Color.green.darker());
           g.fillRect(column.x, column.y, column.width, column.height);
          
        
        }
 
        @Override
        public void actionPerformed(ActionEvent e)
        {  
          int speed=10;
          ticks++;
          
          if (started)
          {
          for (int i=0; i< columns.size(); i++)
          {
             Rectangle column=columns.get(i);
             column.x -=10;
          }
          
          if (ticks%2 ==0 && yMotion<15)
          {
            yMotion +=2;   
          }
          for (int i=0; i< columns.size(); i++)
          {
            Rectangle column = columns.get(i);
            if (column.x + column.width < 0)
            {
              columns.remove(column);
              if (column.y==0)
              {
                addColumn(false);
              
              }
              
            }
              
          }
          }
          bird.y+=yMotion;
          
          for (Rectangle column : columns)
          {
           if (column.intersects(bird))
           {
             gameOver= true;
           }
          
          }
          
          if (bird.y > HEIGHT-120 || bird.y<0)
            {
             bird.x=column.x-bird.width;
             gameOver= true;
           }
          }
         
        if (gameOver)
           {
            bird.y=HEIGHT-120-bird.height;
          }
  
         renderer.repaint();
        
       
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
        for (Rectangle column: columns)
        {
          paintColumn(g, column);
        }
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",1,100));
                         
        if (!gameOver)
        {
          g.drawString("Click to start!",100, HEIGHT/2-50)
        }
                   
        if (gameOver)
        {
          g.drawString("Game Over !",100, HEIGHT/2-50)
        }
  
 
  
  
  public static void main(String[] args)
  {
    flappyBird = new FlappyBird();
    
  }
 
