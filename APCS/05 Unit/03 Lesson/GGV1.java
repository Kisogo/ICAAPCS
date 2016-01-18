import java.util.Scanner;
import java.util.Random;

class GGV1
{
	public static void main(String[] args)
	{
		int guess = 0;
		
		// Construct our RNG and scanner object.
		Random rng = new Random();
		Scanner in = new Scanner(System.in);
		
		// Get the target number for this session from the RNG object.
		int targetnumber = rng.nextInt(99)+1;
		System.out.println("[debug] The target number is " + targetnumber);
		
		while(guess != targetnumber)
			{
				System.out.print("Enter your guess: ");
				guess = in.nextInt();
				
				if(guess == targetnumber) // Win condition
				{
					System.out.println("Congratulations\nThe random number was: " + targetnumber + ".");
					break;
				}
				else if(guess > targetnumber) // Guess is greater than the target number
				{
					System.out.println("Your guess is too high, try again.");
				}
				else // Guess is less than the target number
				{
					System.out.println("Your guess is too low, try again.");
				}
			}


	}
}
