package rubiks.model;

public class RubiksCube
{
	private RubiksPiece[][][] cube;
	private final int[][] rotation = { { 0, 0, 2, 0 }, { 0, 1, 1, 0 }, { 0, 2, 0, 0 }, { 1, 2, 0, 1 }, { 2, 2, 0, 2 }, { 2, 1, 1, 2 }, { 2, 0, 2, 2 }, { 1, 0, 2, 1 } };

	public RubiksCube()
	{
		cube = new RubiksPiece[3][3][3];
		setupCube();
	}

	private void setupCube()
	{
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
		for (int i = 0; i < 8; i++)
		{
			cube[layer][rotation[i][0]][rotation[i][1]].setOrientation(fixOrientation(cube[layer][rotation[i][0]][rotation[i][1]].getOrientation(), orientationToSet));
		}
		RubiksPiece storeCorner = cube[layer][rotation[6][0]][rotation[6][1]];
		RubiksPiece storeEdge = cube[layer][rotation[7][0]][rotation[7][1]];
		for (int i = 7; i > 1; i--)
		{
			cube[layer][rotation[i][0]][rotation[i][1]] = cube[layer][rotation[i][2]][rotation[i][3]];
		}
		cube[layer][rotation[0][0]][rotation[0][1]] = storeCorner;
		cube[layer][rotation[1][0]][rotation[1][1]] = storeEdge;
	}

	private void rotateUED(int layer)
	{
		int[][] orientationToSet = { { 0, 2 }, { 2, 5 }, { 5, 4 }, { 4, 0 } };
		for (int i = 0; i < 8; i++)
		{
			cube[rotation[i][0]][layer][rotation[i][1]].setOrientation(fixOrientation(cube[rotation[i][0]][layer][rotation[i][1]].getOrientation(), orientationToSet));
		}
		RubiksPiece storeCorner = cube[rotation[6][0]][layer][rotation[6][1]];
		RubiksPiece storeEdge = cube[rotation[7][0]][layer][rotation[7][1]];
		for (int i = 7; i > 1; i--)
		{
			cube[rotation[i][0]][layer][rotation[i][1]] = cube[rotation[i][2]][layer][rotation[i][3]];
		}
		cube[rotation[0][0]][layer][rotation[0][1]] = storeCorner;
		cube[rotation[1][0]][layer][rotation[1][1]] = storeEdge;
	}

	private void rotateLMR(int layer)
	{
		for (int i = 0; i < 3; i++)
		{
			int[][] orientationToSet = { { 0, 3 }, { 3, 5 }, { 5, 1 }, { 1, 0 } };
			for (int j = 0; j < 8; j++)
			{
				cube[rotation[j][0]][rotation[j][1]][layer].setOrientation(fixOrientation(cube[rotation[j][0]][rotation[j][1]][layer].getOrientation(), orientationToSet));
			}
			RubiksPiece storeCorner = cube[rotation[6][0]][rotation[6][1]][layer];
			RubiksPiece storeEdge = cube[rotation[7][0]][rotation[7][1]][layer];
			for (int j = 7; j > 1; j--)
			{
				cube[rotation[j][0]][rotation[j][1]][layer] = cube[rotation[j][2]][rotation[j][3]][layer];
			}
			cube[rotation[0][0]][rotation[0][1]][layer] = storeCorner;
			cube[rotation[1][0]][rotation[1][1]][layer] = storeEdge;
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
