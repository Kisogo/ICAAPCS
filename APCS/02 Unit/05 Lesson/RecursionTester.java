class RecursionMethods
{
    RecursionMethods()
    {
    }
    
    public int piecewiseF1(int x)
    {
        if(x <= 10)
        {
            System.out.println("-7, base case");
            return -7;
        }
        else
        {
            System.out.println(x);
            return piecewiseF1(x-4)+2;
        }
    }
    
    public int piecewiseF2(int x)
    {
        if(x <= 25)
        {
            System.out.println("20, base case");
            return 20;
        }
        else
        {
            System.out.println(x);
            return piecewiseF2(x/12+5)-3;
        }
    }
    
    public int piecewiseF3(int x)
    {
        if(x > 20)
        {
            System.out.println("-100, base case");
            return -100;
        }
        else
        {
            System.out.println(x);
            return piecewiseF3(x*2)-4;
        }
    }
}



class RecursionTester
{
	public static void main(String[] args)
	{
       RecursionMethods r = new RecursionMethods();
        
        System.out.printf("%s%n", "Problem 1:");
        r.piecewiseF1(25);
        System.out.printf("%n%s%n", "Problem 2:");
        r.piecewiseF2(30);
        System.out.printf("%n%s%n", "Problem 4:");
        r.piecewiseF3(500);

	}
}
