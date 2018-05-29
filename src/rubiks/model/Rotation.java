package rubiks.model;

public class Rotation
{
	private boolean cubeRotation;
	private int direction, layer, amount;
	
	public Rotation(boolean cubeRotation, int direction, int layer, int amount)
	{
		this.cubeRotation = cubeRotation;
		this.direction = direction;
		this.layer = layer;
		this.amount = amount;
	}

	/**
	 * @return the cubeRotation
	 */
	public boolean isCubeRotation()
	{
		return cubeRotation;
	}

	/**
	 * @return the direction
	 */
	public int getDirection()
	{
		return direction;
	}

	/**
	 * @return the layer
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * @return the amount
	 */
	public int getAmount()
	{
		return amount;
	}
}
