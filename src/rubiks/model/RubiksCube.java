package rubiks.model;

public class RubiksCube
{
	private RubiksPiece[][][] cube;
	private final int[][] rotation = { { 0, 0, 2, 0 }, { 0, 1, 1, 0 }, { 0, 2, 0, 0 }, { 1, 2, 0, 1 }, { 2, 2, 0, 2 }, { 2, 1, 1, 2 }, { 2, 0, 2, 2 }, { 1, 0, 2, 1 } };

	public RubiksCube()
	{
		cube = new RubiksPiece[3][3][3];
		setupCube();
		rotateFSB(new int[] { 0, 0 });
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
		if (turn[0] == 0)
			rotateFSB(turn);
		else if (turn[0] == 1)
			rotateUED(turn);
		else if (turn[0] == 2)
			rotateLMR(turn);
	}

	private void rotateFSB(int[] turn)
	{
		int[][] orientationToSet = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
		RubiksPiece[][][] tempCube = cube.clone();
		for (int i = 0; i < rotation.length; i++)
		{
			tempCube[turn[1]][rotation[i][0]][rotation[i][1]] = cube[turn[1]][rotation[i][2]][rotation[i][3]];
			tempCube[turn[1]][rotation[i][0]][rotation[i][1]].setOrientation(fixOrientation(tempCube[turn[1]][rotation[i][0]][rotation[i][1]].getOrientation(), orientationToSet));
			System.out.println("\n");
			tempCube[turn[1]][rotation[i][0]][rotation[i][1]].getOrientation();
			System.out.println("\n");
		}
		cube = tempCube.clone();
	}

	private void rotateUED(int[] turn)
	{

	}

	private void rotateLMR(int[] turn)
	{

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
