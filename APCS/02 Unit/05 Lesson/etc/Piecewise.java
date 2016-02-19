class Piecewise
{
	public static void main(String[] args)
	{
        int x = 25;
        
        PiecewiseMethods.function(x);
	}
}


class PiecewiseMethods
{      
    public static int function(int x)
    {
        if(x <= 10)
        {
            System.out.println(x);
            return -5;
        }
        else
        {
            System.out.println(x);
            return function(x-3) + 2;
        }
          
    }
}
