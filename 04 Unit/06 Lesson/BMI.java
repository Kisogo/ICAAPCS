import java.util.Scanner;

class BMI
{
	public static void main(String[] args)
	{
		// Create scanner object.
		Scanner in = new Scanner(System.in);
		
		// Get name from user.
		System.out.print("Enter your name (first last): ");
		String name = in.nextLine();

		// Get weight (lbs) from user.
		System.out.print("Enter your weight in pounds (e.g. 175): ");
		int weightlbs = in.nextInt();
		
		// Get height (ft, in) from user.
		in.nextLine(); //Consume newline left-over.
		System.out.print("Enter your height in feet and inches (e.g. 5 11): ");
		String height = new String(in.nextLine());

		height = height.replaceAll(" ", "");
		double heightinches = Math.pow(Integer.parseInt(height.substring(0,1))*12 + Integer.parseInt(height.substring(1,2)) , 2);

		
		// Calculate BMI.
		double BMI = weightlbs / heightinches * 703.0;
		
		// Output results.
		System.out.println("\nBody Mass Index Calculator");
		System.out.println("============================");
		System.out.println("Name: " + name);
		System.out.println("Height (m): " + heightinches * 0.0254);
		System.out.println("Weight (kg): " + weightlbs * 0.453592);
		System.out.println("BMI: " + BMI);
		
		if(BMI < 18.5)
		{
			System.out.println("Category: Underweight");
		}
		else
		{
			if(18.5 < BMI & BMI < 24.9)
			{
				System.out.println("Category: Normal or Healthy Weight");
			}
			else
			{
				if(25.0 < BMI & BMI < 29.9)
				{
					System.out.println("Category: Overweight");
				}
				else
				{
					if(BMI > 30.0)
					{
						System.out.println("Category: Obese");
					}
				}
			}
		}
	}
}
