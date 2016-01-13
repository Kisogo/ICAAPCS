import java.util.Scanner;
import java.util.Random;

class Dice
{
	public static void main(String[] args)
	{
		// Construct our random number generator and scanner objects.
		Random rng = new Random();
		Scanner in = new Scanner(System.in);		
	
		// Get total number of rolls and sides of die from user
		System.out.println("Number of rolls: ");
		double totalRolls = in.nextDouble();
		System.out.println("Number of die sides: ");
		int sides = in.nextInt();
	
		/* Construct our results array. 
			Make sure it has enough indices for each possible roll result. */
		int[] results = new int[(sides * 2) + 1];
		
		// Initialize die1 and die2 to represent the two dice.
		double die1, die2;
	
		/* for each possible sum, roll the dice totalRolls times, and calculate the chance of the sum
			being equal to the sum we're looking for. */
		for(int i=1; i <= sides*2; i++)
		{
		
			for(int j=1; j <= totalRolls; j++)
			{
				/* 'Roll' the dice. nextDouble only generates a double between 0.0 and 1.0,
					so we multiply it by the number of sides minus 1 and add 1 to the result to get a number 
					between 1 and whatever sides equals. */
				die1 = (rng.nextDouble()*sides-1)+1;
				die2 = (rng.nextDouble()*sides-1)+1;
				double sum  = (die1 + die2) - (die1 + die2) % 1;
				
				/* If the dice add up to the sum we're looking for, increment the integer at the corresponding
					index. */
				if(sum == (double)i)
				{
					results[i+1] = results[i+1] + 1;
				}
			}
		}
	
		// We're done! Print the results in a human-readable format.
		System.out.println("Sum of Dice\t|\tProbability (%)");
		for(int k=1; k <= sides*2; k++)
		{
			System.out.println(k + "\t\t|\t" + (results[k] / totalRolls)*100);
		}
	}
}
