import java.lang.*;

public class PartTimeWerknemer extends Werknemer
{
  
    public int urenGewerkt;
    
    public PartTimeWerknemer (String voornaam, String achternaam, int nr, float sal, int uren){
        super(voornaam, achternaam, nr, sal);
        this.urenGewerkt = uren;
    }
    
    public float getWeekLoon()
    {
      return this.salaris * (float)this.urenGewerkt;
    }
    
            
   public void salarisVerhogen(int perc)
    {
            if(perc> 5)
            {
                perc = 0;
                System.out.println(" Fout! Slechts 5 procent opslag is toegestaan");
            }
        salaris+=salaris*(perc/100.0);
            
    }

}