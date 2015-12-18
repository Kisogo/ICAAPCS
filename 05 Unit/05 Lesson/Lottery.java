import java.util.Random;
import java.util.Scanner;

class Lottery
{
	public static void main(String[] args)
	{
		Random rng = new Random();
		Scanner in = new Scanner(System.in);
		
		String winningnumber = new String();
		
		// Generate lottery numbers
		for(int i=0; i != 3; i++)
		{
			int nextRandInt = rng.nextInt(9); 
			winningnumber.concat(Integer.toString(nextRandInt)); // concat random number to winning number
		}
		
		// Get user's guess
		System.out.println("Please enter your three numbers (e.g. 123): ");
		String guess = new String(in.nextLine());
		
		// Check user's guess
		boolean[] truthtable = {false, false, false};
		for(int k=1; k < guess.length(); k++)
		{
			// Check numbers of user's guess
			if(guess.substring(k,k+1).equals(winningnumber.substring(k,k+1)))
			{
				truthtable[k] = true
			}
			
			
			
			// figure out winning condition
			if(truthtable[1] && truthtable[2] && truthtable[3] == true)
			{
				// user's entire guess is correct
			}else if(truthtable[1] && truthtable[2] == true)
			{
				// user's first two guesses are correct
			}
			else if(truthtable[2] && truthtable[3] == true)
			{
				// user's last two guesses are correct
			}
			else
			{
			 	// none of user's guesses were correct.	
			}
			
			
		}
			
	}
}
