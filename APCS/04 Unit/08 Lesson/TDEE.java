import java.util.Scanner;

class TDEE
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	
		// Get user's name.
		System.out.print("Please enter your name: ");
		String name = new String(in.nextLine());
	
		// Get user's BMR.
		System.out.print("Please enter your BMR: ");
		double BMR = in.nextDouble();
		in.nextLine();
	
		// Get user's gender.
		System.out.print("Please enter your Gender (M/F): ");
		String gender = new String(in.nextLine());
	
		String Menu = new String("\nSelect your Activity Level\n"
								+"[0] Resting (Sleeping, Reclining)\n"
								+"[1] Sedentary (Minimal Movement)\n"
								+"[2] Light (Sitting, Standing)\n"
								+"[3] Moderate (Light Manual Labor, Dancing, Riding Bike)\n"
								+"[4] Very Active (Team Sports, Hard Manual Labor)\n"
								+"[5] Extremely Active (Full-time Athlete, Heavy Manual Labor)\n"
								+"\nEnter the number corresponding to your activity level: ");
		System.out.print(Menu);
	
		int selection = in.nextInt(); // Get the user's selection.
	
		double activityfactor = 0.0;
		double TDEE = 0.0;
	
		if(gender.equals("M") || gender.equals("m")) // If the user is MALE, continue.
		{
			if(selection == 0)
			{	
				activityfactor = 1.0;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 1)
			{
				activityfactor = 1.3;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 2)
			{
				activityfactor = 1.6;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 3)
			{
				activityfactor = 1.7;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 4)
			{
				activityfactor = 2.1;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 5)
			{
				activityfactor = 2.4;
				TDEE = BMR * activityfactor;
			}
			else
			{
				System.out.println(selection + " is not a valid selection. (0-5) Try again.");
			}	
		}
		else if(gender.equals("F") || gender.equals("f")) // If the user is FEMALE, continue.
		{
			if(selection == 0)
			{
				activityfactor = 1.0;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 1)
			{
				activityfactor = 1.3;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 2)
			{
				activityfactor = 1.5;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 3)
			{
				activityfactor = 1.6;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 4)
			{
				activityfactor = 1.9;
				TDEE = BMR * activityfactor;
			}
			else if(selection == 5)
			{
				activityfactor = 2.2;
				TDEE = BMR * activityfactor;
			}
			else
			{
				System.out.println(selection + " is not a valid selection. (0-5) Try again.");
			}	
		}
		else // If the user is not male or female, complain.
		{
			System.out.println(gender + " is not a valid gender. (M/F) Try again.");
		}
		
		String output = new String("\nName: " + name + "\tGender: " + gender
									+"\nBMR: " + BMR + "\tActivity Factor: " + activityfactor
									+"\nTDEE: " + TDEE);
		
		System.out.println(output);
	}
}