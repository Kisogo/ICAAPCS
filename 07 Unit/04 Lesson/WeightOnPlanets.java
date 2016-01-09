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
		double[] planetMasses = {Math.pow(3.30, 23), Math.pow(4.869, 24), Math.pow(5.972, 24), Math.pow(6.4219, 23), Math.pow(1.900, 27), Math.pow(5.68, 26), Math.pow(8.68, 26), Math.pow(1.0247, 26), Math.pow(1.303, 22)};

		for(int i = 0; i < planetNames.length; i++)
		{
			//pw.println(planetNames[i] + " " + (Math.pow(6.67*10.0, -11.0) * planetMasses[i]) / Math.pow( (planetDiameters[i]/2)*1000, 2.0) + " m/s^2");
			pw.printf("%s %f %s%n", planetNames[i], (Math.pow(6.67*10.0, -11.0) * planetMasses[i]) / Math.pow( (planetDiameters[i]/2)*1000, 2.0), "m/s^2" );
		}
		
		pw.close();
	}
}
