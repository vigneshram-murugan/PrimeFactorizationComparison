
package ada.project;

 import java.util.Scanner;

public class PollardRho {

        private static final long C = 1; 

       
        private long f(long X)    

        {

            return X * X + C;

        }


        private long rho(long N) 

        {

            long x1 = 2, x2 = 2, divisor;        

            if (N % 2 == 0) 

                return 2;

            do 

            {

                x1 = f(x1) % N;

                x2 = f(f(x2)) % N;

                divisor = gcd(Math.abs(x1 - x2), N);

            } while (divisor == 1);

            /** return divisor **/

            return divisor;

        }

   

        public  long gcd(long p, long q)

        {

            if (p % q == 0)

                return q;

            return gcd(q, p % q);

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
   

        public void factor(long N) 

        {

            if (N == 1)

                return;

            if (isPrime(N)==true) 

            {

                System.out.println(N); 

                return; 

            }

               long divisor = rho(N);

            factor(divisor);

            factor(N / divisor);

        }


        public static void main(String[] args)

        {

            Scanner scan = new Scanner(System.in);

                  

            System.out.println("Enter a number:");

            long N = scan.nextLong();
            long start = System.currentTimeMillis();
    
           
            
            
            System.out.println("\nFactors are : ");

            PollardRho pr = new PollardRho();

            pr.factor (N);   
            long time = System.currentTimeMillis() - start;
            System.out.println("the Execution time in milliseconds:"+ time);

        }

    }