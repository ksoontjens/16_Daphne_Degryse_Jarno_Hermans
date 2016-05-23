import java.lang.*;
import java.util.Arrays;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			int a[] = {12,34,56,78,123,234,99,88};
			int highestNumber = 0;
			for(int i = 0; i< a.length; i++)
			{
				if(a[i] > highestNumber)
				{
					highestNumber = a[i];		
				}	
			}
			System.out.println(highestNumber);
		}
	}