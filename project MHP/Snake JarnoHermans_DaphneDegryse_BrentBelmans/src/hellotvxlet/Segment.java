package hellotvxlet;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class Segment extends Sprite implements UserEventListener {


    static Timer currentTimer;
    HScene scene = null;
    Segment currentPlayer = null;
    Subject currentPublisher=null;

    Image mijnimg, fruitimg;
    int speed=16;
    int teller=0;
    Random r;
    static int aantalEnemies=0;
    int richting=1;
    int mx,my;
    Segment volgende=null;
    boolean kop=false;
    static boolean eerst=true;
    int lengte=0;
    int snakeLengte = 0;
    int[] snakeCoordinaten;
    int fruitX, fruitY;
    boolean fruitSpawned = true;
    Fruit currentFruit = null;
    boolean readyToGrow = false;
    boolean validX = false;
    boolean validY = false;
    HelloTVXlet mainXlet;
    int canvasWidth;
    int canvasHeight;
    boolean paused = false;
    
    public Segment(int x, int y)
    {
        super(x,y);
        mx=x; my=y;
        mijnimg=this.getToolkit().getImage("kop.png");
        UserEventRepository rep = new UserEventRepository("naam");
       rep.addAllArrowKeys();
        MediaTracker mt=new MediaTracker(this);
        EventManager e = EventManager.getInstance();
        e.addUserEventListener(this,rep); 
        mt.addImage(mijnimg, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
        if (eerst){
            
            kop=true; 
        } 
        eerst=false;
        canvasWidth = Canvas.getInstance().getWidth() - 30;
        canvasHeight = Canvas.getInstance().getHeight()- 30;
    }
    
    
        public void setFruitXValue(int x){
            fruitX = x;
        }
        
        public void setFruitYValue(int y){
            fruitY = y;
        }
        
        public void setFruit(Fruit initfruit, boolean initfruitspawned){
            currentFruit = initfruit;
            fruitSpawned = initfruitspawned;
        }
        

        
        public void setScene (HScene initscene){
            scene = initscene;
        }
        
        public void setCurrentPlayer(Segment player, Subject publisher){
            currentPlayer = player;
            currentPublisher = publisher;
        }
        
        public void setTimer(Timer initTimer){
            currentTimer = initTimer;
        }
        
        public void spawnFruit(){
            while(!validX){
                    fruitX = (int)(Math.random()*(canvasWidth + 60));
                    if((fruitX % 30 == 0)&& (fruitX >= 60) && (fruitX <= canvasWidth-60)){
                        validX = true;
                        setFruitXValue(fruitX);
                    }
                }
                  validX = false;
            while(!validY){
                    fruitY = (int)(Math.random()*(canvasHeight + 60));
                    if((fruitY % 30 == 0) && (fruitY >= 60) && (fruitY <= canvasHeight-60)){
                        validY = true;
                        setFruitYValue(fruitY);
                    }
                }
                  validY = false;
          
          Fruit fruit = new Fruit(fruitX, fruitY);
          currentFruit = fruit;
          GameXlet.getScene().add(fruit);
          if(Slang.getInstance().checkFreeSpace(fruit)){
                    fruitSpawned = true;
          }else{
            currentFruit.RemoveFruit(currentFruit);
            spawnFruit();
          }

        }
        
    
        public void update(int tijd) {
            
         if(!fruitSpawned){
          
          spawnFruit();
         }
         
         if(tijd%speed == 0){
            if (richting==1) mx += 30;
            if (richting==2) my += 30;
            if (richting==3) mx -= 30;
            if (richting==4) my -= 30;
         }
         
         if((mx < 60 || mx > canvasWidth) || (my < 60 || my > canvasHeight)){
            System.out.println("Out of bounds");
            try {
                ApplicationManagerFactory.getInstance().getApplicationManager().respawn();
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
         }
         
         if((fruitX == mx) && (fruitY == my)){
            
            currentFruit.RemoveFruit(currentFruit);
            
            fruitSpawned = false;
            readyToGrow = true;
         }
        
         if(readyToGrow){
            lengte = snakeLengte;
            snakeLengte++;
            ApplicationManagerFactory.getInstance().getApplicationManager().updateScore();
            readyToGrow = false;
         }
         
         this.setBounds(mx,my,mijnimg.getWidth(this), mijnimg.getHeight(this));
            
    }
        public void groei(HScene s)
        {
            //System.out.println("GROEI!!");
            //snakeLengte++;
          if (!kop)  return;
          
          Segment seg=new Segment(mx,my);
          
          if(Slang.getInstance().checkCollisionWith(seg)){
            try {
                ApplicationManagerFactory.getInstance().getApplicationManager().respawn();
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
          }else{
            Slang.getInstance().add(seg);
          }
          
          
          
          s.add(seg);
          s.repaint();
          
          Segment temp=volgende; 
          this.volgende=seg;
          seg.volgende=temp;
          
          lengte++;
          System.out.println("length="+lengte);
          
          if (lengte>snakeLengte)
          {
                Segment sx=this;
                Segment voorlaatst=null;
                while (sx.volgende!=null)
                {
                    voorlaatst=sx;
                    sx=sx.volgende;
                }
                
                
                Slang.getInstance().remove(sx);
                 
                s.remove(sx);
                voorlaatst.volgende=null;
                
          }         
          
        }
        
        public void userEventReceived(UserEvent e) {
        if(e.getType()== KeyEvent.KEY_PRESSED){
            if(e.getCode() == HRcEvent.VK_LEFT){
               if(richting != 1)
               richting = 3;
            }
            if(e.getCode() == HRcEvent.VK_RIGHT){
                if(richting != 3)
                 richting = 1;
            }
            if(e.getCode() == HRcEvent.VK_UP){
                if(richting != 2)
                richting = 4;
            }
            if(e.getCode() == HRcEvent.VK_DOWN){
                if(richting != 4)
                richting = 2;
            }  
        }
        
    }
}
