import java.lang.*;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			Werknemer A = new Werknemer("A","a", 1, 100.0f);
			PartTimeWerknemer B = new PartTimeWerknemer("B","b", 2, 200.0f, 20);

			A.setRSZ(50.0f);
			B.setRSZ(50.0f);

			System.out.println("De RSZ van A = " + A.getRSZ());
			System.out.println("De RSZ van B = " + B.getRSZ());
		}
	}