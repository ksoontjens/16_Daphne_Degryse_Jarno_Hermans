/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class ApplicationManagerFactory {

    static ApplicationManagerFactory ik;
    HelloTVXlet ap;
    
    public static ApplicationManagerFactory getInstance()
    {
        if (ik==null) ik=new ApplicationManagerFactory();
        return ik;
    }
    
    public HelloTVXlet getApplicationManager()
    {
        return ap;
    }
    
    public void setApplicationManager(HelloTVXlet ap)
    {
        this.ap=ap;
    }
    
}
