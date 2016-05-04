package hellotvxlet;

import java.awt.Color;
import java.util.Timer;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;




public class HelloTVXlet implements Xlet
{
    static HScene scene = null; //dit hoord bij de kalsse en het object
    static Subject publisher= null;
    Player player = new Player(400,400);
    public static HScene getScene(){
     return scene;
     
    }
    
    public static Subject getPublisher(){
     return publisher;
     
    }
    
    public void initXlet(XletContext arg0) 
    {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(player);
        publisher = new Subject();
        Timer timl = new Timer();
        timl.scheduleAtFixedRate(publisher, 0, 10);
        
        for(int i = 0 ; i < 5; i++)
        {
         for(int j = 0 ; j < 3; j++)
         {
          Enemy e = new Enemy (i*70,j*70);
          scene.add(e);
          publisher.register(e);
         }
        }

        publisher.register(player);
        scene.validate();
        
        scene.setVisible(true);
    }

    public void startXlet() throws XletStateChangeException 
    {
        
    }

    public void pauseXlet() 
    {
        
    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException 
    {
        
    }

        
}


    
    

    
    


   
    

