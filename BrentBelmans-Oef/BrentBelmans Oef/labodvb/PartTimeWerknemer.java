import java.lang.*;

public class PartTimeWerknemer extends Werknemer
{
	int aantalUrenGewerkt;

	public PartTimeWerknemer(String vNaam, String aNaam, int wNum, float sal, int aantalUren)
	{
		super(vNaam, aNaam, wNum, sal);
		aantalUrenGewerkt = aantalUren;
	}

	public float getWeekLoon()
	{
		return aantalUrenGewerkt*salaris;
	}

	public void salarisVerhogen(int perc)
	{

		if (perc>5)
		{
			System.out.println("PartTimeWerknemers kunnen maar 5% opslag krijgen.");
		}
		else
		{
			super.salarisVerhogen(perc);
		}

	}
}