import java.lang.*;

public class TweedeProg
	{
		/**
		* @param args Dit is een commandline argument
		*/
		public static void main( String args[] )
		{
			drukaf(100);
		}
		
		/**
		* @param m Dit is het aantal nummers dat commandline afprint
		*/
		public static void drukaf(int m)
		{
			int i;
			for(i=1; i <= m; i++)
			{
				System.out.println(i);
			}
		}
	}