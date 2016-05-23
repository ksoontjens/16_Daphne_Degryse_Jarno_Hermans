package hellotvxlet;

import org.havi.ui.HStaticIcon;


public abstract class Sprite extends HStaticIcon implements ObserverInterface {

    public Sprite(int x, int y)
    {
        super();
        this.setLocation(x, y);
    }


    
}
