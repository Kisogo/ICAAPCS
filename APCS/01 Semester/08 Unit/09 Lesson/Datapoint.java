
class Datapoint
{
    public int fillup;
    public int day;
    public int startMiles;
    public int endMiles;
    public int distance;
    public double gallonsUsed;
    public double mpg;
    public double price;
    public double cost;
        
    Datapoint(int fu, int d, int sM, int eM, double gU, double p)
    {
        fillup = fu;
        day = d;
        startMiles = sM;
        endMiles = eM;
        distance = eM - sM;
        gallonsUsed = gU;
        mpg = distance / gU;
        price = p;
        cost = p * gU;
    }
    //------------------------------------------------------------------------------------------
    // static double annualProjection(Array containing data, String abbreviation for data column)
    // Accepted 'column' arguments: "d" Distance, "gU" Gallons Used, "mpg" MPG, "cost" Costz
    static double annualProjection(Datapoint[] datapoints, String column)
    {
        double adjustedYear = 0.0;
        double projection = 0.0;
        
        // Find the average time between datapoints
        for(Datapoint dp : datapoints)
        {
            adjustedYear = adjustedYear + dp.day;
        }
        // Adjust the length of the simulated year to account for this
        adjustedYear = 365 / (adjustedYear / datapoints.length);
        
        
        // Distance
        if(column.equals("d"))
        {
            try
            {
                for(Datapoint dp : datapoints)
                {
                    projection = projection + dp.distance;
                
                }
            }
            finally
            {
                projection = (projection / datapoints.length) * adjustedYear;
            }
        }
        
        // Gallons used
        if(column.equals("gU"))
        {
            try
            {
                for(Datapoint dp : datapoints)
                {
                    projection = projection + dp.gallonsUsed;
                }
            }
            finally
            {
                projection = (projection / datapoints.length) * adjustedYear;
            }
        }
        
        // MPG
        if(column.equals("mpg"))
        {
            try
            {
                for(Datapoint dp : datapoints)
                {
                    projection = projection + dp.mpg;
                }
            }
            finally
            {
                projection = (projection / datapoints.length);
            }
        }
        
        // Cost
        if(column.equals("cost"))
        {
            try
            {
                for(Datapoint dp : datapoints)
                {
                    projection = projection + dp.cost;
                }
            }
            finally
            {
                projection = (projection / datapoints.length) * adjustedYear;
            }
        }
        return projection;
    }
}

class AnnualFuelUsageTester
{
    public static void main(String[] args)
    {
        Datapoint[] datapoints = {
            new Datapoint(1, 1, 127312, 127686, 16, 1.75),
            new Datapoint(2, 3, 127686, 128068, 17, 1.80),
            new Datapoint(3, 6, 128068, 128420, 16, 1.68),
            new Datapoint(4, 9, 128320, 128713, 16, 1.92),
            new Datapoint(5, 12, 128982, 129243, 16, 1.86)
        };
        
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        int totalDistance = 0;
        
        double minMPG = Double.MAX_VALUE;
        double maxMPG = Double.MIN_VALUE;
            
        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;
        
        double totalGallons = 0;
        
        double totalCost = 0.0;
        
        for(Datapoint dp : datapoints)
        {
            // Distance
            if(dp.distance <= minDistance)
            {
                minDistance = dp.distance;
            }
            
            if(dp.distance >= maxDistance)
            {
                maxDistance = dp.distance;
            }
            
            totalDistance = totalDistance + dp.distance;
            
            
            // MPG
            if(dp.mpg <= minMPG)
            {
                minMPG = dp.mpg;
            }
            
            if(dp.mpg >= maxMPG)
            {
                maxMPG = dp.mpg;
            }
            
            
            // Price
            if(dp.price <= minPrice)
            {
                minPrice = dp.price;
            }
            
            if(dp.price >= maxPrice)
            {
                maxPrice = dp.price;
            }
            
            
            // Gallons used
            totalGallons = totalGallons + dp.gallonsUsed;
            
            // Total cost
            totalCost = totalCost + dp.cost;
        }
        
        // Projections
        double distanceProjection = Datapoint.annualProjection(datapoints, "d");
        double gallonsUsedProjection = Datapoint.annualProjection(datapoints, "gU");
        double mpgProjection = Datapoint.annualProjection(datapoints, "mpg");
        double costProjection = Datapoint.annualProjection(datapoints, "cost");
        
        
        System.out.printf("%n%s%9s%15s%15s%15s%15s%10s%15s%15s%n", "Fill Up", "Days", "Start Miles", "End Miles", "Distance", "Gallons Used", "MPG", "Price", "Cost");
        for(Datapoint dp : datapoints)
        {
            System.out.printf("%5d%10d%11d%16d%17d%13.2f%14.1f%15.2f%15.2f%n", dp.fillup, dp.day, dp.startMiles, dp.endMiles, dp.distance, dp.gallonsUsed, dp.mpg, dp.price, dp.cost);
        }
        
        System.out.printf("%n%n%s%51d%28.2f%14.2f", "Minimum:", minDistance, minMPG, minPrice);
        System.out.printf("%n%s%51d%28.2f%14.2f", "Maximum:", maxDistance, maxMPG, maxPrice);
        
        
        System.out.printf("%n%n%s%53d%12.2f%45.2f", "Totals:", totalDistance, totalGallons, totalCost);
        System.out.printf("%n%s%43.0f%12.2f%14.2f%31.2f%n", "Annual Projection:", distanceProjection, gallonsUsedProjection, mpgProjection, costProjection);
        
        
    }
}
