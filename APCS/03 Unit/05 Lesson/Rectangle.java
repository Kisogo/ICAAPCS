/**
 * rectangle Demo.
 * 
 * ©FLVS 2007
 * @author R. Enger 
 * @version 5/5/2007
 */
public class Rectangle
{
	// instance variables 
	private int length;
	private int width;

	/**
	 * Constructor for objects of class rectangle
	 */
	public Rectangle(int l, int w)
	{
		// initialise instance variables
		length = l;
		width = w;
	}

	// return the height
	public int getLength()
	{
		return length;
	}
	public int getWidth()
	{
	    return width;
	}
    
    public String toString()
    {
        return this.getClass().getName() + " - " + this.getLength() + " x " + this.getWidth();
    }

    public String equals(Rectangle b)
    {
        if(this.getLength() == b.getLength() && this.getWidth() == b.getWidth())
        {
            return this.toString() + " is same size as " + b.toString();
        }
        else
        {
            return this.toString() + " is not the same size as " + b.toString();
        }
    }
}
