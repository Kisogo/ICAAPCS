/*
To simplify things, I have the user select their number range using arguments
	> provided through the command line. Using arguments, there's no messing around
	> Java strings, and the input that the user provides is immediately of type int.
												(unless it isn't.. but we can deal with that.)
												
	> We can completely avoid parsing with String methods and type conversions
	> using this approach. 
	
Usage: java GGV1 [inclusive range integer] [exclusive range integer]
*/


import java.util.Scanner;
import java.util.Random;

class GGV2
{
	public static void main(String[] args)
	{	
		int guess = 0;
		int rangeexclusive = 0;
		int rangeinclusive = 0;
		
		// Modified but stolen code from Oracle's Java tutorial documentation.
		if(args.length > 0) // if the user actually provided arguments, continue.
		{
			try // Since we have arguments to work with, try assigning them to variables.
			{
				rangeinclusive = Integer.parseInt(args[0]);
				rangeexclusive = Integer.parseInt(args[1]);
			}
			catch(NumberFormatException e) /* Oops, those arguments aren't integers, catch the exception,
												throw an error, and exit cleanly. */
			{
				System.err.println("Input arguments must be integers.");
				System.err.println("Usage: java GGV2 [inclusive range integer] [exclusive range integer]\n");
				System.exit(1);
			}
		}
		else // The user did not provide any arguments, teach them how to use the program.
		{
			System.err.println("Usage: java GGV1 [inclusive range integer] [exclusive range integer]\n");
			System.exit(1);
		}
		
		
		// Construct our RNG and scanner object.
		Random rng = new Random();
		Scanner in = new Scanner(System.in);
		
		/* Using more steps than is probably required, we generate an IntStream of length 1, and then find the sum
			of the single integer in the IntStream to get our random number.
			No single method in the random class can generate a random number using both inclusive and exlusive args. */
		int targetnumber = rng.ints(1, rangeinclusive, rangeexclusive).sum();
		
		System.out.println("\n[debug] The target number is " + targetnumber);
		
		while(guess != targetnumber)
			{
				System.out.print("Enter your guess [ between " + rangeinclusive + " and " + rangeexclusive + " ]: ");
				guess = in.nextInt();
				
				if(guess == targetnumber) // User's guess is correct, they win.
				{
					System.out.println("\nCongratulations!\nThe random number was: " + targetnumber + ".");
					break;
				}
				else if(guess > targetnumber) // User's guess is greater than the target number.
				{
					System.out.println("Your guess is too high, try again.");
				}
				else // User's guess is less than the target number.
				{
					System.out.println("Your guess is too low, try again.");
				}
			}


	}
}
