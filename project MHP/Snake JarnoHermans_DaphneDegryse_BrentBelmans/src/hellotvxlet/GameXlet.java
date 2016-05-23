package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class GameXlet implements Xlet
      
{
    HStaticText highscore, score;
    int highscoreNumber = 0;
    int scoreNumber = 0;
    static HScene scene=null; // dit hoort bij de klasse niet het object
    static Subject publisher=null;
    boolean validX = false, validY = false;
    int fruitX = 0;
    int fruitY = 0;
    Segment play1 = null;
    HelloTVXlet mainXlet;
    Timer tim1;
    Canvas canvas;

    public static HScene getScene()
    {
        return scene; 
    }
    public static Subject getPublisher()
    {
        return publisher; 
    }

    public void setCallback(HelloTVXlet main)
    {
        mainXlet=main;
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        canvas = new Canvas(30, 30, 660,510);
        Segment.eerst=true;
        scene=HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        highscoreNumber = ApplicationManagerFactory.getInstance().getApplicationManager().getHighscore();
        highscore = new HStaticText("Highscore: " + highscoreNumber,530,20,300,400); //x, y, w ,h
        highscore.setVerticalAlignment(HStaticText.VALIGN_TOP);
        highscore.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        score = new HStaticText("Score: " + scoreNumber,70,20,300,400); //x, y, w ,h
        score.setVerticalAlignment(HStaticText.VALIGN_TOP);
        score.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        ApplicationManagerFactory.getInstance().getApplicationManager().setTextbox(highscore);
        ApplicationManagerFactory.getInstance().getApplicationManager().setScorebox(score);
        play1=new Segment(210,210);
        play1.setScene(scene);
        while(!validX){
            fruitX = (int)(Math.random()*(Canvas.getInstance().getWidth()+60));
            if((fruitX % 30 == 0)&& (fruitX >= 60) && (fruitX <= Canvas.getInstance().getWidth()-60)){
                validX = true;
            }
        }
        
        while(!validY){
            fruitY = (int)(Math.random()*(Canvas.getInstance().getHeight()+60));
            if((fruitY % 30 == 0)&& (fruitY >= 60) && (fruitY <= Canvas.getInstance().getHeight()-60)){
                validY = true;
            }
        }
        
        Fruit fruit = new Fruit(fruitX,fruitY);
    
        play1.setFruit(fruit, true);
        play1.setFruitXValue(fruitX);
        play1.setFruitYValue(fruitY);
        scene.add(fruit);
        scene.add(play1);
        scene.add(highscore);
        scene.add(score);
        
        scene.add(canvas);
        publisher=new Subject();
        tim1=new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10); //elke 10ms
        publisher.register(play1);
        play1.setCurrentPlayer(play1,publisher);
        play1.setTimer(tim1);
        scene.validate();
        scene.setVisible(true);
        
    }
    
    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        
    }
    
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        		// Hide ourself and remove any components from the HScene
                Slang.getInstance().removeAll();
                tim1.cancel();
		scene.setVisible(false);
                

		// Dispose of our HScene
		HSceneFactory.getInstance().dispose(scene);
		scene = null;
    }
}

