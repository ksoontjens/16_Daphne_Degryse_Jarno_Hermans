/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Slang {
    ArrayList ar=new ArrayList();
    static Slang instance=null; 
       
    public static Slang getInstance()
    {
        if (instance==null) instance=new Slang();
        return instance;
    }
    
    public void add(Segment s)
    {
        ar.add(s);
    }
    
    public void remove(Segment s){
        ar.remove(s);
    }
    
    public void removeAll(){
        ar.removeAll(ar);
    }
    
    public boolean checkCollisionWith(Segment k)
    {
        boolean col=false;
        for (int i=0;i<ar.size();i++)
        {
            if (k.getBounds().intersects(((Segment)ar.get(i)).getBounds())) col=true;
        }
        return col;
    }
    
    public boolean checkFreeSpace(Fruit f)
    {
        boolean freeSpace=true;
        for (int i=0;i<ar.size();i++)
        {
            if (f.getBounds().intersects(((Segment)ar.get(i)).getBounds())) freeSpace = false;
        }
        return freeSpace;
    }
}
