public class TestNew
{
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(5, 20);
        Box equalbox = new Box(4, 4, 4);
        Box inequalbox = new Box(4, 10, 5);
        Cube cube = new Cube(4);
        
        System.out.println(rect.toString());
        System.out.println(equalbox.toString());
        System.out.println(inequalbox.toString());
        System.out.println(cube.toString());
        System.out.println(equalbox.equals(cube));
        System.out.println(inequalbox.equals(cube));
    }
}