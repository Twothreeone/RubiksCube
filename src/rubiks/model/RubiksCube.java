package rubiks.model;

public class RubiksCube
{
	private RubiksPiece[][][] cube;
	
	public RubiksCube()
	{
		cube = new RubiksPiece[3][3][3];
		setupCube();
	}
	
	private void setupCube()
	{
		cube[0][1][1] = new RubiksPiece(new int[][] {{0, 0}});
		cube[1][0][1] = new RubiksPiece(new int[][] {{1, 1}});
		cube[1][1][2] = new RubiksPiece(new int[][] {{2, 2}});
		cube[1][2][1] = new RubiksPiece(new int[][] {{3, 3}});
		cube[1][1][0] = new RubiksPiece(new int[][] {{4, 4}});
		cube[2][1][1] = new RubiksPiece(new int[][] {{5, 5}});
		cube[0][0][1] = new RubiksPiece(new int[][] {{0, 0}, {1, 1}});
		cube[0][1][2] = new RubiksPiece(new int[][] {{0, 0}, {2, 2}});
		cube[0][2][1] = new RubiksPiece(new int[][] {{0, 0}, {3, 3}});
		cube[0][1][0] = new RubiksPiece(new int[][] {{0, 0}, {4, 4}});
		cube[1][0][0] = new RubiksPiece(new int[][] {{1, 1}, {4, 4}});
		cube[1][0][2] = new RubiksPiece(new int[][] {{1, 1}, {2, 2}});
		cube[1][2][2] = new RubiksPiece(new int[][] {{2, 2}, {3, 3}});
		cube[1][2][0] = new RubiksPiece(new int[][] {{3, 3}, {4, 4}});
		cube[2][0][1] = new RubiksPiece(new int[][] {{1, 1}, {5, 5}});
		cube[2][1][2] = new RubiksPiece(new int[][] {{2, 2}, {5, 5}});
		cube[2][2][1] = new RubiksPiece(new int[][] {{3, 3}, {5, 5}});
		cube[2][1][0] = new RubiksPiece(new int[][] {{4, 4}, {5, 5}});
		cube[0][0][0] = new RubiksPiece(new int[][] {{0, 0}, {1, 1}, {4, 4}});
		cube[0][0][2] = new RubiksPiece(new int[][] {{0, 0}, {1, 1}, {2, 2}});
		cube[0][2][2] = new RubiksPiece(new int[][] {{0, 0}, {2, 2}, {3, 3}});
		cube[0][2][0] = new RubiksPiece(new int[][] {{0, 0}, {3, 3}, {4, 4}});
		cube[2][0][0] = new RubiksPiece(new int[][] {{1, 1}, {4, 4}, {5, 5}});
		cube[2][0][2] = new RubiksPiece(new int[][] {{1, 1}, {2, 2}, {5, 5}});
		cube[2][2][2] = new RubiksPiece(new int[][] {{2, 2}, {3, 3}, {5, 5}});
		cube[2][2][0] = new RubiksPiece(new int[][] {{3, 3}, {4, 4}, {5, 5}});
	}

	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cube;
	}
}
