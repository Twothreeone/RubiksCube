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

	public void rotateLayer(int[] turn)
	{
		for (int i = 0; i < turn[2]; i++)
		{
			if (turn[0] == 0)
				rotateFSB(turn[1]);
			else if (turn[0] == 1)
				rotateUED(turn[1]);
			else if (turn[0] == 2)
				rotateLMR(turn[1]);
		}
	}

	private void rotateFSB(int turn)
	{
		int[][] orientationToSet = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
		for (int i = 0; i < 8; i++)
		{
			cube[turn][rotation[i][0]][rotation[i][1]].setOrientation(fixOrientation(cube[turn][rotation[i][0]][rotation[i][1]].getOrientation(), orientationToSet));
		}
		RubiksPiece storeCorner = cube[turn][rotation[6][0]][rotation[6][1]];
		RubiksPiece storeEdge = cube[turn][rotation[7][0]][rotation[7][1]];
		for (int i = 7; i > 1; i--)
		{
			cube[turn][rotation[i][0]][rotation[i][1]] = cube[turn][rotation[i][2]][rotation[i][3]];
		}
		cube[turn][rotation[0][0]][rotation[0][1]] = storeCorner;
		cube[turn][rotation[1][0]][rotation[1][1]] = storeEdge;
	}

	private void rotateUED(int turn)
	{
		int[][] orientationToSet = { { 0, 2 }, { 2, 5 }, { 5, 4 }, { 4, 0 } };
		for (int i = 0; i < 8; i++)
		{
			cube[rotation[i][0]][turn][rotation[i][1]].setOrientation(fixOrientation(cube[rotation[i][0]][turn][rotation[i][1]].getOrientation(), orientationToSet));
		}
		RubiksPiece storeCorner = cube[rotation[6][0]][turn][rotation[6][1]];
		RubiksPiece storeEdge = cube[rotation[7][0]][turn][rotation[7][1]];
		for (int i = 7; i > 1; i--)
		{
			cube[rotation[i][0]][turn][rotation[i][1]] = cube[rotation[i][2]][turn][rotation[i][3]];
		}
		cube[rotation[0][0]][turn][rotation[0][1]] = storeCorner;
		cube[rotation[1][0]][turn][rotation[1][1]] = storeEdge;
	}

	private void rotateLMR(int turn)
	{
		//TODO: Reverse the rotation algorithm
		int[][] orientationToSet = { { 0, 3 }, { 3, 5 }, { 5, 1 }, { 1, 0 } };
		for (int i = 0; i < 8; i++)
		{
			cube[rotation[i][0]][rotation[i][1]][turn].setOrientation(fixOrientation(cube[rotation[i][0]][rotation[i][1]][turn].getOrientation(), orientationToSet));
		}
		RubiksPiece storeCorner = cube[rotation[6][0]][rotation[6][1]][turn];
		RubiksPiece storeEdge = cube[rotation[7][0]][rotation[7][1]][turn];
		for (int i = 7; i > 1; i--)
		{
			cube[rotation[i][0]][rotation[i][1]][turn] = cube[rotation[i][2]][rotation[i][3]][turn];
		}
		cube[rotation[0][0]][rotation[0][1]][turn] = storeCorner;
		cube[rotation[1][0]][rotation[1][1]][turn] = storeEdge;
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
