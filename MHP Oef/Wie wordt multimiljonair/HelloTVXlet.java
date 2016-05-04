package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton button1 = new HTextButton("Dean Deblois",100,230,200,50);
    HTextButton button2 = new HTextButton("Henry Selick",100,320,200,50);
    HTextButton button3 = new HTextButton("Tim Burton",400,230,200,50);
    HTextButton button4 = new HTextButton("Jack Black",400,320,200,50);
    HStaticText label4 = new HStaticText("Sorry, u hebt verloren",60,400,600,50);
    HStaticText label5 = new HStaticText("Correct! U hebt gewonnen",60,400,600,50);
    HTextButton button5 = new HTextButton("Hulplijn",400,490,200,50);
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      
     System.out.println("initXlet");
     scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
    System.out.println("startXlet");
    HStaticText label1 = new HStaticText("Hallo, wordt jij multimiljonair vandaag?",60,50,600,50);
    HStaticText label2 = new HStaticText("Beantwoord dan de volgende vraag:",60,100,600,50);
    HStaticText label3 = new HStaticText("Wie was de regisseur van 'The Nightmare Before Christmas'?",60,150,600,50);
    
                                              //x, y, breette; hoogte
    
    label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label1.setBackground(Color.BLUE);
    label2.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label2.setBackground(Color.BLUE);
    label3.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label3.setBackground(Color.BLUE);
    label4.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label4.setBackground(Color.RED);
    label5.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label5.setBackground(Color.GREEN);
    
    
   
    button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button1.setBackground(new DVBColor(0,0,0,127));// RGBa
    
    button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button2.setBackground(new DVBColor(0,0,0,127));// R,G,B,a
    
    button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button3.setBackground(new DVBColor(0,0,0,127));// R,G,B,a
    
    button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button4.setBackground(new DVBColor(0,0,0,127));// R,G,B,a
    
    button5.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button5.setBackground(new DVBColor(255,154,0,127));
    
    scene.add(label1);
    scene.add(label2);
    scene.add(label3);
    scene.add(label4);
    scene.add(label5);
    scene.add(button1);
    scene.add(button2);
    scene.add(button3);
    scene.add(button4);
    scene.add(button5);
    
    button1.setFocusTraversal(null, button2, null, button3);
    button2.setFocusTraversal(button1, null, null, button4);
    button3.setFocusTraversal(null, button4, button1, null);
    button4.setFocusTraversal(button3, button5, button2, null);
    button5.setFocusTraversal(button4, null, null, null);
    
                              // up , down, left, right
    button1.setActionCommand("fout");
    button1.addHActionListener(this);// bovenaan toevoegen bij implements
                                     // public class HelloTVXlet implements Xlet, HActionListener 
    
    button2.setActionCommand("juist");
    button2.addHActionListener(this);
    
    button3.setActionCommand("fout");
    button3.addHActionListener(this);
    
    button4.setActionCommand("fout");
    button4.addHActionListener(this);
    
    button5.setActionCommand("hulp");
    button5.addHActionListener(this);
    
    scene.validate();
    scene.setVisible(true);
    label4.setVisible(false);
    label5.setVisible(false);
    button1.requestFocus();
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    //als iemand op de knop drukt, variabele moetn wel globaal zijn
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        

        //kleur veranderen
        if(event.getActionCommand().equals("fout")){
         
            button1.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         button2.setBackground(new DVBColor(0,255,68,127));// R,G,B,a
         button3.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         button4.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         
         button1.removeHActionListener(this);
         button2.removeHActionListener(this);
         button3.removeHActionListener(this);
         button4.removeHActionListener(this);
         
         label4.setVisible(true);
         scene.popToFront(label4);
         scene.repaint();
        }
         if(event.getActionCommand().equals("juist")){ 
             
         button1.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         button2.setBackground(new DVBColor(0,255,68,127));// R,G,B,a
         button3.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         button4.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         
         button1.removeHActionListener(this);
         button2.removeHActionListener(this);
         button3.removeHActionListener(this);
         button4.removeHActionListener(this);
         
         label5.setVisible(true);
         scene.popToFront(label5);
         scene.repaint();
        }
        
         
        if(event.getActionCommand().equals("hulp")){ 
             
         button1.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         button4.setBackground(new DVBColor(255,0,0,127));// R,G,B,a
         
         button1.removeHActionListener(this);
         button4.removeHActionListener(this);
         button5.removeHActionListener(this);
         
         scene.repaint();
        }
        
    }
}
