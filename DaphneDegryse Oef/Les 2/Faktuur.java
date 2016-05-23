import java.lang.*;

public class Faktuur implements Betaalbaar
{
    public int factuurNr;
    public float factuurbedrag;
    
    
    public Faktuur(int Nr,float bedrag){
    factuurNr = Nr;
        factuurbedrag= bedrag;
    }
    
    public void betaal(){
    
     System.out.println("Betaal deze factuur " + factuurNr + " van " + factuurbedrag);
    }

}