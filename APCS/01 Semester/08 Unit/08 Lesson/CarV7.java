/*
Name: Ryan Stenmark
Date: 2016-01-20
Purpose: Calculate important statistics related to a car's usage 
        and present the resultant data in a human-readable format.
*/

class CarV7
{
    public String typeOfCar1;
    public int startMiles1;
    public int endMiles1;
    public int gallons1;
    public int gallonsUsed1;
    public double pricePerGallon1;
    public double distance1;
    public double mpg1;
    public double gpm1;
    public double cost1;
    
    // Default Constructor
	CarV7(String typeOfCar, int startMiles, int endMiles, int gallons, int gallonsUsed, double pricePerGallon)
    {
        typeOfCar1 = typeOfCar;
        startMiles1 = startMiles;
        endMiles1 = endMiles;
        gallons1 = gallons;
        gallonsUsed1 = gallonsUsed;
        pricePerGallon1 = pricePerGallon;
        distance1 = (double)calcDistance(startMiles1, endMiles1);
        mpg1 = calcMPG(distance1, gallons1);
        gpm1 = calcGPM(gallons1, distance1);
        cost1 = totalCost(gallonsUsed1, pricePerGallon1);
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
}

class CarV7Tester
{
    public static void main(String[] args)
	{
        CarV7[] cars = new CarV7[3]; 
        
        // Construct car object using CarV7's default constructor
        //                      name of car     startM  endM    gal gU  ppGal
        CarV7 car1 = new CarV7("12' Ford Edge", 127312, 127686, 17, 16, 2.12);
        CarV7 car2 = new CarV7("16' Honda CRZ", 127312, 127686, 17, 11, 2.12);
        CarV7 car3 = new CarV7("16' Dodge Ram", 127312, 127686, 25, 24, 2.12);
            
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
            
        // Present output in a human-readable format.
        System.out.printf("%80s%n", "Gas Mileage Calculations");
        System.out.printf("%s%16s%16s%16s%16s%14s%16s%20s%15s%n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Price", "Cost", "Miles/Gal", "Gallons/Mi");
        for(int i=0; i != 140; i++)
        {
            System.out.print("=");
        }
            
        for(CarV7 c : cars)
        {
            System.out.printf("%n%s%12d%16d%16.0f%16d%16.2f%16.2f%16.1f%17.4f%n", c.typeOfCar1, c.startMiles1, c.endMiles1, c.distance1, c.gallons1, c.pricePerGallon1, c.cost1, c.mpg1, c.gpm1);
        }
    }    
}