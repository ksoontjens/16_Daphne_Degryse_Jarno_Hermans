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
    Image schipimg;
    
    public MijnComponent()
    {
        this.setBounds(300,300,100,100); //x,y,breedte,hoogte
    }
    
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h);
        br=w;
        ho=h;
        this.getToolkit().getImage("schip.png");
        //schip.png zetten in c:\program files\technotrend\tt-mhp-browser\fileio\dsmcc\0.03\
        MediaTracker mt = new MediaTracker();
        mt.addImage(schipimg, 0);
        try{
            mt.wait();
        }catch{}
    }
    
    public void paint (Graphics g){
        g.setColor(new DVBColor(0,0,63,179));
        g.fillRoundRect(10, 10, br-10, ho-10,15,15); //x,y,br,ho,rx,ry
        g.setColor(new DVBColor(0,0,179,179));
        g.fillRoundRect(0, 0, br-10, ho-10,15,15); //x,y,br,ho,rx,ry
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("Hallo", 50, 50);
        
        g.drawImage(schipimg, 0, 0, null);
    }
}
