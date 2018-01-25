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

	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube.getCube();
	}
}
