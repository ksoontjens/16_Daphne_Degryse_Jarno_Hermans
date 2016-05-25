import java.lang.*;

public class oefblz19oef3
	{
		public static void main( String args[] )
		{	
			boolean b = true;
			double pi = 4;
			double i = 3;
			double teller = 1;
			double kommagetal = 1;
			while(i<20000)
			{
				if(b)
				{
					kommagetal -=(teller/i);
					b = false;
				}
				else
				{
					kommagetal +=(teller/i);
					b = true;
				}	
				i+= 2;
			}
			pi *= kommagetal;
			System.out.println(pi);
		}
	}
