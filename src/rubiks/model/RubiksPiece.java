package rubiks.model;

public class RubiksPiece
{
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

	/**
	 * @param colorsAndOrientation the colorsAndOrientation to set
	 */
	public void setColorsAndOrientation(int[][] colorsAndOrientation)
	{
		this.colorsAndOrientation = colorsAndOrientation;
	}
}
