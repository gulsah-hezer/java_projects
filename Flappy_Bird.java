/*In the below project, instead of a bird playing the game, we have a small red-dot. 
Apart from the red-dot, everything else looks and feels like same as the flappy-bird game app, including the background, pillars, etc.
The aim of the game is to control the bird(red-dot) and move into the spaces between the pillars.
The hard part is to control the bird. You will score 1 point every time if you pass the green pillar successfully.
This project has used more colors than any other previous game projects.
There is extensive use of java swing classes and of course OOPs concepts./*

package FlappyBird;
import javax.swing.Jframe;


public class FlappyBird
{

  public static FlappyBird flappyBird;
  
  public FlappyBird()
  {
    Jframe jframe=new Jframe();
    jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    jframe.setSize(WIDTH, HEIGHT);
    jframe.setVisible(true);
    
    
  }
  
  
  
  
  
  public static void main(String[] args)
  {
    flappyBird = new FlappyBird();
    
  }
 
