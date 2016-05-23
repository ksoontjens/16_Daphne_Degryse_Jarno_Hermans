import java.lang.*;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			/*
			Werknemer A = new Werknemer("A","a", 1, 100.0f);
			Werknemer B = new Werknemer("B","b", 2, 200.0f);
			Werknemer C = new Werknemer("C","c", 3, 300.0f);
			Werknemer D = new Werknemer("D","d", 4, 400.0f);

			A.salarisVerhogen(10);
			B.salarisVerhogen(10);

			System.out.println("Het salaris van A = " + A.getSalaris());
			System.out.println("Het salaris van B = " + B.getSalaris());
			System.out.println("Het salaris van C = " + C.getSalaris());
			System.out.println("Het salaris van D = " + D.getSalaris());
			*/
			
			PartTimeWerknemer A = new PartTimeWerknemer("A","a", 1, 100.0f, 15);
			PartTimeWerknemer B = new PartTimeWerknemer("B","b", 2, 200.0f, 20);

			A.salarisVerhogen(10);
			B.salarisVerhogen(10);

			System.out.println("Het salaris van A = " + A.getSalaris());
			System.out.println("Het salaris van B = " + B.getSalaris());
		}
	}