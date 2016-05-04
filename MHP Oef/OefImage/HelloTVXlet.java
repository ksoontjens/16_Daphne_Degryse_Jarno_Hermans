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


public class HelloTVXlet implements Xlet,UserEventListener{

    HScene scene;
    MijnComponent mc;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }
    

    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent(0,0,720,576);
        scene.add(mc);

        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        UserEventRepository rep = new UserEventRepository ("naam");
        rep.addAllArrowKeys(); // alle pijltjes
        EventManager m = EventManager.getInstance();
        m.addUserEventListener(this, rep);
        MijnTimerTask objTimer = new MijnTimerTask(this);
        Timer t = new Timer();
        t.scheduleAtFixedRate(objTimer ,0,500);//start op 0ms; elke 500ms;
    }
    
    public void callback(){
    mc.scroll();
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.toString());
        
        if (e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_LEFT)
        {
          mc.moveLeft();
        }
        
        if (e.getType() == KeyEvent.KEY_PRESSED && e.getCode() == HRcEvent.VK_RIGHT)
        {
          mc.moveRight();
        }
        

    }

}
