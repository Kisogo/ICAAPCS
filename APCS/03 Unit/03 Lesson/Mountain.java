public class Mountain extends Terrain
{
    private int numMountains;
    
    public Mountain(int l, int w, int mts)
    {
        super(l, w);
        numMountains = mts;
    }
    
    public int getNumMountains()
    {
        return numMountains;
    }
}
