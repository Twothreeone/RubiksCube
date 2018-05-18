package rubiks.controller;

import rubiks.model.RubiksCube;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

public class FileController
{
	/**
	 * Method to save a given array of RubiksCubes and save them to a file.
	 * 
	 * @param cubes
	 *            The array of RubiksCubes sizes 2 to 31.
	 */
	public static void saveCubesToFile(RubiksCube[] cubes)
	{
		File file = new File("cubes.rbk");
		try
		{
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			ObjectOutputStream objectStream;
			objectStream = new ObjectOutputStream(byteStream);
			PrintWriter writer = new PrintWriter(file);
			objectStream.writeObject(cubes);
			byte[] bytes = byteStream.toByteArray();
			String data = DatatypeConverter.printHexBinary(bytes);
			writer.write(data);
			byteStream.close();
			objectStream.close();
			writer.close();
		}
		catch (IOException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
	}

	/**
	 * Method to load an array of RubiksCubes from a file.
	 * 
	 * @return The array of RubiksCubes sizes 2 to 31.
	 */
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
			Scanner scan;
			scan = new Scanner(file);
			String data = scan.nextLine();
			byte[] bytes = DatatypeConverter.parseHexBinary(data);
			ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectStream = new ObjectInputStream(byteStream);
			cubes = (RubiksCube[]) objectStream.readObject();
			scan.close();
			byteStream.close();
			objectStream.close();
		}
		catch (IOException | ClassNotFoundException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		return cubes;
	}
}
