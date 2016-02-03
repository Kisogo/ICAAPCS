/*
Name: Ryan Stenmark
Date: 2016-01-26
Purpose: Calculate and present per-household annual CO2 emission statistics, based on household size and items recycled.
*/



import java.util.ArrayList;


class CO2FromWaste
{
    private double people;
    private boolean recyclePaper;
    private boolean recyclePlastic;
    private boolean recycleGlass;
    private boolean recycleCans;
    private double grossEmission;
    private double reduction;
    private double netEmission;
    
    
    CO2FromWaste(int p, boolean rPaper, boolean rPlastic, boolean rGlass, boolean rCans)
    {
        people = (double)p;
        recyclePaper = rPaper;
        recyclePlastic = rPlastic;
        recycleGlass = rGlass;
        recycleCans = rCans;
        grossEmission = people * 1018;
        netEmission = grossEmission;
        
        if(recyclePaper == true)
        {
            reduction = reduction + (184.0 * people);
            netEmission = netEmission - (184.0 * people);
        }
        
        if(recyclePlastic == true)
        {
            reduction = reduction + (25.6 * people);
            netEmission = netEmission - (25.6 * people);
        }
        
        if(recycleGlass == true)
        {
            reduction = reduction + (46.6 * people);
            netEmission = netEmission - (46.6 * people);
        }
        
        if(recycleCans == true)
        {
            reduction = reduction + (165.8 * people);
            netEmission = netEmission - (165.8 * people);
        }
    }
    
    public int getPeople()
    {
        return (int)this.people;
    }
    
    public boolean isRecyclingPaper()
    {
        return this.recyclePaper;
    }
    
    public boolean isRecyclingPlastic()
    {
        return this.recyclePlastic;
    }
    
    public boolean isRecyclingGlass()
    {
        return this.recycleGlass;
    }
    
    public boolean isRecyclingCans()
    {
        return this.recycleCans;
    }
    
    public double getGrossEmission()
    {
        return this.grossEmission;
    }
    
    public double getReduction()
    {
        return this.reduction;
    }
    
    public double getNetEmission()
    {
        return this.netEmission;
    }
    
    /* Why is step 9 necessary? Calculating all of those things when the object is initialized is cleaner.
        Nothing in this assessment actually requires that those methods exist. Getter methods fulfill the same role anyway.
        I opted to create getter methods getGrossEmission(), getReduction(), and getNetEmission() instead.
        */  

}

class CO2FromWasteTester
{
	public static void main(String[] args)
	{
        ArrayList<CO2FromWaste> households = new ArrayList<CO2FromWaste>();
        households.add(new CO2FromWaste(4, true, true, true, true));
        households.add(new CO2FromWaste(4, true, true, true, false));
        households.add(new CO2FromWaste(4, true, true, false, false));
        households.add(new CO2FromWaste(4, true, false, false, false));
        households.add(new CO2FromWaste(4, false, false, false, false));
        
        
        
        System.out.printf("%n%s%8s%9s%40s%36s%19s", "|", "|", "|", "|", "Pounds of CO2", "|");
        System.out.printf("%n%s%8s%9s%30s%10s%13s%8s%17s%10s%7s", "|", "|", "|", "Household Waste Recycled", "|", "Total", "|", "|", "Net", "|");
        System.out.printf("%n%s%6s%2s%7s%2s%7s%3s%9s%3s%7s%3s%6s%2s%15s%6s%13s%4s%13s%4s", "|", "Index", "|", "People", "|", "Paper", "|", "Plastic", "|", "Glass", "|", "Cans", "|", "Emission", "|", "Reduction", "|", "Emission", "|");
        System.out.println("\n|-------+--------+---------+-----------+---------+-------+--------------------+----------------+----------------|");
        
        for(CO2FromWaste h : households)
        {
            System.out.printf("%s%4d%4s%5d%4s%7b%3s%8b%4s%7b%3s%6b%2s%14.2f%7s%12.2f%5s%12.2f%5s%n", "|", households.indexOf(h), "|", h.getPeople(), "|", h.isRecyclingPaper(), "|", h.isRecyclingPlastic(), "|", h.isRecyclingGlass(), "|", h.isRecyclingCans(), "|", h.getGrossEmission(), "|", h.getReduction(), "|", h.getNetEmission(), "|");
            
        }
        
        System.out.println("|-------+--------+---------+-----------+---------+-------+--------------------+----------------+----------------|");
    }
}
