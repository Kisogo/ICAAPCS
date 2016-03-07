/*
Name: Ryan Stenmark
Date: 2016-03-04
Purpose: Practice knowledge of inheritance and class hierarchies.
*/


public class TestTerrain
{
	public static void main(String[] args)
	{
            Forest forest = new Forest(100, 200, 100);
            Mountain mountain = new Mountain(300, 400, 25);
            WinterMountain wMountain = new WinterMountain(500, 600, 15, 10.0);
            
            System.out.println(forest.getClass().getName() + " " + forest.terrainSize() + " and has " + forest.getNumTrees() + " trees.");
            System.out.println(mountain.getClass().getName() + " " + forest.terrainSize() + " and has " + mountain.getNumMountains() + " mountains.");
            System.out.println("Winter Mountain " + wMountain.terrainSize() + " and has temperature " + wMountain.getTemperature() + " and " + wMountain.getNumMountains() + " mountains.");
	}
}
