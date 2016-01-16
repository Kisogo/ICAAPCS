import java.util.Scanner;
import java.io.IOException;
import java.io.File;



class WoP
{
	public static void main(String[] args) throws IOException
	{
		String usage = new String("Usage: java WoP [weight in lbs]");
		
		// Check the user's input.
		if(args.length > 0)
		{
			if(args.length > 1 || args.length < 1)
			{
				System.err.println("Invalid number of arguments.");
				System.err.println(usage);
				System.exit(1);
			}
		}
		else
		{
			System.err.println("Arguments must be specified.");
			System.err.println(usage);
			System.exit(1);
		}
		
		
		
		
		
		
		Scanner inFile = new Scanner(new File("surfacegravity"));
		String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
		double[] surfaceGravity = new double[9];
		double[] weightOnPlanet = new double[9];
		
		// Read surface gravity (in m/s^2) in from file and divide by 10 (the math I used to generate this data wasnt perfect...)
		int i = 0;
		while(inFile.hasNextDouble())
		{
			surfaceGravity[i] = inFile.nextDouble()/10;
			i++;
		}
		
		// Divide surface gravity of each planet by 9.79 (the surface gravity of Earth)
		for(i = 0; i < 9; i++)
		{
			surfaceGravity[i] = surfaceGravity[i] / surfaceGravity[2];
		}
		
		// Calculate local weight on each planet
		for(i = 0; i < 9; i++)
		{
		weightOnPlanet[i] = InformativeClassName.calculateLocalWeight(args, surfaceGravity, i);
		}
				
		// Output results.
		InformativeClassName.output(planetNames, surfaceGravity, weightOnPlanet);
	}
}


class InformativeClassName
{
	static String usage = new String("Usage: java WoP [weight in lbs]");
	
	public static double calculateLocalWeight(String[] args, double[] surfaceGravity, int i)
	{
		// Calculate local weight on each planet
		try
		{
			return Double.parseDouble(args[0]) * surfaceGravity[i];
		}
		catch(NumberFormatException e)
		{
			System.err.println("Input argument must be an integer number.");
			System.err.println(usage);
			System.exit(1);	
		}
		return 0;
	}
	
	public static void output(String[] planetNames, double[] surfaceGravity, double[] weightOnPlanet)
	{
		// Output results
		System.out.printf("%33s%n", "My Weight on the Planets");
		System.out.printf("%9s%15s%17s%n", "Planet", "Gravity", "Weight (lbs)");
		System.out.printf("%s%n", "-----------------------------------------");
		
		for(int i = 0; i < 9; i++)
		{
			System.out.printf("%9s%14.2f%15.2f%n", planetNames[i], surfaceGravity[i], weightOnPlanet[i]);
		}
	}
}