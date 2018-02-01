package rubiks.model;

public class RubiksCube
{
	private RubiksPiece[][][] cube;
	private final int[][] rotation = { { 0, 0, 2, 0 }, { 0, 1, 1, 0 }, { 0, 2, 0, 0 }, { 1, 2, 0, 1 }, { 2, 2, 0, 2 }, { 2, 1, 1, 2 }, { 2, 0, 2, 2 }, { 1, 0, 2, 1 }, { 1, 1, 1, 1 } };

	public RubiksCube()
	{
		cube = new RubiksPiece[3][3][3];
		setupCube();
	}

	private void setupCube()
	{
		cube[1][1][1] = new RubiksPiece(new int[0][0]);
		cube[0][1][1] = new RubiksPiece(new int[][] { { 0, 0 } });
		cube[1][0][1] = new RubiksPiece(new int[][] { { 1, 1 } });
		cube[1][1][2] = new RubiksPiece(new int[][] { { 2, 2 } });
		cube[1][2][1] = new RubiksPiece(new int[][] { { 3, 3 } });
		cube[1][1][0] = new RubiksPiece(new int[][] { { 4, 4 } });
		cube[2][1][1] = new RubiksPiece(new int[][] { { 5, 5 } });
		cube[0][0][1] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 } });
		cube[0][1][2] = new RubiksPiece(new int[][] { { 0, 0 }, { 2, 2 } });
		cube[0][2][1] = new RubiksPiece(new int[][] { { 0, 0 }, { 3, 3 } });
		cube[0][1][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 4, 4 } });
		cube[1][0][0] = new RubiksPiece(new int[][] { { 1, 1 }, { 4, 4 } });
		cube[1][0][2] = new RubiksPiece(new int[][] { { 1, 1 }, { 2, 2 } });
		cube[1][2][2] = new RubiksPiece(new int[][] { { 2, 2 }, { 3, 3 } });
		cube[1][2][0] = new RubiksPiece(new int[][] { { 3, 3 }, { 4, 4 } });
		cube[2][0][1] = new RubiksPiece(new int[][] { { 1, 1 }, { 5, 5 } });
		cube[2][1][2] = new RubiksPiece(new int[][] { { 2, 2 }, { 5, 5 } });
		cube[2][2][1] = new RubiksPiece(new int[][] { { 3, 3 }, { 5, 5 } });
		cube[2][1][0] = new RubiksPiece(new int[][] { { 4, 4 }, { 5, 5 } });
		cube[0][0][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 }, { 4, 4 } });
		cube[0][0][2] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 } });
		cube[0][2][2] = new RubiksPiece(new int[][] { { 0, 0 }, { 2, 2 }, { 3, 3 } });
		cube[0][2][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 3, 3 }, { 4, 4 } });
		cube[2][0][0] = new RubiksPiece(new int[][] { { 1, 1 }, { 4, 4 }, { 5, 5 } });
		cube[2][0][2] = new RubiksPiece(new int[][] { { 1, 1 }, { 2, 2 }, { 5, 5 } });
		cube[2][2][2] = new RubiksPiece(new int[][] { { 2, 2 }, { 3, 3 }, { 5, 5 } });
		cube[2][2][0] = new RubiksPiece(new int[][] { { 3, 3 }, { 4, 4 }, { 5, 5 } });
	}

	public void rotateLayer(int direction, int layer, int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			if (direction == 0)
				rotateFSB(layer);
			else if (direction == 1)
				rotateUED(layer);
			else if (direction == 2)
				rotateLMR(layer);
		}
	}

	public void rotateCube(int direction, int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			if (direction == 0)
			{
				for (int j = 0; j < 3; j++)
				{
					rotateFSB(j);
				}
			}
			else if (direction == 1)
			{
				for (int j = 0; j < 3; j++)
				{
					rotateUED(j);
				}
			}
			else if (direction == 2)
			{
				for (int j = 0; j < 3; j++)
				{
					rotateLMR(j);
				}
			}
		}
	}

	private void rotateFSB(int layer)
	{
		int[][] orientationToSet = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
		RubiksPiece[] tempLayer = new RubiksPiece[rotation.length];
		for (int i = 0; i < rotation.length; i++)
		{
			cube[layer][rotation[i][0]][rotation[i][1]].setOrientation(fixOrientation(cube[layer][rotation[i][0]][rotation[i][1]].getOrientation(), orientationToSet));
			tempLayer[i] = cube[layer][rotation[i][2]][rotation[i][3]];
		}
		for (int i = 0; i < rotation.length; i++)
		{
			cube[layer][rotation[i][0]][rotation[i][1]] = tempLayer[i];
		}
	}

	private void rotateUED(int layer)
	{
		int[][] orientationToSet = { { 0, 2 }, { 2, 5 }, { 5, 4 }, { 4, 0 } };
		RubiksPiece[] tempLayer = new RubiksPiece[rotation.length];
		for (int i = 0; i < rotation.length; i++)
		{
			cube[rotation[i][0]][layer][rotation[i][1]].setOrientation(fixOrientation(cube[rotation[i][0]][layer][rotation[i][1]].getOrientation(), orientationToSet));
			tempLayer[i] = cube[rotation[i][2]][layer][rotation[i][3]];
		}
		for (int i = 0; i < rotation.length; i++)
		{
			cube[rotation[i][0]][layer][rotation[i][1]] = tempLayer[i];
		}
	}

	private void rotateLMR(int layer)
	{
		int[][] orientationToSet = { { 0, 1 }, { 1, 5 }, { 5, 3 }, { 3, 0 } };
		RubiksPiece[] tempLayer = new RubiksPiece[rotation.length];
		for (int i = 0; i < rotation.length; i++)
		{
			cube[rotation[i][1]][rotation[i][0]][layer].setOrientation(fixOrientation(cube[rotation[i][1]][rotation[i][0]][layer].getOrientation(), orientationToSet));
			tempLayer[i] = cube[rotation[i][3]][rotation[i][2]][layer];
		}
		for (int i = 0; i < rotation.length; i++)
		{
			cube[rotation[i][1]][rotation[i][0]][layer] = tempLayer[i];
		}
	}

	private int[] fixOrientation(int[] orientation, int[][] orientationToSet)
	{
		for (int i = 0; i < orientation.length; i++)
		{
			for (int[] orient : orientationToSet)
			{
				if (orientation[i] == orient[0])
				{
					orientation[i] = orient[1];
					break;
				}
			}
		}
		return orientation;
	}

	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube;
	}
}
