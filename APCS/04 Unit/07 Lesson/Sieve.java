public class Sieve
{   
    
    public static void calculate(int upper)
    {
        int upperSqrt = (int)Math.sqrt(upper);
        boolean isComposite[] = new boolean[upper + 1];
        
        for(int m = 2; m <= upperSqrt; m++)
        {
            if(!isComposite[m])
            {
                System.out.print(m + " ");
                
                for( int k = m * m; k <= upper; k += m)
                {
                    isComposite[k] = true;
                }
            }
        }
        
        for(int m = upperSqrt; m <= upper; m++)
        {
            if(!isComposite[m])
            {
                System.out.print(m + " ");
            }
        }
        System.out.println("");
    }
}
