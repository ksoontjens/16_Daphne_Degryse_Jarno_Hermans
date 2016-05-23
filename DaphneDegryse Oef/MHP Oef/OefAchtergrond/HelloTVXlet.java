package hellotvxlet;


import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;



public class HelloTVXlet implements Xlet,ResourceClient, HBackgroundImageListener, UserEventListener{

    HBackgroundDevice hBackgrDev;
    HBackgroundImage pizza1;
    HBackgroundImage pizza2;
    HBackgroundImage pizza3;
    HBackgroundImage pizza4;
    HStillImageBackgroundConfiguration hsibc;
    
    int imageteller = 0;
    int cursor = 4;
    HStaticText orderlist;
    String orderstring = "OrderLijst : \n";
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext arg0) throws XletStateChangeException {
        HScreen hscreen = HScreen.getDefaultHScreen();
        hBackgrDev = hscreen.getDefaultHBackgroundDevice();
        
        hBackgrDev.reserveDevice(this); // bovenaan implements ResourceClients
                                        // toevoegen import + imlpement all
        
        HBackgroundConfigTemplate Template = new HBackgroundConfigTemplate();
        Template.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hBackgrDev.getBestConfiguration(Template);
        hsibc = (HStillImageBackgroundConfiguration)hBackgrDev.getBestConfiguration(Template);
        try {

        if  (hBackgrDev.setBackgroundConfiguration(hsibc)) System.out.println("Background gereserveerd en klaar");
        
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (HPermissionDeniedException ex) {
            ex.printStackTrace();
        } catch (HConfigurationException ex) {
            ex.printStackTrace();
        }
        
        pizza1 = new HBackgroundImage("pizza1.m2v");
        pizza2 = new HBackgroundImage("pizza2.m2v");
        pizza3 = new HBackgroundImage("pizza3.m2v");
        pizza4 = new HBackgroundImage("pizza4.m2v");
        
        pizza1.load(this);
        pizza2.load(this);
        pizza3.load(this);
        pizza4.load(this);
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        
        EventManager e = EventManager.getInstance();
        e.addUserEventListener(this, rep);
        HScene scene= HSceneFactory.getInstance().getDefaultHScene();
        
        orderlist = new HStaticText(orderstring,300, 50, 300, 400);
        orderlist.setVerticalAlignment(HStaticText.VALIGN_TOP);
        scene.add(orderlist);
        scene.validate();
        scene.setVisible(true);
    }
   
        public void startXlet() throws XletStateChangeException {
        
    }

    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException {
        
    }

    public boolean requestRelease(ResourceProxy arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent arg0) {
        
        imageteller++;
        
        if(imageteller == 4) 
        {
         System.out.println("alles is geladen");
          
        try{
        hsibc.displayImage(pizza1);
        }
        catch(Exception ex){
         ex.printStackTrace();
        }
        }

        

    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent  e) {
        
        if(e.getType() == KeyEvent.KEY_PRESSED){
        
            if(e.getCode() == HRcEvent.VK_LEFT)
            {
             cursor--;
             
             if( cursor < 1)
             {
              cursor = 4;
             }     
           }
            
           if(e.getCode() == HRcEvent.VK_RIGHT)
            {
             cursor++;
             
             if( cursor > 4)
             {
              cursor = 1;
             }       
           }
            
          if(e.getCode() == HRcEvent.VK_ENTER)
          {
            if( cursor == 1)
            {
             orderstring = orderstring + " Meat Lovers\n";
            }
             
            if( cursor == 2)
            {
             orderstring = orderstring + " Pepperonie Lovers\n";
            }
             
            if( cursor == 3)
            {
             orderstring = orderstring + " Cheese Lovers\n";
            }
             
            if( cursor == 4)
            {
             orderstring = orderstring + " Vegi Lovers\n";
            }
             
          }
            orderlist.setTextContent(orderstring, HStaticText.NORMAL_STATE);
        
        
        try{
            if( cursor == 1)
            {
             hsibc.displayImage(pizza1);
            }
             
            if( cursor == 2)
            {
             hsibc.displayImage(pizza2);
            }
             
            if( cursor == 3)
            {
             hsibc.displayImage(pizza3);
            }
             
            if( cursor == 4)
            {
             hsibc.displayImage(pizza4);
            }
        }
        
        catch(Exception ex){
         ex.printStackTrace();
        }
        
        }
            
    }
    
    }

    
    


   
    

