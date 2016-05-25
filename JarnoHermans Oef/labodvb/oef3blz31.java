import java.lang.*;
import java.util.Arrays;

public class oef3blz31
	{
		public static void main( String args[] )
		{
            Werknemer jan = new Werknemer("Jan", "Janssens", 1, 35.0f);
            Werknemer silke = new Werknemer("Silke", "De Bruyne", 2, 36.0f);
            Werknemer bart = new Werknemer("Bart", "Cannearts", 3, 34.0f);
            Werknemer gert = new Werknemer("Gert", "Broossens", 4, 40.0f);
            PartTimeWerknemer elke = new PartTimeWerknemer("Elke", "Elkens", 5, 20.0f, 15);
           System.out.println(jan.verhoogSalaris(0.1f));System.out.println(silke.verhoogSalaris(0.1f));System.out.println(bart.verhoogSalaris(0.1f));System.out.println(gert.verhoogSalaris(0.1f));  
            System.out.println(elke.getWeekLoon());
		}
	}