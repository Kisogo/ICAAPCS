
/**
 * This program demonstrates how to format strings with the printf() method.
 * Use the program in conjunction with the lesson for Week 5 Day 1.
 * 
 * After reading each section of the lesson on formatting strings, remove the
 * comments for the appropriate section of code, then run it to see printf()
 * in action.
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 04/29/07
 */
public class printfex
{
    public static void main(String [] args)
    {
        String tallahassee = "Tallahassee";
        String florida = "Florida";
        
        System.out.println(".........1.........2.........3.........4.........5");
        System.out.printf("%s", tallahassee); 
        System.out.println();
        System.out.printf("%S", tallahassee);
        System.out.println();
        System.out.println();
    
        //Don't forget to uncomment the following sections as you work through 
        //the lesson.
        
        
        System.out.println(".........1.........2.........3.........4.........5");
        System.out.printf("%15s\n", tallahassee);
        System.out.printf("%-15s\n", tallahassee);
        System.out.println();
        
    
        
        System.out.println(".........1.........2.........3.........4.........5");
        System.out.printf("%-15s",tallahassee);
        System.out.printf("%-7s\n",florida);
        System.out.println();
        
        
        
        System.out.println(".........1.........2.........3.........4.........5");
        System.out.printf("%-15s%-7s\n", tallahassee, florida);
        System.out.println();
        
       
        
        System.out.println(".........1.........2.........3.........4.........5");
        System.out.printf("%-15s%-7s\n", tallahassee, florida);        
        System.out.println();
        
       
        
        System.out.printf("City: %-15s State: %-7s\n", tallahassee, florida);
        System.out.printf("%s is the capitol of %s.\n", tallahassee, florida);
        System.out.printf("Florida State University is located in %s, %s.\n", tallahassee, florida);
        System.out.printf("The population of %s, %s is over 150,000.\n", tallahassee, florida);
        
    }
}
