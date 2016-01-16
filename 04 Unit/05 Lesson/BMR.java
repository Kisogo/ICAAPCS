import java.util.Scanner;
class BMR
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		double s;
		
		// Get name from user.
		System.out.print("Enter your name: ");
		String name = in.nextLine();
		
		// Get gender from user. If the gender provided is invalid, ask again.
		String gender = "";
		while(true)
		{
			gender = BMRf.getGender();
			if(gender.equals("F") || gender.equals("f") || gender.equals("m") || gender.equals("M"))
			{
				break;
			}
		}
		
		// Get age from user.
		System.out.print("Enter your age: ");
		int age = in.nextInt();
		
		// Get height in inches from user.
		System.out.print("Enter your height in inches: ");
		int height = in.nextInt();
		
		// Get weight in pounds from user.
		System.out.print("Enter your weight in pounds: ");
		int weight = in.nextInt();
		
		// Output results.
		if(gender.equals("f") || gender.equals("F"))
		{
			s = -161;
		}
		else
		{
			s = 5;	
		}
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
		System.out.println("Weight (kg): " + (double)weight/0.453592);
		System.out.println("Height (cm): " + (double)height*2.54);
		
		// Calculate Basal metabolic rate.
		double BMR = (10.0*(weight/0.453592)/1 + 6.25*(height*2.54)/1 + 5*age/1 + s);
		System.out.println("Basal metabolic rate: " + (BMR-BMR%0.1) + " Calories per day");

	}
}


class BMRf
{
	public static String getGender()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Gender (M or F): ");
		String g = in.nextLine();
		
		return g;
	}
}