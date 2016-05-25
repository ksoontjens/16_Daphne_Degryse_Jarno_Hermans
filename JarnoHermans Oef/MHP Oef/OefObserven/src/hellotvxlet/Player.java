package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;


public class Player extends Sprite{
    Image mijnimg;
    int richting = 1;
    int teller = 1;
    Random r = new Random();
    static int aantalEnemies = 0;
    
    public Player(int x, int y)
    {
        super(x,y);
        mijnimg=this.getToolkit().getImage("spaceship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
        aantalEnemies++;
        r = new Random();
        r.setSeed(aantalEnemies);
    }
    
    public void Update(int tijd)
    {
        int x = this.getX();
        int y = this.getY();
        
        this.setLocation(x,y);
        

    }
}