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
		this.cube = new RubiksCube();
		this.appFrame = new RubiksFrame(this);
	}
	
	public void deselect()
	{
		appFrame.getAppPanel().deselect();
	}
	
	public int[] findSelected()
	{
		return appFrame.getAppPanel().findSelected();
	}

	public void rotateLayer(int direction, int layer, int amount)
	{
		cube.rotateLayer(direction, layer, amount);
		appFrame.getAppPanel().updateColors();
	}
	
	public void rotateCube(int direction, int amount)
	{
		cube.rotateCube(direction, amount);
		appFrame.getAppPanel().updateColors();
	}
	
	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube.getCube();
	}
}
