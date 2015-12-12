import java.util.Random;
import java.util.Scanner;

class Lottery
{
	public static void main(String[] args)
	{
		Random rng = new Random();
		Scanner in = new Scanner(System.in);
		
		int i = 1;
		int winningnumber = rng.nextInt(999);
		String strwinningnumber = new String();
		strwinningnumber = String.valueOf(winningnumber);
		
		System.out.println("[debug] the winning number is: " + winningnumber);
		
		System.out.print("Please enter your three numbers (e.g. 123): ");
		String guess = new String(in.nextLine());
			
		if(guess.length() > 3) // did the user imput a valid length number?
		{
			System.out.println("Your guess cannot be longer than 3 characters.\nPlease try again.");
			System.exit(0);
		}	
		else if(guess.equals(strwinningnumber)) // is the user's guess completely correct?
		{
			System.out.println("Winner: " + winningnumber);
			System.out.println("Congratulations, both pairs matched.");
			System.exit(0);
		}
		else
		{
			for(i=0; i < 2; i=i+1) // nope! start iterating through the user's input.
			{
				System.out.println(guess.substring(i,i+2) + "\n" + strwinningnumber.substring(i,i+2) + "\n" + (guess.length()-1));
				
				if(guess.substring(i,i+2).equals(strwinningnumber.substring(i,i+2))) // found a match!
				{
					if(i == 0) // the first pair matched.
					{
						System.out.println("Winner: " + winningnumber);
						System.out.println("Congratulations, the front pair matched.");
						System.exit(0);
					}
					else if(i == 1) // the last pair matched.
					{
						System.out.println("Winner: " + winningnumber);
						System.out.println("Congratulations, the end pair matched.");
						System.exit(0);
					}	
				}
			}
			System.out.println(i);
			// for loop terminated; nothing matched!
			System.out.println("Winner: " + winningnumber);
			System.out.println("Sorry, no matches.");
		}
	}
}