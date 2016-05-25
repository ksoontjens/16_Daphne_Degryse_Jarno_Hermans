/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    int br,ho;
    Image schipimg, sterrenimg;
    
    int mX = 300;
    int mY = 300;
    int sy = 0;
    
    public MijnComponent()
    {
        this.setBounds(mX,mY,100,100); //x,y,breedte,hoogte
    }
    
    public MijnComponent(int x, int y, int w, int h)
    {
        mX = x;
        mY = y;
        this.setBounds(x,y,w,h);
        br=w;
        ho=h;
        schipimg = this.getToolkit().getImage("spaceship.png");
        sterrenimg = this.getToolkit().getImage("sterren.png");
        //schip.png zetten in c:\program files\technotrend\tt-mhp-browser\fileio\dsmcc\0.03\
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schipimg, 0);
        mt.addImage(sterrenimg, 1);
        try{
            mt.waitForAll();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    public void moveleft()
    {
        mX-=5;
        this.repaint();
    }
    
    public void moveright()
    {
        mX+=5;
        this.repaint();
    }
    
    public void moveup()
    {
        mY-=5;
        this.repaint();
    }
    
    public void movedown()
    {
        mY+=5;
        this.repaint();
    }
    
    public void scroll(){
        sy++;
        if(sy>=570){sy=0;}
        this.repaint();
    }
    
    public void paint (Graphics g){
        g.drawImage(sterrenimg, 0, sy, null);
        g.drawImage(sterrenimg, 0, sy-570, null);
        g.drawImage(schipimg, mX, mY, null);
    }
}
