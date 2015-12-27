import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.lang.Math;

class HeatIndex
{
	public static void main(String[] args) throws IOException
	{
		File temperaturefilein = new File("KeyWestTemp.txt");
		File humidityfilein = new File("KeyWestHumid.txt");
		
		Scanner tempin = new Scanner(temperaturefilein);
		Scanner humidin = new Scanner(humidityfilein);
		
		PrintWriter out = new PrintWriter(new File("output"));
		
		//double[] tempdata = {0.0};
		//double[] humiddata = {0.0};
		//double[] HIdata = {0.0};
		
		// Read data from file to array
		int i = 0;
		while(tempin.hasNextDouble())
		{
			double[] tempdata = new double[tempin.nextDouble()];
			i++;
		}
		
		i = 0;
		while(humidin.hasNextInt())
		{
			humiddata[i] = (double)humidin.nextInt()*0.01;
			i++;
		}
		
		double heatindex = 0.0;
		
		// Calculate heat indices and store them in an array
		for(i=0; i < tempdata.length; i++)
		{
			//heatindex = -42.379 + 2.04901523 * tempdata[i] + 10.14333127 * humiddata[i] - (0.22475541 * tempdata[i]) * humiddata[i] - Math.pow(6.83783*10,3.0) * Math.pow(tempdata[i],2.0) - Math.pow(5.481717*10,-2.0) * Math.pow(humiddata[i],2.0) + Math.pow(1.22874*10,-3.0) * Math.pow(tempdata[i],2.0) * humiddata[i] + Math.pow(8.5282*10,-4.0) * tempdata[i] * Math.pow(humiddata[i],2.0) - Math.pow(1.99*10,-6.0) * Math.pow(tempdata[i],2.0) * Math.pow(humiddata[i],2.0);
			//System.out.println(heatindex);
		}
	}
}
