
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * ©FLVS 2007
 * @author Bill Jordan
 * @version 01/19/07
 */
public class CalculationsV4
{
    public static void main(String[ ] args)
    {
	int iNum1 = 4;
	int iNum2 = 8;

        // Addition
        System.out.println("Addition");
        System.out.println(iNum1 + " plus " + iNum2 + " = " + (iNum1 + iNum2));
	//System.out.println(iNum1 + iNum2);
        System.out.println(23.51 + 8.9325+"\n");
        //System.out.println();

	int iNum3 = 9;
	int iNum4 = 33;

        // Subtraction
        System.out.println("Subtraction");
	System.out.println(iNum3 + " minus " + iNum4 + " = " + (iNum3 - iNum4));
        //System.out.println(iNum3 - iNum4);
        System.out.println(98.6 - 47.0038+"\n");
        //System.out.println();

	int iNum5 = 15;
	int iNum6 = 3;
	int iNum7 = 201;

        // Multiplication
        System.out.println("Multiplication");
	System.out.println(iNum5 + " times " + iNum6 + " times " + iNum7 + " = " + (iNum5 * iNum6 * iNum7));
        //System.out.println(iNum5 * iNum6 * iNum7);
        System.out.println(3.14 * 5.0 * 5.0+"\n");
        //System.out.println();

	int iNum8 = 48;
	int iNum9 = 8;

        // Division
        System.out.println("Division");
	System.out.println(iNum8 + " divided by " + iNum9 + " = " + (iNum8 / iNum9));
        //System.out.println(iNum8 / iNum9);
        System.out.println(212.0 / 32.0+"\n");
        //System.out.println();

	int iNum10 = 23;
	int iNum11 = 15;

        // Modulus operator
        System.out.println("Modulus");
	System.out.println(iNum10 + " modulus " + iNum11 + " = " + (iNum10 % iNum11));
        //System.out.println(iNum10 % iNum11);
        System.out.println(3298.7 % 243.1+"\n");
        //System.out.println();

	//L3 P1
	System.out.println("Lesson 3 Part 1");
	System.out.println(15 / 2.5 * -2 + 10 / 5);
	System.out.println(234 - (234 / 6 % 12) + 3);
	System.out.println((46.2 / 11) - 3 + 24 % (17 - 2 * 3));
	System.out.println(480 / 10 / 12 + 200 * 0.5 - 20 % 8);

               
    } // end of main method
} // end of class

