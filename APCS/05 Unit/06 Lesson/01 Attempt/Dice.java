import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Dice
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		
		double die1, die2;
		
		System.out.println("Number of rolls: ");
		double maxRolls = in.nextDouble();
		System.out.println("Number of sides: ");
		double sides = in.nextDouble();
		int indices = (int)sides;
		
		double[] results = new double[indices * indices];
		Arrays.fill(results, 0.0);
		
		
		for(int i=1; i <= maxRolls; i++)
		{
			die1 = rng.nextDouble()*sides;
			die2 = rng.nextDouble()*sides;
			double sum = (die1 + die2) - (die1 + die2)%1;
			//System.out.println(die1 + " " + die2 + " " + sum);
			
			for(int j=1; j < indices * indices; j++)
			{
				if(sum == (double)j);
				{
					results[j] = results[j] + 1;
					System.out.println(results[j]);
					break;
				}
			}
		}
		System.out.println("Sum of Dice\tProbability(%)");
		
		for(int k=1; k <= results.length; k++)
		{
			System.out.println(k + "\t\t" + results[k-1]);
		}
	}
}
