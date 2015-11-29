
/**
 * This program models flipping an unbiased coin and counting the
 * number of times heads or tails occurs.
 * 
 * @author B. Jordan 
 * @version 04/01/08
 */
import java.util.Scanner;
public class hsots
{
	public static void main(String[] args)
	{
	    int i = 1;
		int heads = 0;
		double avgheads = 0.0;
		double totalheads = 0.0;
	    int tails = 0;
		double avgtails = 0.0;
		double totaltails = 0.0;
	    int counter = 1;
	    double randNum = 0.0;
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("How many times will the coin be flipped? ");
	    int flips = in.nextInt();
	    
		while(i <= 5)
		{
			while(counter <= flips)
			{
				randNum = Math.random();
				//System.out.print(counter + "\t" + randNum);
	        
				if(randNum < .4)
				{
					heads++;
					//System.out.println("\t heads");
				}
				else
				{
					tails++;
					//System.out.println("\t tails");
				}
				counter++;      
			}
			System.out.println();
			System.out.println("Number of Heads = " + heads);
			System.out.println("Number of Tails = " + tails);
			counter = 1;
			
			//avgheads = (avgheads + heads) / flips;
			//avgtails = (avgtails + tails) / flips;
			
			totalheads =+ heads;
			totaltails =+ tails;
			
			heads = 0;
			tails = 0;
			
			i++;
			
			if(i == 6)
			{
				System.out.println("Avg Heads: " + totalheads/5);
				System.out.println("Avg Tails: " + totaltails/5);
			}
		}
	}
}