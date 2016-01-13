import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

class WeightOnPlanets
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new File("surfacegravity"));
		
		String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
		double[] planetDiameters = {4880.0, 12103.0, 12765.0, 6794.0, 142984.0, 120536.0, 51118.0, 49532.0, 2372.0};
		double[] planetMasses = {3.30*Math.pow(10.0, 23.0), 4.869*Math.pow(10.0, 24.0), 5.972*Math.pow(10.0, 24.0), 6.4219*Math.pow(10.0, 23.0), 1.900*Math.pow(10.0, 27.0), 5.68*Math.pow(10.0, 26.0), 8.68*Math.pow(10.0, 26.0), 1.0247*Math.pow(10.0, 26.0), 1.303*Math.pow(10.0, 22.0)};

		for(int i = 0; i < planetNames.length; i++)
		{
			double accelFromGravity = ( (6.67 * Math.pow(10.0, -11.0)) * (planetMasses[i]) / Math.pow((planetDiameters[i]/2), 2.0) );
			pw.printf("%f%n", accelFromGravity / 1000000);
		}
		
		pw.close();
	}
}
