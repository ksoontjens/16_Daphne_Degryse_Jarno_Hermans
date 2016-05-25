package hellotvxlet;

import java.awt.Color;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet{
// Elke bitmap een eigen leven geven
    static HScene scene = null; // dit hoort bij de klasse, niet het object
    static Subject publisher = null;
    public static HScene getScene()
    {
        return scene;
    }
    public static Subject getPublisher()
    {
        return publisher;
    }
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        Player play1 = new Player(400,500);
        scene.add(play1);
        
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10); // elke 10ms
        
        for(int x=0; x< 3; x++)
        {
            for(int y=0; y< 2; y++)
            {
                Enemy e = new Enemy(x*150, y*150);
                scene.add(e);
                publisher.register(e);
            }
        }
        
        
        publisher.register(play1);
        scene.validate();
        scene.setVisible(true);
        
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }


}
