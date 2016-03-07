public class Forest extends Terrain
{
    private int numTrees;
    
    public Forest(int l, int w, int nTrees)
    {
        super(l, w);
        numTrees = nTrees;
    }
    
    public int getNumTrees()
    {
        return numTrees;
    }
}
