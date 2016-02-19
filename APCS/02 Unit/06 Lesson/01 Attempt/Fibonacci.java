import java.util.Scanner;
import java.util.InputMismatchException;

class HelperMethods
{
    HelperMethods()
    {
    }
    
    Scanner in = new Scanner(System.in);
    private int i = 1;
    
    public int errchecker(int x)
    {
        try
        {
            if(x <= 1)
            {
                System.err.println("Usage: java Fibonacci [n number > 1]\n: ");
                return errchecker(in.nextInt());    
            }
            else
            {
                return x;
            }
        }
        catch(InputMismatchException e)
        {
            System.err.println("Usage: java Fibonacci [n number > 1]\n: ");
            return errchecker(in.nextInt()); 
        }
    }
    
    
    public int fn(int n)
    {
        if(i < n+1)
        {
            i=+1;       
            return fn(i-1) + fn(i-2);
        }
        else
        {
            return 0;
        }
    }
}

class Fibonacci
{
    public static void main(String[] args)
    {
        HelperMethods f = new HelperMethods();
        try
        {
            System.out.println(f.fn(f.errchecker(Integer.parseInt(args[0]))));    
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Usage: java Fibonacci [n number > 1]\n: ");
            return errchecker(in.nextInt());
        }
    }
}