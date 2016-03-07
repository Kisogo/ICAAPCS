
/**
 * box demo.
 * 
 * ©FLVS 2007
 * @author R. Enger 
 * @version 5/5/2007
 */
public class Box extends Rectangle
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class box
	 */
	public Box(int l, int w, int h)
	{
		// call superclass
		super(l, w);
	    // initialise instance variables
		height = h;
	}

	// return the height
	public int getHeight()
	{
		return height;
	}
    
    public String toString()
    {
        return this.getClass().getName() + " - " + this.getLength() + " x " + this.getWidth() + " x " + this.getHeight();
    }
    
    public String equals(Box r1, Box r2)
    {
        if(r1.getLength() == r2.getLength() && r1.getWidth() == r2.getWidth() && r1.getHeight() == r2.getHeight())
        {
            return r1.toString() + " is same size as " + r2.toString();
        }
        else
        {
            return r1.toString() + " is not the same size as " + r2.toString();
        }
    }
}
