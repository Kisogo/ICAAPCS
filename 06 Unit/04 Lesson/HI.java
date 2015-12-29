import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/*
Name : Ryan Stenmark
Date : 2015-12-29
Purpose : Present Temperature, Humidity, and Heat Index data in a human readable table format.
*/


class HI
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new File("output"));
		
		Scanner TemperatureIn = new Scanner(new File("KeyWestTemp.txt"));
		Scanner HumidityIn = new Scanner(new File("KeyWestHumid.txt"));
		
		String[] Months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		double[] HumidityData = new double[12];
		double[] TemperatureData = new double[12];
		double[] HIData = new double[(int)HumidityData.length];
		double[] HeatIndices = new double[12];
		
		double TemperatureDataSum = 0.0;
		double HumidityDataSum = 0.0;
		double HeatIndicesSum = 0.0;
		
		double TemperatureDataAvg = 0.0;
		double HumidityDataAvg = 0.0;
		double HeatIndicesAvg = 0.0;
		

		
		// Read data in from file to array
		int i = 0;
		while(HumidityIn.hasNextInt())
		{
			HumidityData[i] = (double)HumidityIn.nextInt();
			i++;
		}
		
		i = 0;
		while(TemperatureIn.hasNextDouble())
		{
			TemperatureData[i] = TemperatureIn.nextDouble();
			i++;
		}
		
		
		
		// Calculate averages
		for(double x : TemperatureData)
		{
			TemperatureDataSum =+ x;
		}
		TemperatureDataAvg = TemperatureDataSum / 12;
		
		for(double x : HumidityData)
		{
			HumidityDataSum =+ x;
		}
		HumidityDataAvg = HumidityDataSum / 12;
		
		
		
		// Calculate Heat Indices
		for(i=0; i < 12; i++)
		{
			HeatIndices[i] = -42.379 
			+ (2.04901523 * TemperatureData[i]) 
			+ (10.14333127 * HumidityData[i]) 
			+ (-0.22475541 * TemperatureData[i] * HumidityData[i]) 
			+ ((-6.83783 * Math.pow(10.0 ,-3.0)) * Math.pow(TemperatureData[i] , 2.0)) 
			+ ((-5.481717 * Math.pow(10.0 , -2.0)) * Math.pow(HumidityData[i] , 2.0)) 
			+ (((1.22874 * Math.pow(10.0 , -3.0)) * Math.pow(TemperatureData[i] , 2.0)) * HumidityData[i]) 
			+ (((8.5282 * Math.pow(10 , -4)) * TemperatureData[i]) * Math.pow(HumidityData[i], 2.0)) 
			+ (((-1.99 * Math.pow(10.0 , -6.0)) * Math.pow(TemperatureData[i], 2.0)) * Math.pow(HumidityData[i] , 2.0));
			
			HeatIndicesSum =+ HeatIndices[i];
		}
		HeatIndicesAvg = HeatIndicesSum / 12;

		
		// Format and print output to stdout
		System.out.printf("%n%90s%n%n%80s%n%15s", "Heat Index: Key West, Florida", "Months", "");
		
		for(String x : Months)
		{
			System.out.printf("%10s", x);
		}
		
		System.out.printf("%10s%n", "Avg");
		
		for(i=0; i != 145; i++)
		{
			System.out.print("*");
		}
		
		// Temperature Data
		System.out.printf("%n%-16s", "Temp (F)");
		for(double x : TemperatureData)
		{
			System.out.printf("%10.1f", x);
		}
		System.out.printf("%9.1f", TemperatureDataAvg);
		
		// Humidity Data
		System.out.printf("%n%-16s", "Humidity (%)");
		for(double x : HumidityData)
		{
			System.out.printf("%10.1f", x);
		}
		System.out.printf("%9.1f", HumidityDataAvg);
		
		// Heat Index Data
		System.out.printf("%n%-16s", "HI (F)");
		for(double x : HeatIndices)
		{
			System.out.printf("%10.1f", x);
		}
		System.out.printf("%9.1f%n", HeatIndicesAvg);
		
		// Format and print output to printwriter output file
		pw.printf("%n%90s%n%n%80s%n%15s", "Heat Index: Key West, Florida", "Months", "");
		
		for(String x : Months)
		{
			pw.printf("%10s", x);
		}
		
		pw.printf("%10s%n", "Avg");
		
		for(i=0; i != 145; i++)
		{
			pw.print("*");
		}
		
		// Temperature Data
		pw.printf("%n%-16s", "Temp (F)");
		for(double x : TemperatureData)
		{
			pw.printf("%10.1f", x);
		}
		pw.printf("%9.1f", TemperatureDataAvg);
		
		// Humidity Data
		pw.printf("%n%-16s", "Humidity (%)");
		for(double x : HumidityData)
		{
			pw.printf("%10.1f", x);
		}
		pw.printf("%9.1f", HumidityDataAvg);
		
		// Heat Index Data
		pw.printf("%n%-16s", "HI (F)");
		for(double x : HeatIndices)
		{
			pw.printf("%10.1f", x);
		}
		pw.printf("%9.1f%n", HeatIndicesAvg);
		
		// close PrintWriter
		pw.close();

	}
}
