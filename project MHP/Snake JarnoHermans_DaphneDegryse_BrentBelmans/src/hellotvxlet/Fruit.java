/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;


public class Fruit extends Sprite{
    Image mijnimg;
    Fruit fruit;
    private int fruitX;
    private int fruitY;
    Random r;
    boolean validX, validY;
    
    public void NewRandomFruit()
    {
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    while(!validX){
            fruitX = (int)(Math.random()*(screenSize.width +0));
            if(fruitX % 30 == 0){
                validX = true;
            }
        }
    while(!validY){
            fruitY = (int)(Math.random()*(screenSize.height +0));
            if(fruitY % 30 == 0){
                validY = true;
            }
        }
    fruit = new Fruit (fruitX, fruitY);
    
    //HelloTVXlet.publisher.setFruit(fruit2);
    
    }
    
    public void RemoveFruit(Fruit initfruit){
            GameXlet.scene.remove(initfruit);
            GameXlet.publisher.unregister(initfruit);
    }
    
    public Fruit(int x, int y)
    {
        super(x,y);
        mijnimg=this.getToolkit().getImage("fruit.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        //this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
        this.setBounds(x,y,mijnimg.getWidth(this), mijnimg.getHeight(this));
    }

    public void update(int tijd) {
        
    }
}
