import java.lang.*;
import java.util.Arrays;

public class TweedeOef
	{
		public static void main( String args[] )
		{	
			int maxNumber = 100;
			boolean[] primes=new boolean[maxNumber]; 
			
			//set up the primesieve

    			Arrays.fill(primes,true);        // assume all integers are prime.
    			primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
    			for (int i=2;i<maxNumber;i++) 
			{
        			//if the number is prime, 
       				//then go through all its multiples and make their values false.
        			if(primes[i]) 
				{
            				for (int j=2;i*j<primes.length;j++) 
					{
                				primes[i*j]=false;
           				}
				System.out.println(i);
       				}
    			}
		}
	}