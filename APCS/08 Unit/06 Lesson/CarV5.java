/*
Name: Ryan Stenmark
Date: 2016-01-20
Purpose: Calculate important statistics related to a car's usage 
        and present the resultant data in a human-readable format.
*/

class CarV5
{
    private String typeOfCar1;
    private int startMiles1;
    private int endMiles1;
    private int gallons1;
    private int gallonsUsed1;
    private double pricePerGallon1;
    private double cost1;
    
    // Default Constructor
	CarV5(String typeOfCar, int startMiles, int endMiles, int gallons, int gallonsUsed, double pricePerGallon)
    {
        typeOfCar1 = typeOfCar;
        startMiles1 = startMiles;
        endMiles1 = endMiles;
        gallons1 = gallons;
        gallonsUsed1 = gallonsUsed;
        pricePerGallon1 = pricePerGallon;
    }
    
    // ================================================================================================================================
    /* public int calcDistance(miles on odometer at beginning of data capture period, miles on odometer at end of data capture period)
        This method will calculate the distance in miles traveled between two data points.
    */
    public int calcDistance(int sMiles, int eMiles)
	{
		return eMiles - sMiles;
	}

    // ================================================================================================================================
    /* public double calcMPG(distance traveled over data capture period, amount of gas in gallons expended over data capture period)
        This method will calculate the MPG (Miles Per Gallon) of a car between two data points.
    */
	public double calcMPG(int dist, int gals)
	{
		return dist / gals;
	}
    // OVERLOAD public double calcMPG(double dist, int gals)
    public double calcMPG(double dist, int gals)
    {
        return dist / (double)gals;
    }
    
    // ================================================================================================================================
    /* public double calcMPG(amount of gas in gallons expended over data capture period, distance traveled over data capture period)
        This method will calculate the GPM (Gallons Per Mile) of a car between two data points.
    */
    public double calcGPM(int gals, int dist)
    {
        return gals / dist;
    }
    // OVERLOAD public double calcGPM(int gals, double dist)
    public double calcGPM(int gals, double dist)
    {
        return (double)gals / dist;
    }

    // ================================================================================================================================
    /* public double totalCost(amount of gas in gallons expended over data capture period, cost per gallon)
        This method will calculate the total cost of the gas used between two data points.
    */
    public double totalCost(int gals, double pricePerGallon)
    {
        return gals * pricePerGallon;
    }

	public static void main(String[] args)
	{
        
            // Construct car object using CarV5's default constructor
            CarV5 car1 = new CarV5("12' Ford Edge", 127312, 127686, 17, 16, 2.12);
            double distance1 = (double)car1.calcDistance(car1.startMiles1, car1.endMiles1);
            double mpg1 = car1.calcMPG(distance1, car1.gallons1);
            double gpm1 = car1.calcGPM(car1.gallons1, distance1);
            double cost1 = car1.totalCost(car1.gallonsUsed1, car1.pricePerGallon1);
            
            // Present output in a human-readable format.
            System.out.printf("%80s%n", "Gas Mileage Calculations");
            System.out.printf("%s%16s%16s%16s%16s%14s%16s%20s%15s%n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Price", "Cost", "Miles/Gal", "Gallons/Mi");
            for(int i=0; i != 140; i++)
            {
                System.out.print("=");
            }
            System.out.printf("%n%s%12d%16d%16.0f%16d%16.2f%16.2f%16.1f%17.4f%n", car1.typeOfCar1, car1.startMiles1, car1.endMiles1, distance1, car1.gallons1, car1.pricePerGallon1, cost1, mpg1, gpm1);
	}
}
