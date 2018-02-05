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
		appFrame.requestFocus();
	}
	
	public void menu()
	{
		appFrame.menu();
		appFrame.requestFocus();
	}
	
	public void scramble()
	{
		for (int i = 0; i < 10000; i++)
		{
			cube.rotateLayer((int)(Math.random() * 3), (int)(Math.random() * 3), (int)(Math.random() * 3));
			appFrame.getCubePanel().updateColors();
		}
		appFrame.getCubePanel().getCubeInfoPanel().startGame();
		appFrame.requestFocus();
	}
	
	public void solve(int size)
	{
		cube = new RubiksCube();
		appFrame.getCubePanel().updateColors();
		appFrame.getCubePanel().getCubeInfoPanel().quitGame();
		appFrame.requestFocus();
	}
	
	public void deselect()
	{
		appFrame.getCubePanel().deselect();
		appFrame.requestFocus();
	}
	
	public int[] findSelected()
	{
		return appFrame.getCubePanel().findSelected();
	}

	public void rotateLayer(int direction, int layer, int amount)
	{
		if (appFrame.getCubePanel().getCubeInfoPanel().isGameStart())
		{
			appFrame.getCubePanel().getCubeInfoPanel().incrementMoves();
		}
		cube.rotateLayer(direction, layer, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}
	
	public void rotateCube(int direction, int amount)
	{
		cube.rotateCube(direction, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}
	
	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube.getCube();
	}
}
