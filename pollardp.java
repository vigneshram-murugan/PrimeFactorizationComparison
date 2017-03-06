
package ada.project;


import java.math.*;
import java.util.*;
public class pollardp {
  
   static final BigInteger ZERO=new BigInteger("0");
   static final BigInteger ONE=new BigInteger("1");

   public static BigInteger lnr(BigInteger b, BigInteger m) {
      if (m.compareTo(ZERO)<=0) throw new IllegalArgumentException("Modulus must be positive.");
      BigInteger answer=b.mod(m);
      return (answer.compareTo(ZERO)<0)?answer.add(m):answer;
   }

   
   public static BigInteger pMinusOneFactor(BigInteger n) throws IllegalArgumentException {
      Random rand=new Random();
      BigInteger power=BigInteger.valueOf(1);
      BigInteger residue=lnr(BigInteger.valueOf(rand.nextInt()),n);
      BigInteger test=residue.subtract(ONE);
      BigInteger gcd=test.gcd(n);
      while (true) {
         while (gcd.equals(ONE)) {
            power=power.add(ONE);
            residue=residue.modPow(power,n);
            test=residue.subtract(ONE);
            gcd=test.gcd(n);
         }
         if (gcd.equals(n)) {
            power=BigInteger.valueOf(1);
            residue=lnr(BigInteger.valueOf(rand.nextInt()),n);
            test=residue.subtract(ONE);
            gcd=test.gcd(n);
         } 
         
         
         
         if(isPrime(gcd.longValue())==true)
        System.out.println(gcd);
         else
             pMinusOneFactor(gcd);
         
         
         if(isPrime(n.divide(gcd).longValue())==true)
        System.out.println(n.divide(gcd));
         else
             pMinusOneFactor(n.divide(gcd));
         
         
         
         
         return null;

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
      
      
      
      
      
   


   public static void main(String[] args) {
   
   BigInteger m;
   Scanner Sc=new Scanner(System.in);
   System.out.println("enter a number:");
   BigInteger i=Sc.nextBigInteger();
 long start = System.currentTimeMillis();
   
   System.out.println("the prime factors are:");
   if(isPrime(i.longValue())==true){
   System.out.println(i);
   }
     else      
   pMinusOneFactor(i);
   
   long time = System.currentTimeMillis() - start;
  System.out.println("the Execution time in milliseconds:"+ time);
   }

   
  
  
   
   
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

