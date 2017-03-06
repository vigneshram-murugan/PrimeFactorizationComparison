
package ada.project;

import java.math.*;
import java.util.Scanner;
public class trialdivision {
    public static long counter=0;
    
    public static void main(String args[])
    {
    Scanner Sc=new Scanner(System.in);
   System.out.println("enter a number:");
   long i=Sc.nextLong();
     System.out.println("the factor are :");
    long start = System.currentTimeMillis();
     trialdivide(i);
  long time = System.currentTimeMillis() - start;
  System.out.println("the Execution time in milliseconds:"+ time);

  
  
    }
    
    
    
    
   public static void trialdivide(long  n){
      counter=0;
       for (long s=2L; s<=Math.floor(Math.sqrt(n));s++ )
       {
          
           if(n%s==0)
           {counter=s;
                   
                 
   long k=n/counter;
   long x=counter;
 
   
  
         
         
         if(isPrime(k)==true)
        System.out.println(k);
         else
            trialdivide(k);
         
     if(isPrime(x)==true)
        System.out.println(x);
         else
            trialdivide(x);
   
            
           break;
           }
   
   
   
   } 
    
    
}
   
   
   
   
      
   public static boolean isPrime(long n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
}
      
      
      
      
}