/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Canvas extends HComponent{
    
    int x,y,width,height;
    static Canvas instance=null; 
    
    public static Canvas getInstance()
    {
        if (instance==null) instance=new Canvas();
        return instance;
    }
    
    public Canvas(){
        this.setBounds(x,y,width,height);
    }
    
    public Canvas(int initx, int inity, int initwidth, int initheight){
     x = initx;
     y = inity;
     width = initwidth;
     height = initheight;
     this.setBounds(x,y,width,height);
     instance=this;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(DVBColor.white));
        g.drawRect(x,y,width-60,height-60);
    }
}
