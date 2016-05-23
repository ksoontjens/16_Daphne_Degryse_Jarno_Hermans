import java.lang.*;

public class Werknemer implements Betaalbaar
{

    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZpercentage = 33;
    
    //construtors
    public Werknemer(String voornaam, String achternaam, int WNummer, float salaris)
    {
      this.voornaam = voornaam;
      this.achternaam = achternaam;
      werknemerNummer = WNummer;
      this.salaris = salaris;
      RSZpercentage = 33;
    }
    
        public Werknemer(String voornaam, String achternaam, int WNummer, float salaris, float rsz)
    {
      this.voornaam = voornaam;
      this.achternaam = achternaam;
      werknemerNummer = WNummer;
      this.salaris = salaris;
      RSZpercentage = rsz;
    }
    
    
    //methodes
    public void salarisVerhogen(int perc)
    {
        salaris+=salaris*(perc/100.0);
    }
    

    
    public float getSalaris()
    {
        return salaris;
    }
    
    
    public void setRSZ(float rsz)
    {
        if(rsz >100){
        System.out.println(" Fout!");
        }
        RSZpercentage = rsz;
            
    }
    
    public float getRSZ()
    {
        return RSZpercentage;
    }
    
    public void betaal(){
    
     System.out.println("Betaal de salaris " + salaris + " aan " + voornaam);
        
    }
    
    



}