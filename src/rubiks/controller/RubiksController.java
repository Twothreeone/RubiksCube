package rubiks.controller;

import rubiks.view.RubiksFrame;
import rubiks.model.RubiksCube;
import rubiks.model.RubiksPiece;

public class RubiksController
{
	private RubiksFrame appFrame;
	private RubiksCube cube;

	/**
	 * Constructor for the RubiksController that creates a RubiksFrame.
	 */
	public RubiksController()
	{
		appFrame = new RubiksFrame(this);
	}
	
	public void loadCube(int size)
	{
		cube = new RubiksCube();
		appFrame.loadCube(size);
	}
	
	public void scramble()
	{
		for (int i = 0; i < 100; i++)
		{
			rotateLayer((int)(Math.random() * 3), (int)(Math.random() * 3), (int)(Math.random() * 3));
		}
	}
	
	public void deselect()
	{
		appFrame.getCubePanel().deselect();
	}
	
	public int[] findSelected()
	{
		return appFrame.getCubePanel().findSelected();
	}

	public void rotateLayer(int direction, int layer, int amount)
	{
		cube.rotateLayer(direction, layer, amount);
		appFrame.getCubePanel().updateColors();
	}
	
	public void rotateCube(int direction, int amount)
	{
		cube.rotateCube(direction, amount);
		appFrame.getCubePanel().updateColors();
	}
	
	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube.getCube();
	}
}
