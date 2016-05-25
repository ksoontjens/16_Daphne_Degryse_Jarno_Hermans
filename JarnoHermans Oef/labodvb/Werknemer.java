import java.lang.*;
import java.util.Arrays;

public class Werknemer implements Betaalbaar
	{
    
        public String mVoornaam;
        public String mAchternaam;
        public int mWerknemerNummer;
        protected float mSalaris;
        private float rszPercentage = 33.0f;
    
        public Werknemer(String initVoornaam, String initAchternaam, int initWerknemerNummer, float initSalaris)
        {
            mVoornaam = initVoornaam;
            mAchternaam = initAchternaam;
            mWerknemerNummer = initWerknemerNummer;
            mSalaris = initSalaris;
        }
    
        public float verhoogSalaris(float perc)
        {
            return mSalaris += (mSalaris*perc);
        }
    
        public float getSalaris()
        {
            return mSalaris;
        }
    
        public void setRSZ(float rsz)
        {
            if(rsz > 100)
            {
                System.out.println("Error, RSZ mag niet hoger zijn dan 100");
            }
            else
            {
                rszPercentage = rsz;
            }  
        }
    
        public float getRSZ()
        {
            return rszPercentage;
        }
    
        public void betaal()
        {
            System.out.println("Betaal" + mSalaris + " aan " + mVoornaam);
        }
	}
