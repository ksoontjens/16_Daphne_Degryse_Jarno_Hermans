import java.lang.*;

public class Oefeningen1_27
{   
   public static void main (String args [])
    {

       //Oef1
       Werknemer werknemer1;
       Werknemer werknemer2;
       Werknemer werknemer3;
       Werknemer werknemer4;
       werknemer1 = new Werknemer("Jan", "Jansen", 1, 35.0f);
       werknemer2 = new Werknemer("Daphne", "Degryse", 2, 75.0f);
       werknemer3 = new Werknemer("Jacob", "Jansen", 3, 25.0f);
       werknemer4 = new Werknemer("Mark", "Martin", 4, 45.0f);
       
    //Oef2
       /*
       werknemer1.salarisVerhogen(10);
       werknemer2.salarisVerhogen(10);
       
       System.out.println(werknemer1.voornaam + " "+ werknemer1.achternaam + " " + werknemer1.salaris  );
       System.out.println(werknemer2.voornaam + " "+ werknemer2.achternaam + " " + werknemer2.salaris  );  
       System.out.println(werknemer3.voornaam + " "+ werknemer3.achternaam + " " + werknemer3.salaris  );
       System.out.println(werknemer4.voornaam + " "+ werknemer4.achternaam + " " + werknemer4.salaris  );  
    */
       
           //Oef3
    PartTimeWerknemer party1;
    PartTimeWerknemer party2;
    party1 = new PartTimeWerknemer("Marie", "Jansen", 5, 5.0f, 15);
    party2 = new PartTimeWerknemer("Maarten", "Degryse", 6, 15.0f, 13);
    

    //Oef4
    /*
       party1.salarisVerhogen(10);
       party2.salarisVerhogen(10);
       
    System.out.println(party1.voornaam + " "+ party1.achternaam + " " + party1.salaris  );
    System.out.println(party2.voornaam + " "+ party2.achternaam + " " + party2.salaris  ); 
    */
   
    //Oef5-6
    Werknemer werknemer5;
    werknemer5 = new Werknemer("Stef", "John", 7, 35.0f);
    PartTimeWerknemer party3;
    party3 = new PartTimeWerknemer("Marty", "Jan", 8, 5.0f, 15);
       
      /* 
           System.out.println(party3.voornaam + " "+ party3.achternaam + " " + party3.salaris + " "+party3.getRSZ()   );
       System.out.println(werknemer5.voornaam + " "+ werknemer5.achternaam + " " + werknemer5.salaris+ " "+werknemer5.getRSZ()   );  
    */
       
       //Oef7
       StudentWerknemer student1;
       student1 = new StudentWerknemer("Marta", "Smit", 9, 10.0f, 15);
       
       /*
       System.out.println(student1.voornaam + " "+ student1.achternaam + " " + student1.salaris+ " "+student1.getRSZ()   ); 
       */
       
       //Oef8-9_10
       
       Faktuur fac1;
       fac1 = new Faktuur(4, 125);
       
       Betaalbaar Betdingen[] = new Betaalbaar[4];
       Betdingen[0] = werknemer1;
       Betdingen[1] = student1;
       Betdingen[2] = party1;
       Betdingen[3] = fac1;
       
       for(int k = 0; k < 4; k++){
       Betdingen[k].betaal();
       }
    }
 
    
}