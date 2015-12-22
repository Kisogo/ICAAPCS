import java.util.Random;


class Monte
{
	public static void main(String[] args)
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
		
		
		
		
		// Run the trials.
		
		Random rng = new Random();
		
		int rolls = 0;
		int dice = 0;
		int sum = 0;
		int[] results = new int[rounds];
		
		for(int i=0; i < rounds; i++)
		{
		System.out.println("\t" + i + ": ");
			while(dice != 5)
			{
				dice = rng.nextInt(5)+1;
				rolls++;
				System.out.println(dice + ", ");
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
		System.out.println("Out of " + rounds + " rounds, it took " + average + " rolls on average to roll a 5.");
	}
}