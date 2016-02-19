import java.util.Scanner;

class Shell
{
    
    private Scanner in = new Scanner(System.in);
    public String help = new String("[q]uit     [h]elp\n: 5\n\t1\n\t1\n\t2\n\t3\n\t5");
    
    Shell()
    {
        
    }
    
    private int fib(int x)
    {
        if(x <= 1)
        {
            return x;
        }
        else
        {
            return fib(x-2) + fib(x-1);
        }
    }
    
    public boolean tryParse(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    public void newLine()
    {
        System.out.print("\n: ");
        String input = new String(in.next());
        int i;
        
        if(tryParse(input)) // Input is a number
        {
            for(i=1; i <= Integer.parseInt(input); i++)
            {
               System.out.printf("%6d%n", fib(i));
            }
            newLine();
        }
        else    // Input is not a number, maybe it's a command
        {
            // help 'command'
            if(input.equals("h") || input.equals("help"))
            {
                System.out.println(help);
                newLine();
            }
            
            // quit 'command'
            if(input.equals("q") || input.equals("quit"))
            {
                System.exit(0);
            }    

            newLine();  // Input wasn't anything recognizable.
        }
    }
}

class Fibonacci
{
	public static void main(String[] args)
	{
        Shell s = new Shell();
        System.out.print(s.help);
        s.newLine();

	}
}
