import java.util.Scanner;

class Tester
{
	public static void main(String[] args)
	{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an upper bound integer x. All primes 2:x will be found.");
        
        while(in.hasNextInt())
        {
            Sieve.calculate(in.nextInt());
        }
	}
}
