import java.util.Scanner;
class HeartRate
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Determine your Target Heart Rate Zone for Cardiovascular exercise (50% - 85%)");
		
		// Get user's age
		System.out.print("Enter your age: ");
		int age = in.nextInt();

		// Get user's resting heart rate
		System.out.print("Enter your resting heart rate: ");
		int restingHeartRate = in.nextInt();
		
		// Get user's heart rate after exercising.
		System.out.print("Enter your heart rate after exercising: ");
		int heartRateAfterExercise = in.nextInt();
		
		//Maximum Heart Rate (henceforth known as MHR)
		int MMR = 220 - age;
		//Heart rate reserve (henceforth known as HRR)
		int HRR = MMR - restingHeartRate;
		
		//Calculate upper and lower bounds of training zone
		//upper (85%):
		double Upper = ((double)HRR*.85) + (double)restingHeartRate;
		//lower (%50):
		double Lower = ((double)HRR*.50) + (double)restingHeartRate;
		
		//Output results
		System.out.println("\nYour target heart rate zone is between " + Lower + " and " + Upper + " BPM");
		
		if(heartRateAfterExercise > Lower && heartRateAfterExercise < Upper)
		{
			System.out.println("After just exercising, your heart rate is within your target zone.");
		}
		else
		{
			System.out.println("After just exercising, your heart rate is not within your target zone.");
		}
	}
}
