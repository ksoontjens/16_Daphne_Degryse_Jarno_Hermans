/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    int br, ho;
    Image schipimg;
    Image hemel;
    int x = 300;
    int y = 500;
    int sy = 0;
    public MijnComponent(int a, int b, int c, int d)
    {
     this.setBounds(a,b,c,d);
                   // links naar rechts, boven naar onder, breedte hoogte
     br = c;
     ho= d;

     schipimg=this.getToolkit().getImage("spaceship.png");
     hemel=this.getToolkit().getImage("sterren.png");
     //C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3   hier moet de afbeelding komen
     MediaTracker mt = new MediaTracker(this);
     mt.addImage(schipimg, 0); // img, volgnr
     mt.addImage(hemel, 1);
     try{
     mt.waitForAll();
     }
     catch(InterruptedException ex){
         ex.printStackTrace();
     }

    }
    
    public void moveLeft(){
        x=x-5;
        if(x <= 0){
        x = 0;
        }
        this.repaint();
    }
    
    
    
    public void moveRight(){
        x+=5;
        if(x >= 670){
        x = 670;
        }
        this.repaint();
    }
    
    public void scroll(){
     sy+=5;
     if(sy >= 570){
     sy = 0;
     }
     this.repaint();
    }
    
        
    public void paint(Graphics g)
    {
        g.drawImage(hemel, 0, sy, null);
        g.drawImage(hemel, 0, sy-570, null);
        g.drawImage(schipimg,x,y,null);
       
    }

}
