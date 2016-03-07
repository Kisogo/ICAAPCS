public class CubeTester
{
	public static void main(String[] args)
	{
        Cube Cube01 = new Cube(2);
        Cube Cube02 = new Cube(4);
        
        System.out.println("Cube01's dimensions are " + Cube01.getLength() + ", " + Cube01.getWidth() + ", " + Cube01.getHeight());
	    System.out.println("Cube02's dimensions are " + Cube02.getLength() + ", " + Cube02.getWidth() + ", " + Cube02.getHeight());
    }
}
