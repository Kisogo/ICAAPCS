import java.util.ArrayList;

class CO2FromElectricity
{

	private double annualCO2;
	private ArrayList<Double> usageData = new ArrayList<>();
    private ArrayList<Double> priceData = new ArrayList<>();
    private double avgBill;
    private double avgPrice;

    CO2FromElectricity()
	{
        usageData.add(911.0);
        usageData.add(914.3);
        usageData.add(906.2);
        usageData.add(912.7);
        usageData.add(907.2);
        
        priceData.add(114.0);
        priceData.add(116.2);
        priceData.add(112.2);
        priceData.add(114.7);
        priceData.add(112.8);
        avgBill = calcAverageBill(priceData);
        avgPrice = calcAveragePrice(priceData, usageData);
        annualCO2 = calcElectricityCO2(avgBill, avgPrice);
	}
    

	public double calcAverageBill(ArrayList<Double> list)
	{
        double sum = 0;
		for(double i : list)
		{
            sum = sum + i;
		}

		return sum / list.size();
	}
    
    
    public double calcAveragePrice(ArrayList<Double> priceData, ArrayList<Double> usageData)
    {
        double j = 0;
        for(int i=0; i<usageData.size(); i++)
        {
            j = j + priceData.get(i) / usageData.get(i);
        }
        
        return j / priceData.size();
    }
    

	public double calcElectricityCO2(double avgBill, double avgPrice)
	{
		return (avgBill / avgPrice) * 1.37 * 12;
	}
    
    public double getAvgBill()
    {
        return this.avgBill;
    }
    
    public double getAvgPrice()
    {
        return this.avgPrice;
    }
    
    public double getAnnualCO2()
    {
        return this.annualCO2;
    }
    

}

class CO2FromElectricityTester
{
	public static void main(String[] args)
	{
        CO2FromElectricity household = new CO2FromElectricity();
        
        System.out.printf("%n%s%.2f", "Average Monthly Electricity Bill: ", household.getAvgBill());
        System.out.printf("%n%s%.2f", "Average Monthly Electricity Price: ", household.getAvgPrice());
        System.out.printf("%n%s%.1f%1s%n", "Annual CO2 Emissions from Electricity Usage: ", household.getAnnualCO2(), " pounds");
        
	}
}
