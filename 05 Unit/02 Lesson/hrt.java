import java.util.Scanner;
import java.util.Random;


class hrt
{
	public static void main(String[] args)
	{
		int totalheads = 0;
		int totaltails = 0;
		int cumulativeheads = 0;
		int cumulativetails = 0;
		double side;
		
		// Construct a scanner object and a random number generator object.
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		
		System.out.println("How many times should the coin be flipped? : ");
		int trials = in.nextInt();
		
		// I didn't have a calculator to use, so I'm calculating averages automatically.
		// 	Sorry!
		
		for(int k=1; k <= 5; k++) // Five sets of x number of trials.
		{
			cumulativeheads = cumulativeheads + totalheads;
			cumulativetails = cumulativetails + totaltails;
			
			totalheads = 0;
			totaltails = 0;
		
			for(int v=1; v <= trials; v++) // Start flipping coins.
			{
					// Get the next random double from our RNG.
					side = rng.nextDouble();
				
					if(side > 0.49) // Coin landed heads up.
						{
							//System.out.println("H, " + side + " > " + "0.5");
							totalheads++;
						}
						else // Coin landed tails up.
						{
							//System.out.println("T, " + side + " < " + "0.5");
							totaltails++;
						}
			}
		
			System.out.println("Total heads in set: " + totalheads);
			System.out.println("Total tails in set: " + totaltails + "\n");
				
		}
		
		int averageheads = cumulativeheads / 5;
		int averagetails = cumulativetails / 5;
		
		System.out.println("Overall average number of heads: " + averageheads);
		System.out.println("Overall average number of tails: " + averagetails);
		
	}
}