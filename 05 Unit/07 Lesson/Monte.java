import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

/*
Name: Ryan Stenmark
Date: 2015-12-22
Purpose: Implement a Monte Carlo algorithm.
*/

class Monte
{
	public static void main(String[] args) throws IOException
	{
		// Check the user's input.
		String usage = new String("Usage: java Monte [number of test rounds]");
		int rounds = 0;
	
		if(args.length > 0)
		{
			try
			{
				if(args.length >= 2)
				{
					System.err.println("Invalid number of arguments.");
					System.err.println(usage);
					System.exit(1);
				}
				rounds = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Input arguments must be integers.");
				System.err.println(usage);
				System.exit(1);
			}
		}
		else
		{
			System.err.println("Invalid number of arguments.");
			System.err.println(usage);
			System.exit(1);
		}
		
		PrintWriter fw = new PrintWriter(new File("output"));
		// Run the trials.
		
		Random rng = new Random();
		
		int rolls = 0;
		int dice = 0;
		int sum = 0;
		int[] results = new int[rounds];
		
		for(int i=0; i < rounds; i++)
		{
			fw.println("\t" + i + ": ");
			while(dice != 5)
			{
				dice = rng.nextInt(5)+1;
				rolls++;
				fw.println(dice + ", ");
			}	
		results[i] = rolls;
		rolls = 0;
		dice = 0;
		}
		
		
		
		// Calculate the average and output the results.
		
		for(int k=0; k != results.length; k++)
		{
			sum = sum + results[k];
		}
		double average = (double)sum/(double)rounds;
		System.out.println("Out of " + rounds + " rounds, it took " + average + " bottles on average to win.");
		fw.println("Out of " + rounds + " rounds, it took " + average + " bottles on average to win.");
		
		fw.close();
	}
}