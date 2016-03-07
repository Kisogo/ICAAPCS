public class TestTriangles
{
	public static void main(String[] args)
	{
        Triangle tri = new Triangle(4.0, 5.0, 6.0);
        Equilateral equil = new Equilateral(5.0);
        IsocelesRight isoright = new IsocelesRight(1.5);
        
        System.out.println("Triangle has sides A = " + tri.getSideA() + ", B = " + tri.getSideB() + ", C = " + tri.getSideC());
        System.out.println("Equilateral Triangle has sides A = " + equil.getSideA() + ", B = " + equil.getSideB() + ", C = " + equil.getSideC());
        System.out.println("Isoceles Right Triangle has sides A = " + isoright.getSideA() + ", B = " + isoright.getSideB() + ", C = " + isoright.getSideC());
	}
}
