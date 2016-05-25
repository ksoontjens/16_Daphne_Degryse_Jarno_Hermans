package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener{

    HScene scene;
    MijnComponent mc = new MijnComponent(0,0,720,576);
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene= HSceneFactory.getInstance().getDefaultHScene();
        
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        //aaangeven alle knoppen willen ontvangen
        UserEventRepository repos = new UserEventRepository("naam");
        repos.addAllArrowKeys(); //alle pijltjes
        EventManager m = EventManager.getInstance();
        m.addUserEventListener(this, repos); // stuur events naar alle knoppen in repos
        //voeg interface userventlistnere (bovenaan)
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer t = new Timer();
        t.scheduleAtFixedRate(objMijnTimerTask, 0, 50); //start op 0ms, elke 500ms
        
    }

    
    public void callback(){
        mc.scroll();
    }

    
    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_LEFT)
        {
            mc.moveleft();
        }
        if(e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_RIGHT)
        {
            mc.moveright();
        }
        if(e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_UP)
        {
            mc.moveup();
        }
        if(e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_DOWN)
        {
            mc.movedown();
        }
    }

}
