package rubiks.model;

import java.io.Serializable;

public class RubiksPiece implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int[][] colorsAndOrientation;

	public RubiksPiece(int[][] colorsAndOrientation)
	{
		this.colorsAndOrientation = colorsAndOrientation;
	}
	
	/**
	 * @return the colorsAndOrientation
	 */
	public int[][] getColorsAndOrientation()
	{
		return colorsAndOrientation;
	}
	
	public int[] getOrientation()
	{
		int[] orientation = new int[colorsAndOrientation.length];
		for (int i = 0; i < orientation.length; i++)
		{
			orientation[i] = colorsAndOrientation[i][1];
			//System.out.println(orientation[i] + " " + i);
		}
		return orientation;
	}

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
}
