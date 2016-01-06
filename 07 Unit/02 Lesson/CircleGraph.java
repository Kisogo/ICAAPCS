
/*
Name : Ryan Stenmark
Date : 2016-01-03
Purpose : Find points on a circle using the Pythagorean Theorem 
*/

class CircleGraph
{
	public static void main(String[] args)
	{
		double radius = 1.0;
		double y = 0.0;
		
		System.out.printf("%30s%.1f%n", "Points on a Circle of Radius ", radius);
		System.out.printf("%4s%8s%12s%8s%n", "x1", "y1", "x2", "y2");
		System.out.println("----------------------------------");
		
		
		for(double x=radius*-1; x <= radius; x=x+0.1)
		{
			y = Math.sqrt(Math.pow(radius , 2.0) - Math.pow(x , 2.0));
			System.out.printf("%+4.2f%+8.2f%+12.2f%+8.2f%n", x, y, x, -y);
		}
	}
}
