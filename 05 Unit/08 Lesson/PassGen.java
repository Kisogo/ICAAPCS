import java.util.Random;
import java.util.Scanner;

/*
Name: Ryan Stenmark
Date: 2015-12-22
Purpose: Generate random passwords to meet critera
*/


class PassGen
{
	public static void main(String[] args)
	{
		PasswordGenerator pgen = new PasswordGenerator();
		Scanner in = new Scanner(System.in);
		
		System.out.println("            Password Generation Menu              " +
						 "\n**************************************************" +
						 "\n* [1] Lowercase Letters                          *" +
						 "\n* [2] Lowercase and Uppercase Letters            *" +
						 "\n* [3] Lowercase, Uppercase, and Numbers          *" +
						 "\n* [4] Lowercase, Uppercase, Numbers, Punctuation *" +
						 "\n* [5] Quit                                       *" +
						 "\n**************************************************" +
						 "\nEnter Selection [1-5]: ");
		int selection = in.nextInt();
		
		if(selection == 5)
		{
			System.exit(0);
		}
		else
		{
		System.out.println("Password Length [1-inf]: ");
		int length = in.nextInt();
		
		System.out.println("Password: ");
		pgen.generate(selection, length);
		}
	}
}





class PasswordGenerator
{
	Random rng = new Random();
	
	
	public void generate(int i, int length)
	{
		if(i == 1) // lowercase letters
		{
			for(int j=1; j <= length; j++)
			{
				System.out.print((char)rng.ints(1, 97, 122).sum());
			}
			System.out.println("\n");
		}

		else if(i == 2) // lowercase and uppercase letters
		{
			for(int j=1; j<= length; j++)
			{
				int character = 0;
				while(!((character >= 97 && character <= 122) || (character >= 65 && character <= 90)))
				{
					character = rng.nextInt(122);
				}
				System.out.print((char)character);
			}
			System.out.println("\n");
			
		}

		else if(i == 3) // lower, upper, numbers
		{
			for(int j=1; j<= length; j++)
			{
				int character = 0;
				while(!((character >= 97 && character <= 122) || (character >= 65 && character <= 90) || (character >= 48 && character <= 57)))
				{
					character = rng.nextInt(122);
				}
				System.out.print((char)character);
			}
			System.out.println("\n");

		}

		else if(i == 4) // lower, upper, numbers, punctuation
		{
			for(int j=1; j<= length; j++)
			{
				int character = 0; 
				
				// horrible horrible horrible
				while(!((character >= 97 && character <= 122) || (character >= 65 && character <= 90) || (character >= 48 && character <= 57) 
				|| character == 34 
				|| character == 39 
				|| character == 40 
				|| character == 41 
				|| character == 44 
				|| character == 45 
				|| character == 46 
				|| character == 47 
				|| character == 58 
				|| character == 59))
				{
					character = rng.nextInt(122);
				}
				System.out.print((char)character);
			}
			System.out.println("\n");
		}
		else
		{
			System.err.println("Invalid selection.");
		}
	}
}
