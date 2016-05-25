import java.lang.*;
import java.util.Arrays;

public class PartTimeWerknemer extends Werknemer
	{
    
        int aantalUrenGewerkt;
    
        public PartTimeWerknemer(String initVoornaam, String initAchternaam, int initWerknemerNummer, float initSalaris, int initAantalUrenGewerkt)
        {
            super(initVoornaam, initAchternaam,  initWerknemerNummer, initSalaris);
            aantalUrenGewerkt = initAantalUrenGewerkt;
        }
    
        public float getWeekLoon()
        {
            return aantalUrenGewerkt * getSalaris();
        }
    
        public void verhoogSalaris(float perc)
        {
            if(perc>0.05f)
            {
                System.out.println("PartTimeWerknemers kunnen maar 5% opslag krijgen.");
            }else{
                super.verhoogSalaris(0.05f);
            }
        }
	}
