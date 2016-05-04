/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class Player extends Sprite{
    Image mijnimg;
    int richting = 1;
    public Player(int x, int y){
     super(x, y);
     mijnimg = this.getToolkit().getImage("Spaceship.png");
     MediaTracker mt = new MediaTracker(this);
     mt.addImage(mijnimg, 1);
     try{
         mt.waitForAll();}
     
        catch(InterruptedException ex){
     
     ex.printStackTrace();
    }
  
     this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
     this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
    }


    
   
    public void update(int tijd) {

    }
    
}
     
        
