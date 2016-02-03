/**
 * Calculates the number of pounds and equivalent number of tons of CO2 created by the annual usage of gasoline.
 *
 * @author Ryan Stenmark
 * @version 2016-01-23
 */


public class CO2FootprintV1
{
    private double myGallonsUsed;
    private double myTonsCO2;
    private double myPoundsCO2;
    
    /**
    * Default constructor for objects of type CO2FootprintV1
    */
    CO2FootprintV1(double gals)
    {
        myGallonsUsed = gals;
        myTonsCO2 = calcTonsCO2(myGallonsUsed);
        myPoundsCO2 = convertTonsToPoundsCO2(myTonsCO2);
    }
    
    /**
    * Accessor method to calculate number of pounds of CO2 created.
    * @param myGallonsUsed number of gallons used annually.
    * @return number of tons of CO2 created. 
    */
    public double calcTonsCO2(double myGallonsUsed)
    {
        return myGallonsUsed * (8.78*Math.pow(10,-3));   
    }
    
    
    /**
    * Accessor method to convert tons of CO2 to pounds.
    * @param myTonsCO2 number of tons to convert.
    * @return equivalent number of pounds of CO2.
    */
    public double convertTonsToPoundsCO2(double myTonsCO2)
    {
        return myTonsCO2 * 1000;
    }
    
    
    /**
    * Accessor method to return the number of tons of CO2 generated.
    * @return myTonsCO2 number of tons of CO2.
    */
    public double getTonsCO2()
    {
        return myTonsCO2;
    }
    
    
    /**
    * Accessor method to return the number of pounds of CO2 generated.
    * @return myPoundsCO2 number of punds of CO2.
    */
    public double getPoundsCO2()
    {
        return myPoundsCO2;
    }

}


class CO2FootprintV1Tester
{
	public static void main(String[] args)
	{
        double gallonsUsed = 953.71;
        CO2FootprintV1 footprint = new CO2FootprintV1(gallonsUsed);
        
        System.out.printf("%n%18s", "CO2 Emissions");
        System.out.printf("%n%s%9s%7s", "Gallons", "Pounds", "Tons");
        System.out.printf("%n%s%10s%10s", "of Gas", "from Gas", "from Gas");
        System.out.printf("%n%s", "**************************");
        
        System.out.printf("%n%.1f%10.1f%8.1f%n", gallonsUsed, footprint.getPoundsCO2(), footprint.getTonsCO2());

	}
}
