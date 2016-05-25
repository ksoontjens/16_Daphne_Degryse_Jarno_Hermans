package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet{

    HScene scene;
    
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene= HSceneFactory.getInstance().getDefaultHScene();
        MijnComponent mc = new MijnComponent(300,200,250,250);
        scene.add(mc);
        MijnComponent mc2= new MijnComponent(0,0,250,250);
        scene.add(mc2);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }

}
