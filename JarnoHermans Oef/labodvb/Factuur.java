public class Factuur extends Betaalbaar
	{
        int factuurNr;
        int factuurBedrag;
        
        public Factuur( int initFactuurNr , int initFactuurBedrag)
        {
            factuurNr = initFactuurNr;
            factuurBedrag = initFactuurBedrag;
        }
    
        public void betaal()
        {
            System.out.println("Betaal het faktuur " + factuurNr + " voor een bedrag van " + factuurBedrag);
        }
	}
