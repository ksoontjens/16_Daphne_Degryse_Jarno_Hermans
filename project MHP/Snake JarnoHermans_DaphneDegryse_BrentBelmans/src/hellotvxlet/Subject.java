/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;

public class Subject extends TimerTask implements SubjectInterface {

    ArrayList oblijst=new ArrayList();
    int tijd=0;
    int speed = 16;
    
    public void run() {
        tijd++;
  //      System.out.println("observers.size="+oblijst.size());
        for (int i=0;i<oblijst.size();i++)
        {
        ((ObserverInterface)oblijst.get(i)).update(tijd);
        }
        
        //doCollisionDetectionPlayer();
          if (tijd%speed==0)
           {
              // System.out.println("segment");
                for (int i=0;i<oblijst.size();i++) // loop alle Sprites af
           {
               Object sprite=oblijst.get(i);
               if (sprite.getClass()==Segment.class) // dit is speler
               {
                   ((Segment)sprite).groei(GameXlet.getScene());
               }
           }
           }
    }
    /*
    public void doCollisionDetectionPlayer()
    {
           for (int i=0;i<oblijst.size();i++) // loop alle Sprites af
           {
               Object sprite=oblijst.get(i);
               if (sprite.getClass()==Segment.class) // dit is speler
               {
                   for (int j=0;j<oblijst.size();j++)
                   {
                       Object sprite2=oblijst.get(j);
                       if (oblijst.get(j).getClass()==EnemyRocket.class)
                       {
                   Rectangle r2=((EnemyRocket)sprite2).getBounds();
                   Rectangle r1=((Segment)sprite).getBounds();
                   if (r2.intersects(r1))
                   { HelloTVXlet.getScene().add(new HStaticText("GAME OVER",300,300,300,200));
                   }
                       
                       }
                   }
                   
               }
           }
    }    */
         
        
    
    public void register(ObserverInterface ob) {
        oblijst.add(ob);
    }

    public void unregister(ObserverInterface ob) {
        oblijst.remove(ob);
    }

}
