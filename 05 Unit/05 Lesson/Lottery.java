import java.util.Random;
import java.util.Scanner;

class Lottery
{
	public static void main(String[] args)
	{
		Random rng = new Random();
		Scanner in = new Scanner(System.in);
		
		String winningNumber = new String();
		
		// Generate lottery numbers
		for(int i=0; i != 3; i++)
		{
			int nextRandInt = rng.nextInt(9); 
			winningNumber.concat(Integer.toString(nextRandInt)); // concat random number to winning number
			
			System.out.print(nextRandInt);
		}
		
		// Get user's guess
		System.out.print("Please enter your three numbers (e.g. 123): ");
		String guess = new String(in.nextLine());
		
		// Check user's guess and assemble truth 'table' (it's an array)
		boolean[] truthtable = {false, false, false};
		for(int k=1; k < winningNumber.length()-1; k++)
		{
			// Check numbers of user's guess
			if(guess.charAt(k).equals(winningNumber.charAt(k)))
			{
				truthtable[k-1] = true;
				System.out.print("\n" + "k : " + k);
			}
		}
			
		// On what condition did the user win?
		if(truthtable[0] && truthtable[1] && truthtable[2] == true)
		{
			System.out.println("[Debug] " + truthtable[0] + " " + truthtable[1] + " " + truthtable[2]);
			System.out.println("Winner: " + winningNumber);
			System.out.println("Congratulations, both pairs matched.");
			// User's entire guess is correct
		}
		else if(truthtable[0] && truthtable[1] == true)
		{
			System.out.println("Winner: " + winningNumber);
			System.out.println("Congratulations, the front pair matched.");
			// User's first two guesses are correct
		}
		else if(truthtable[1] && truthtable[2] == true)
		{
			System.out.println("Winner: " + winningNumber);
			System.out.println("Congratulations, the end pair matched.");
			// User's last two guesses are correct
		}
		else
		{
			System.out.println("[Debug] " + truthtable[0] + " " + truthtable[1] + " " + truthtable[2]);
			System.out.println("Winner: " + winningNumber);
			System.out.println("Sorry, no matches.");
		 	// None of user's guesses were correct.	
		}		
			
	}
}
