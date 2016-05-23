import java.lang.*;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			Werknemer A = new Werknemer("A","a",1,100.0f);
			PartTimeWerknemer B = new PartTimeWerknemer("B","b",1,200.0f,20);
			StudentWerknemer C = new StudentWerknemer("C","c",1,300.0f,10);

			A.betaal();
			B.betaal();
			C.betaal();
		}
	}