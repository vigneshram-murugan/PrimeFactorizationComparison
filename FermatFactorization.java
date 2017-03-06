
package ada.project;

 
    import java.util.Scanner;

     

    public class FermatFactorization

    {


        public void FermatFactor(long N)

        {

            long a = (long) Math.ceil(Math.sqrt(N));

            long b2 = a * a - N;

            while (!isSquare(b2))

            {

                a++;

                b2 = a * a - N;

            }

            long r1 = a - (long)Math.sqrt(b2);

            long r2 = N / r1;

       
            
             if(isPrime(r1)==true)
        System.out.println(r1);
         else
             FermatFactor(r1);
         
         
         if(isPrime(r2)==true)
        System.out.println(r2);
         else
            FermatFactor(r2);
         
            
            
            

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

        
        public boolean isSquare(long N)

        {

            long sqr = (long) Math.sqrt(N);

            if (sqr * sqr == N || (sqr + 1) * (sqr + 1) == N)

                return true;

            return false;

        }

    
        public static void main(String[] args) 

        {

            Scanner scan = new Scanner(System.in);

           

            System.out.println("Enter odd number");

            long N = scan.nextLong();
 long start = System.currentTimeMillis();
  
  
            FermatFactorization ff = new FermatFactorization();

            ff.FermatFactor(N);
long time = System.currentTimeMillis() - start;
  System.out.println("the Execution time in milliseconds:"+ time);
        }

    }