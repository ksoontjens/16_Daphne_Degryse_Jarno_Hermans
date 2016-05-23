import java.lang.*;
import java.util.Arrays;

public class TweedeOef
	{
		public static void main( String args[] )
		{
			int a[] = {12,34,56,78,123,234,99,88};
			Arrays.sort(a);
			for(int number : a)
			{
				System.out.println(number);
			}			
		}
	}