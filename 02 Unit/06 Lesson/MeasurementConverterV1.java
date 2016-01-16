/**
 * MeasuermentConverter_v1 converts to and from Metric and English
 * units of measure.
 *
 *      Sample Calculation:
 *        1 mile = 5280 ft, therefore    6230 ft / 5280 = 1.7992 miles
 *
 * ©FLVS 2007
 * @author B. Jordan
 * @version 01/19/07
 *
 * Modified by: (Student name goes here)
 * Date: (Today's date goes here.)
 */
public class MeasurementConverterV1
{
    public static void main(String[ ] args)
    {
        //local variable declarations - assign actual values below
        double miles;                   // distance in miles
        double feet;                    // distance in feet
	double kilometers;		// distance in kilometers
	double pounds;			// weight in pounds
	double kilograms;		// weight in kilograms
	double bits;			// size in bits
	double bytes;			// size in bytes
        //...finish declaring local variables here, including end of line
        //...comments doccumenting purpose of each variable


        //convert feet to miles
        feet = 6230;
        miles = feet / 5280;
        System.out.println(feet + " ft. = " + miles + " mi.");

        //convert miles to feet
        miles = 2.1;
	feet = miles * 5280;
        System.out.println(miles + " mi. = " + feet + " ft.");

        //convert miles to kilometers
        miles = 6.91;
	kilometers = miles * 1.60934;
	System.out.println(miles + " mi. = " + kilometers + " km.");

        //convert kilometers to miles
        kilometers = 0.75;
        miles = kilometers / 1.60934;
	System.out.println(kilometers + " km. = " + miles + " mi.");

	//convert pounds to kilograms
        pounds = 95.0;
        kilograms = pounds * 0.453592;
	System.out.println(pounds + " lbs. = " + kilograms + " kg.");

	//convert kilograms to pounds
        kilograms = 0.702;
	pounds = kilograms / 0.453592;
        System.out.println(kilograms + " kg. = " + pounds + " lbs.");

	//convert bits to bytes
	bits = 8;
	bytes = bits * 0.125;
	System.out.println(bits + " bits = " + bytes + " bytes.");

	//convert bytes to bits
	bytes = 64;
	bits = bytes / 0.125;
	System.out.println(bytes + " bytes = " + bits + " bits.");

	}//end of main method
}//end of class


