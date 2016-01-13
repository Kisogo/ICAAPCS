import java.util.IllegalFormatException;



class AnnualClimate2
{
	public static void main(String[] args)
	{
	
		String usage = new String("Usage: java AnnualClimate1 [temperature units(C/F)] ... [measurement unit(in/cm)]");
		
		// Check the user's input.
		if(args.length > 0)
		{
			try
			{
				if(args.length > 2 || args.length < 2)
				{
					System.err.println("Invalid number of arguments.");
					System.err.println(usage);
					System.exit(1);
				}
			}
			catch(IllegalFormatException e)
			{
				System.err.println("Input arguments must be Strings.");
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
		
		String TemperatureScale = new String("");
		String DepthScale = new String("");
		
		// Parse user arguments
		
		boolean useInches = false;
		boolean useCentimeters = false;
		boolean useCelsius = false;
		boolean useFahrenheit = false;
		
		if(args[0].equals("C") || args[0].equals("c"))
		{
			useCelsius = true;
			TemperatureScale = new String("C");
		}
		else if(args[0].equals("F") || args[0].equals("f"))
		{
			useFahrenheit = true;
			TemperatureScale = new String("F");
		}
		else
		{
			System.err.println(args[0] + " is not a recognized flag.");
			System.err.println(usage);
			System.exit(1);
		}
		
		
		if(args[1].equals("IN") || args[1].equals("in") || args[1].equals("In") || args[1].equals("iN"))
		{
			useInches = true;
			DepthScale = new String("in");
		}
		else if(args[1].equals("CM") || args[1].equals("cm") || args[1].equals("Cm") || args[1].equals("cM"))
		{
			useCentimeters = true;
			DepthScale = new String("cm");
		}
		else
		{
			System.err.println(args[1] + " is not a recognized flag.");
			System.err.println(usage);
			System.exit(1);
		}
		
		// Initialize our data set (Fahrenheit, Inches)
		String[] Location = {"Apalachicola", "Florida"};
		double[] Temp = {52.7, 55.3, 60.7, 66.8, 74.1, 80.0, 81.9, 81.7, 79.1, 70.2, 62.0, 55.2};
		double[] Rainfall = {4.9, 3.8, 5.0, 3.0, 2.6, 4.3, 7.3, 7.3, 7.1, 4.2, 3.6, 3.5};
		
		/* Alternate Data Set
		String[] Location = {"Daytona Beach", "Florida"};
		double[] Temp = {58.4, 60.0, 64.7, 68.9, 74.8, 79.7, 81.7, 81.5, 79.9, 74.0, 67.0, 60.8};
		double[] Rainfall = {3.1, 2.7, 3.8, 2.5, 3.3, 5.7, 5.2, 6.1, 6.6, 4.5, 3.0, 2.7};
		*/
		
		String[] Months = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
		double Temp_sum = 0.0;
		double Rainfall_Annual = 0.0;
		
		System.out.printf("%b%10b%10b%10b%n", useInches, useCentimeters, useCelsius, useFahrenheit);
		
		// Convert data to centimeters
		if(useCentimeters == true);
		{
			System.out.println("[debug] using Centimeters");
			for(int i = 0; i < Temp.length; i++)
			{
				Temp[i] = Temp[i] * 2.54;
			}	
		}
		
		// Convert data to Celsius
		if(useCelsius == true);
		{
			System.out.println("[debug] using Celsius");
			for(int j = 0; j < Rainfall.length; j++)
			{
				Rainfall[j] = (Rainfall[j] - 32) * 5/9;
			}
		}
		
		// Calculate Average temperature
		for(double x : Temp)
		{
			Temp_sum = Temp_sum + x;
		}
		
		for(double y : Rainfall)
		{
			Rainfall_Annual = Rainfall_Annual + y;
		}
		
		double Temp_Avg = Temp_sum / Temp.length;
		
		
		System.out.printf("%15Climate Data%n");
		System.out.printf("%15Location: %s, %s%n", Location[0], Location[1]);
		System.out.printf("Month%15sTemperature (%s)%tPrecipitation (%s)", TemperatureScale, DepthScale);
		System.out.println("************************************************");
		
		for(int k=0; k != Months.length; k++)
		{
			System.out.printf("%s%15s%f%15s%f", Months[k], Temp[k], Rainfall[k]);
		}
		
		System.out.println("************************************************");
		System.out.printf("%13Average: %s%15Annual: %s", (Temp_Avg - (Temp_Avg % 0.1)), (Rainfall_Annual - (Rainfall_Annual % 0.1)));
		
		
	}
}