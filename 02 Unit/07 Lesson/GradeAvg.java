class GradeAvg
{
	public static void main(String[] args)
	{
		int totalPoints = 0;
		//int numTest = 0;
		//int testGrade = 0;
		double average = 0.0;
		int[] grades = {97, 79, 83, 88, 30, 20, 10};

		for(int i=0; i < grades.length; i++)
		{
			 totalPoints += grades[i];
			 average = totalPoints / (i+1);

			System.out.println("n = " + i + " New Test Grade: " + grades[i] + " Total Points: " + totalPoints + " Average Score: " + average);
		}


	}
}
