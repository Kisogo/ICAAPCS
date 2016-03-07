public class WinterMountain extends Mountain
{
    private double temperature;
    
    public WinterMountain(int l, int w, int mts, double tmpr)
    {
        super(l, w, mts);
        temperature = tmpr;
    }
    
    public double getTemperature()
    {
        return temperature;
    }
}
