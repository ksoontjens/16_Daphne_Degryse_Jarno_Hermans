import java.lang.*;

public class Oefeningen1_17
{
    
public static void main (String args [])

{
    /* 
  //Oef1
   
   for(int x=0; x<=9; x++)
    {
     for(int y=0;y<=9;y++)
      {
        System.out.println(x + " X " + y + " = " + x*y);
    }
    }
    


  //Oef2
  int weekdag=0;
    for(int dag = 0; dag<=29;dag++)
    {
        if(weekdag == 0) System.out.println("Zondag "+ dag + " februarie 2009" );
        if(weekdag == 1) System.out.println("Maandag "+ dag + " februarie 2009" );
        if(weekdag == 2) System.out.println("Dinsdag " + dag + " februarie 2009" );
        if(weekdag == 3) System.out.println("Woensdag "+ dag + " februarie 2009" );
        if(weekdag == 4) System.out.println("Donderdag "+ dag + " februarie 2009" );
        if(weekdag == 5) System.out.println("Vrijdag " + dag + " februarie 2009" );
        if(weekdag == 6) System.out.println("Zaterdag "+ dag + " februarie 2009" );
        weekdag++;
        if(weekdag>6) weekdag = 0;
        
    }
    
    
  //0ef3
   float pi= 0;
    int neg = 1;
    for(int i=1 ; i <=10000; i+= 2)
    {
        
        pi+= neg * (1.0f/i);
        neg *= -1;

    }
        
    
    pi *=4;
                
      System.out.println("PI = " + pi);
        
       
    
    //Oef4
    int nr = 4302;
    nr = ~ nr + 1;
         System.out.println(nr);
    
    
    //Oef5
    
    int nr = 100;
    boolean primNr = true;
    for (int i = 3; i <= 100; i++)
    {
        primNr=true;
        for(int j = 2; j < i; j++)
        {
          if(i%j ==0){
          primNr= false;
   //s           System.out.println(j +" is een deler van "+i);
          }
            
        }
    if(primNr){
     System.out.println(i  + " is een priemgetal");
    }
    
    } 

    //Oef6
    
    int a[]={12,34,56,78,123,234,99,88};
    int max = 0;
    for(int i = 0; i < a.length; i++){
      if(a[i] > max){
        max = a[i];
      }
    }
    
    System.out.println("Het grootste element is gelijk aan " + max);
    */
    
    //Oef7
    int a[]={12,34,56,78,123,234,99,88};
    int b[]=new int [a.length];

    
    for(int j=0;j <b.length;j++){
    int plaats = 0;
    int max = 0;
        for(int i = 0; i < a.length; i++)
        {
         if(a[i] > max){
          max = a[i];
          plaats = i;
        } 
        
        }
        
        b[j] = max;
        a[plaats] = 0;
    }

    for(int y = 0; y < b.length; y++){
      System.out.println(b[y]);
    }
    
}
}
