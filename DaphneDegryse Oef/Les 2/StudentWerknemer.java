import java.lang.*;

public class StudentWerknemer extends PartTimeWerknemer
{
    
    
    public StudentWerknemer (String voornaam, String achternaam, int nr, float sal, int uren){
        super(voornaam, achternaam, nr, sal, uren);
        this.setRSZ(5);
    }
}