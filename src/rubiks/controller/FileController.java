package rubiks.controller;

import rubiks.model.RubiksCube;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileController
{
	public static void saveCubesToFile(RubiksCube[] cubes)
	{
		File file = new File("cubes.rbk");
		try
		{
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(cubes);
			objectStream.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		catch (IOException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
	}
	
	public static RubiksCube[] readCubesFromFile()
	{
		RubiksCube[] cubes = new RubiksCube[32];
		cubes[0] = null;
		cubes[1] = null;
		for (int i = 2; i < 32; i++)
		{
			cubes[i] = new RubiksCube(i);
		}
		File file = new File("cubes.rbk");
		try
		{
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			cubes = (RubiksCube[]) objectStream.readObject();
			objectStream.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		catch (IOException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		catch (ClassNotFoundException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		return cubes;
	}
}
