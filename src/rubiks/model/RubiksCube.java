package rubiks.model;

import java.io.Serializable;

public class RubiksCube implements Serializable
{
	private RubiksPiece[][][] cube;
	private int size;
	private String time;
	private String timePB;
	private String moves;
	private String movesPB;
	private int deciseconds;
	private int seconds;
	private int minutes;
	private int hours;
	private int moveCount;
	private boolean gameStart;
	private int[][] rotation = { { 0, 0, 2, 0 }, { 0, 1, 1, 0 }, { 0, 2, 0, 0 }, { 1, 2, 0, 1 }, { 2, 2, 0, 2 }, { 2, 1, 1, 2 }, { 2, 0, 2, 2 }, { 1, 0, 2, 1 }, { 1, 1, 1, 1 } };

	public RubiksCube(int size)
	{
		this.size = size;
		cube = new RubiksPiece[size][size][size];
		//rotation = new int[size * size][4];
		time = "00:00:00.0";
		timePB = "Personal Best: 99:59:59.9";
		moves = "Moves: 000000";
		movesPB = "Personal Best:     999999";
		deciseconds = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		moveCount = 0;
		gameStart = false;
		setupCube();
		//setupRotation();
	}

	private void setupCube()
	{
		for (int plane = 1; plane < size - 1; plane++)
		{
			for (int row = 1; row < size - 1; row++)
			{
				for (int col = 1; col < size - 1; col++)
				{
					cube[plane][row][col] = new RubiksPiece(new int[0][0]);
				}
			}
		}
		for (int row = 1; row < size - 1; row++)
		{
			for (int col = 1; col < size - 1; col++)
			{
				cube[0][row][col] = new RubiksPiece(new int[][] { { 0, 0 } });
			}
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			for (int col = 1; col < size - 1; col++)
			{
				cube[plane][0][col] = new RubiksPiece(new int[][] { { 1, 1 } });
			}
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			for (int row = 1; row < size - 1; row++)
			{
				cube[plane][row][size - 1] = new RubiksPiece(new int[][] { { 2, 2 } });
			}
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			for (int col = 1; col < size - 1; col++)
			{
				cube[plane][size - 1][col] = new RubiksPiece(new int[][] { { 3, 3 } });
			}
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			for (int row = 1; row < size - 1; row++)
			{
				cube[plane][row][0] = new RubiksPiece(new int[][] { { 4, 4 } });
			}
		}
		for (int row = 1; row < size - 1; row++)
		{
			for (int col = 1; col < size - 1; col++)
			{
				cube[size - 1][row][col] = new RubiksPiece(new int[][] { { 5, 5 } });
			}
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			cube[plane][0][0] = new RubiksPiece(new int[][] { { 1, 1 }, { 4, 4 } });
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			cube[plane][0][size - 1] = new RubiksPiece(new int[][] { { 1, 1 }, { 2, 2 } });
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			cube[plane][size - 1][0] = new RubiksPiece(new int[][] { { 3, 3 }, { 4, 4 } });
		}
		for (int plane = 1; plane < size - 1; plane++)
		{
			cube[plane][size - 1][size - 1] = new RubiksPiece(new int[][] { { 2, 2 }, { 3, 3 } });
		}
		for (int row = 1; row < size - 1; row++)
		{
			cube[0][row][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 4, 4 } });
		}
		for (int row = 1; row < size - 1; row++)
		{
			cube[0][row][size - 1] = new RubiksPiece(new int[][] { { 0, 0 }, { 2, 2 } });
		}
		for (int row = 1; row < size - 1; row++)
		{
			cube[size - 1][row][0] = new RubiksPiece(new int[][] { { 4, 4 }, { 5, 5 } });
		}
		for (int row = 1; row < size - 1; row++)
		{
			cube[size - 1][row][size - 1] = new RubiksPiece(new int[][] { { 2, 2 }, { 5, 5 } });
		}
		for (int col = 1; col < size - 1; col++)
		{
			cube[0][0][col] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 } });
		}
		for (int col = 1; col < size - 1; col++)
		{
			cube[0][size - 1][col] = new RubiksPiece(new int[][] { { 0, 0 }, { 3, 3 } });
		}
		for (int col = 1; col < size - 1; col++)
		{
			cube[size - 1][0][col] = new RubiksPiece(new int[][] { { 1, 1 }, { 5, 5 } });
		}
		for (int col = 1; col < size - 1; col++)
		{
			cube[size - 1][size - 1][1] = new RubiksPiece(new int[][] { { 3, 3 }, { 5, 5 } });
		}
		cube[0][0][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 }, { 4, 4 } });
		cube[0][0][size - 1] = new RubiksPiece(new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 } });
		cube[0][size - 1][0] = new RubiksPiece(new int[][] { { 0, 0 }, { 3, 3 }, { 4, 4 } });
		cube[size - 1][0][0] = new RubiksPiece(new int[][] { { 1, 1 }, { 4, 4 }, { 5, 5 } });
		cube[0][size - 1][size - 1] = new RubiksPiece(new int[][] { { 0, 0 }, { 2, 2 }, { 3, 3 } });
		cube[size - 1][0][size - 1] = new RubiksPiece(new int[][] { { 1, 1 }, { 2, 2 }, { 5, 5 } });
		cube[size - 1][size - 1][0] = new RubiksPiece(new int[][] { { 3, 3 }, { 4, 4 }, { 5, 5 } });
		cube[size - 1][size - 1][size - 1] = new RubiksPiece(new int[][] { { 2, 2 }, { 3, 3 }, { 5, 5 } });
	}

	private void setupRotation()
	{
		rotation[0] = new int[] { 0, 0, size - 1, 0 };
		rotation[1] = new int[] { 0, size - 1, 0, 0 };
		rotation[2] = new int[] { size - 1, size - 1, 0, size - 1 };
		rotation[3] = new int[] { size - 1, 0, size - 1, size - 1 };
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
				for (int j = 0; j < size; j++)
				{
					rotateFSB(j);
				}
			}
			else if (direction == 1)
			{
				for (int j = 0; j < size; j++)
				{
					rotateUED(j);
				}
			}
			else if (direction == 2)
			{
				for (int j = 0; j < size; j++)
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

	/**
	 * @return the time
	 */
	public String getTime()
	{
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time)
	{
		this.time = time;
	}

	/**
	 * @return the timePB
	 */
	public String getTimePB()
	{
		return timePB;
	}

	/**
	 * @param timePB
	 *            the timePB to set
	 */
	public void setTimePB(String timePB)
	{
		this.timePB = timePB;
	}

	/**
	 * @return the moves
	 */
	public String getMoves()
	{
		return moves;
	}

	/**
	 * @param moves
	 *            the moves to set
	 */
	public void setMoves(String moves)
	{
		this.moves = moves;
	}

	/**
	 * @return the movesPB
	 */
	public String getMovesPB()
	{
		return movesPB;
	}

	/**
	 * @param movesPB
	 *            the movesPB to set
	 */
	public void setMovesPB(String movesPB)
	{
		this.movesPB = movesPB;
	}

	/**
	 * @return the deciseconds
	 */
	public int getDeciseconds()
	{
		return deciseconds;
	}

	/**
	 * @param deciseconds
	 *            the deciseconds to set
	 */
	public void setDeciseconds(int deciseconds)
	{
		this.deciseconds = deciseconds;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds()
	{
		return seconds;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(int seconds)
	{
		this.seconds = seconds;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	/**
	 * @return the hours
	 */
	public int getHours()
	{
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(int hours)
	{
		this.hours = hours;
	}

	/**
	 * @return the moveCount
	 */
	public int getMoveCount()
	{
		return moveCount;
	}

	/**
	 * @param moveCount
	 *            the moveCount to set
	 */
	public void setMoveCount(int moveCount)
	{
		this.moveCount = moveCount;
	}

	/**
	 * @return the gameStart
	 */
	public boolean isGameStart()
	{
		return gameStart;
	}

	/**
	 * @param gameStart
	 *            the gameStart to set
	 */
	public void setGameStart(boolean gameStart)
	{
		this.gameStart = gameStart;
	}
}
