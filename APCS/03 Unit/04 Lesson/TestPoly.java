import java.util.ArrayList;

public class TestPoly
{
    public static void showCenter(Circle c)
    {
        System.out.println("For " + c.toString() + " " + c.center());
    }
    
    public static void main(String[] args)
    {
        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(new Circle(2, 4, 6));
        circles.add(new Cylinder(10, 15, 10, 10));
        circles.add(new Oval(25, 10, 10, 10));
        circles.add(new OvalCylinder(40, 10, 10, 20, 15));
        
        for(Circle c : circles)
        {
            showCenter(c);
        }
    }
}

