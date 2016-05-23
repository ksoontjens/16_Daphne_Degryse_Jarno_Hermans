public class Factuur implements Betaalbaar {

	public int factuurNr;
	public float factuurBedrag;

	public Factuur(int factuurNr, float factuurBedrag)
	{
		this.factuurNr = factuurNr;
		this.factuurBedrag = factuurBedrag;
	}

	public void betaal()
	{
		System.out.println("Betaal het factuur " + factuurNr + " voor een bedrag van " + factuurBedrag);
	}
}