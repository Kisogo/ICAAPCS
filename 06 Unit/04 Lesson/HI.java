import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;


class HI
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter out = new PrintWriter(new File("output"));
		
		Scanner TemperatureIn = new Scanner(new File("KeyWestTemp.txt"));
		Scanner HumidityIn = new Scanner(new File("KeyWestHumid.txt"));
		
		double[] HumidityData = new double[(int) new File("KeyWestHumid.txt").length()];
		double[] TemperatureData = new double[(int) new File("KeyWestTemp.txt").length()];
		double[] HIData = new double[HumidityData.length()];
		
		int i = 0;
		while(HumidityIn.hasNextInt())
		{
			HumidityData[i] = (double)HumidityIn.nextInt();
			i++;
		}
		
		i = 0;
		while(TemperatureIn.hasNextInt())
		{
			TemperatureData[i] = TemperatureIn.nextDouble();
			i++;
		}
		
		System.out.println(HumidityData + "\n" + TemperatureData);

	}
}
