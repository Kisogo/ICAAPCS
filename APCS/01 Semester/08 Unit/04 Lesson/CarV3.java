/*
Name: Ryan Stenmark
Date: 2016-01-18
Purpose: Calculate the distance traveled and MPG of a car 
        and present the resultant data in a human-readable format.
*/

class CarV3
{
    // Default Constructor
	CarV3()
    {
    }
    
    
    /* public int calcDistance(miles on odometer at beginning of data capture period, miles on odometer at end of data capture period)
        This method will calculate the distance in miles traveled between two data points.
    */
    public int calcDistance(int sMiles, int eMiles)
	{
		return eMiles - sMiles;
	}

    /* public double calcMPG(distance traveled over data capture period, amount of gas in gallons expended over data capture period)
        This method will calculate the MPG (Miles Per Gallon) of a car between two data points.
    */
	public double calcMPG(int dist, double gals)
	{
		return dist / gals;
	}


	public static void main(String[] args)
	{
            String nameOfCar1 = "12' Ford Edge";
            int startMiles1 = 127312;
            int endMiles1 = 127686;
            int gallons1 = 17;
        
            // Construct car object using CarV3's default constructor
            CarV3 car1 = new CarV3();
            int distance1 = car1.calcDistance(startMiles1, endMiles1);
            double mpg1 = car1.calcMPG(distance1, gallons1);
            
            // Present output in a human-readable format.
            System.out.printf("%40s%n", "Gas Mileage Calculations");
            System.out.printf("%s%16s%16s%16s%16s%16s%n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Miles/Gal");
            for(int i=0; i != 100; i++)
            {
                System.out.print("=");
            }
            System.out.printf("%n%s%12d%16d%16d%16d%18.1f%n", nameOfCar1, startMiles1, endMiles1, distance1, gallons1, mpg1);
	}
}
