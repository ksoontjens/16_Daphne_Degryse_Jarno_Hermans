/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{

    HelloTVXlet Xlet; // link naar
    
    public MijnTimerTask(HelloTVXlet x)
    {
        Xlet=x;
    }
    
    public void run(){
    System.out.println("Tick....");
    Xlet.callback();
    }
    

    

    
}
