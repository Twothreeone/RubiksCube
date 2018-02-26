package rubiks.controller;

import rubiks.view.RubiksFrame;
import rubiks.model.RubiksCube;
import rubiks.model.RubiksPiece;

public class RubiksController
{
	private RubiksFrame appFrame;
	private RubiksCube[] cubes;
	private int size;

	/**
	 * Constructor for the RubiksController that creates a RubiksFrame.
	 */
	public RubiksController()
	{
		appFrame = new RubiksFrame(this);
	}

	/**
	 * Calls the necessary methods to load a certain size of cube.
	 * 
	 * @param size
	 *            The size of cube to be loaded.
	 */
	public void loadCube(int size)
	{
		this.size = size;
		cubes = FileController.readCubesFromFile();
		appFrame.loadCube();
		appFrame.requestFocus();
		updateInfoPanel();
	}

	/**
	 * Calls the necessary methods to load the menu.
	 */
	public void menu()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateCube();
		FileController.saveCubesToFile(cubes);
		appFrame.menu();
		appFrame.requestFocus();
	}

	/**
	 * Randomly rotates the layers of the current cube 1000 times to mix it up and start the puzzle.
	 */
	public void scramble()
	{
		appFrame.disposeVictoryFrame();
		for (int i = 0; i < 1000; i++)
		{
			cubes[size].rotateLayer((int) (Math.random() * 3), (int) (Math.random() * size), (int) (Math.random() * 3) + 1);
			appFrame.getCubePanel().updateColors();
		}
		appFrame.getCubePanel().getCubeInfoPanel().startGame();
		appFrame.requestFocus();
	}

	/**
	 * Creates a new RubiksCube of the current size to produce a solved cube.
	 */
	public void solve()
	{
		cubes[size] = new RubiksCube(size);
		appFrame.getCubePanel().updateColors();
		appFrame.getCubePanel().getCubeInfoPanel().quitGame();
		appFrame.requestFocus();
	}

	/**
	 * Calls the CubePanel's deselect method.
	 */
	public void deselect()
	{
		appFrame.getCubePanel().deselect();
		appFrame.requestFocus();
	}

	/**
	 * Calls the CubePanel's findSelected method.
	 * 
	 * @return The currently selected button's ID.
	 */
	public int[] findSelected()
	{
		return appFrame.getCubePanel().findSelected();
	}

	/**
	 * Calls the necessary methods to rotate a specified layer of the current cube.
	 * 
	 * @param direction
	 *            Which direction will be turned (0 = FSB, 1 = UED, 2 = LMR).
	 * @param layer
	 *            How deep the layer to be turned is.
	 * @param amount
	 *            How many times to turn the layer.
	 */
	public void rotateLayer(int direction, int layer, int amount)
	{
		if (appFrame.getCubePanel().getCubeInfoPanel().isGameStart())
		{
			appFrame.getCubePanel().getCubeInfoPanel().incrementMoves();
		}
		cubes[size].rotateLayer(direction, layer, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
		if (appFrame.getCubePanel().getCubeInfoPanel().isGameStart())
		{
			appFrame.getCubePanel().detectVictory();
		}
	}

	/**
	 * Calls the necessary methods to rotate the entirety of the current cube.
	 * 
	 * @param direction
	 *            Which direction will be turned (0 = FSB, 1 = UED, 2 = LMR).
	 * @param amount
	 *            How many times to turn the cube.
	 */
	public void rotateCube(int direction, int amount)
	{
		cubes[size].rotateCube(direction, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}

	/**
	 * Updates the RubiksCube's internal data.
	 * 
	 * @param time
	 *            The current time of the solve.
	 * @param timePB
	 *            The best solve time.
	 * @param moves
	 *            The current amount of moves of the solve.
	 * @param movesPB
	 *            The lowest amount of moves used to solve the cube.
	 * @param deciseconds
	 *            The current deciseconds of the cubes solve.
	 * @param seconds
	 *            The current seconds of the cubes solve.
	 * @param minutes
	 *            The current minutes of the cubes solve.
	 * @param hours
	 *            The current hours of the cubes solve.
	 * @param moveCount
	 *            The current amount of moves of the cubes solve.
	 * @param gameStart
	 *            Whether or not the solve has been started.
	 */
	public void updateCube(String time, String timePB, String moves, String movesPB, int deciseconds, int seconds, int minutes, int hours, int moveCount, boolean gameStart)
	{
		cubes[size].setTime(time);
		cubes[size].setTimePB(timePB);
		cubes[size].setMoves(moves);
		cubes[size].setMovesPB(movesPB);
		cubes[size].setDeciseconds(deciseconds);
		cubes[size].setSeconds(seconds);
		cubes[size].setMinutes(minutes);
		cubes[size].setHours(hours);
		cubes[size].setMoveCount(moveCount);
		cubes[size].setGameStart(gameStart);
	}

	/**
	 * Retrieves the cubes info and passes it to the CubeInfoPanel.
	 */
	public void updateInfoPanel()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateInfoPanel(cubes[size].getTime(), cubes[size].getTimePB(), cubes[size].getMoves(), cubes[size].getMovesPB(), cubes[size].getDeciseconds(),
				cubes[size].getSeconds(), cubes[size].getMinutes(), cubes[size].getHours(), cubes[size].getMoveCount(), cubes[size].isGameStart());
	}

	/**
	 * Calls the RubiksFrame's victory method.
	 */
	public void victory()
	{
		appFrame.victory();
	}

	/**
	 * Saves the cubes and exits the program.
	 */
	public void exit()
	{
		if (appFrame.getCubePanel() != null)
		{
			appFrame.getCubePanel().getCubeInfoPanel().updateCube();
			FileController.saveCubesToFile(cubes);
		}
		System.exit(0);
	}

	/**
	 * Calls the RubiksFrame's reportPB method with a pb.
	 * 
	 * @param pb
	 *            A new personal best.
	 */
	public void reportPB(String pb)
	{
		appFrame.reportPB(pb);
	}

	/**
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * @return the appFrame
	 */
	public RubiksFrame getAppFrame()
	{
		return appFrame;
	}

	/**
	 * @return the cube
	 */
	public RubiksPiece[][][] getCube()
	{
		return cubes[size].getCube();
	}
}
