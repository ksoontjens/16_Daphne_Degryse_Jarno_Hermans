import java.lang.*;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			/*
			Betaalbaar BetDingen[] = new Betaalbaar[2];
			BetDingen[0] = A;
			BetDingen[1] = new Factuur();
			for(int k = 0; k < 2 ; k++)
			{
				BetDingen[k].betaal();
			}
			*/

			Factuur fact = new Factuur(1, 2000.0f);
			fact.betaal();
		}
	}