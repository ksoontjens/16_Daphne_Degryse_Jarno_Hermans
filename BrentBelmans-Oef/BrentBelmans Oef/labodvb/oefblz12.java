import java.lang.*;

public class TweedeOef {

	/** 
	* Deze methode is de main methode.
	* @param args is een commandline argument.
	*/
	public static void main(String args[])
	{
	drukaf(100);
	}

	/**
	* Deze methode print 0 tot en met 99 af. 
	* @param m is het aantal dat je wil laten zien.
	*/
	public static void drukaf(int m)
	{
		int a;
		for (a = 0; a<m; a++)
		{
			System.out.println(a);
		}
	}
}