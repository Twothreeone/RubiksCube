package rubiks.model;

import java.io.Serializable;

public class RubiksPiece implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int[][] colorsAndOrientation;

	/**
	 * Creates a RubiksPiece. It holds a 2d array specifying its colors and those colors orientation.
	 * 
	 * @param colorsAndOrientation
	 *            The piece's colors and their orientation.
	 */
	public RubiksPiece(int[][] colorsAndOrientation)
	{
		this.colorsAndOrientation = colorsAndOrientation;
	}

	/**
	 * @return An array of just the orientation.
	 */
	public int[] getOrientation()
	{
		int[] orientation = new int[colorsAndOrientation.length];
		for (int i = 0; i < orientation.length; i++)
		{
			orientation[i] = colorsAndOrientation[i][1];
		}
		return orientation;
	}

	/**
	 * @param orientation
	 *            The set of orientations to set.
	 */
	public void setOrientation(int[] orientation)
	{
		if (orientation.length == colorsAndOrientation.length)
		{
			for (int i = 0; i < orientation.length; i++)
			{
				colorsAndOrientation[i][1] = orientation[i];
			}
		}
	}

	/**
	 * @return the colorsAndOrientation
	 */
	public int[][] getColorsAndOrientation()
	{
		return colorsAndOrientation;
	}
}
