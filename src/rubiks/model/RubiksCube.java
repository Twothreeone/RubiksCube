package rubiks.model;

public class RubiksCube
{
	private RubiksPiece[][][] cube;

	public RubiksCube()
	{
		cube = new RubiksPiece[3][3][3];
		setupCube();
		rotateFSB(new int[] {0, 1});
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
		int[][] orientationToSet = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
		RubiksPiece[][][] tempCube = cube.clone();
		//TODO: Find a better mathematical way to set all of these.
		tempCube[turn[1]][0][0] = cube[turn[1]][2][0];
		tempCube[turn[1]][0][1] = cube[turn[1]][1][0];
		tempCube[turn[1]][0][2] = cube[turn[1]][0][0];
		tempCube[turn[1]][1][2] = cube[turn[1]][0][1];
		tempCube[turn[1]][2][2] = cube[turn[1]][0][2];
		tempCube[turn[1]][2][1] = cube[turn[1]][1][2];
		tempCube[turn[1]][2][0] = cube[turn[1]][2][2];
		tempCube[turn[1]][1][0] = cube[turn[1]][2][1];
		tempCube[turn[1]][0][0].setOrientation(fixOrientation(tempCube[turn[1]][0][0].getOrientation(), orientationToSet));
		tempCube[turn[1]][0][1].setOrientation(fixOrientation(tempCube[turn[1]][0][1].getOrientation(), orientationToSet));
		tempCube[turn[1]][0][2].setOrientation(fixOrientation(tempCube[turn[1]][0][2].getOrientation(), orientationToSet));
		tempCube[turn[1]][1][2].setOrientation(fixOrientation(tempCube[turn[1]][1][2].getOrientation(), orientationToSet));
		tempCube[turn[1]][2][2].setOrientation(fixOrientation(tempCube[turn[1]][2][2].getOrientation(), orientationToSet));
		tempCube[turn[1]][2][1].setOrientation(fixOrientation(tempCube[turn[1]][2][1].getOrientation(), orientationToSet));
		tempCube[turn[1]][2][0].setOrientation(fixOrientation(tempCube[turn[1]][2][0].getOrientation(), orientationToSet));
		tempCube[turn[1]][1][0].setOrientation(fixOrientation(tempCube[turn[1]][1][0].getOrientation(), orientationToSet));
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
			for (int j = 0; j < orientationToSet.length; j++)
			{
				if (orientation[i] == orientationToSet[j][0])
				{
					orientation[i] = orientationToSet[j][1];
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
