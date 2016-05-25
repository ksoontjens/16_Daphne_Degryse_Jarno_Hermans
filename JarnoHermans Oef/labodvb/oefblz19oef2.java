import java.lang.*;

public class TweedeProg
	{
		public static void main( String args[] )
		{	
			String dagen[]={"maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};
			int day = 6;
			for (int i = 1; i <= 28; i++)
			{
				if(day == 7)
				{
					day = 0;
				}
			System.out.println(dagen[day] + " " + i + " februari");
			day++;
			}
		}
	}
