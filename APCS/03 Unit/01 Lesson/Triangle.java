public class Triangle
{
        /* Instance variables */
        private double sideA;
        private double sideB;
        private double sideC;
        
        /* Constructor */
        public Triangle(double a, double b, double c)
        {
            sideA = a;
            sideB = b;
            sideC = c;
        }
        
        /* Methods */
        
        /* Get side lengths */
        public double getSideA()
        {
            return sideA;
        }
        
        public double getSideB()
        {
            return sideB;
        }
        
        public double getSideC()
        {
            return sideC;
        }
}
