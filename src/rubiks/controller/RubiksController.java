package rubiks.controller;

import rubiks.view.RubiksFrame;
import rubiks.view.VictoryFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import rubiks.model.*;

//TODO: Look here - https://alvinalexander.com/apple/mac/java-mac-native-look/Converting_Control_keystrok.shtml

public class RubiksController
{
	private RubiksFrame appFrame;
	private VictoryFrame victoryFrame;
	private RubiksCube[] cubes;
	private List<Rotation> rotations;
	private int size;
	private boolean isMac;

	/**
	 * Constructor for the RubiksController that creates a RubiksFrame.
	 */
	public RubiksController()
	{
		isMac = System.getProperty("os.name").toLowerCase().startsWith("mac os x");
		if (isMac)
		{
			System.setProperty("apple.awt.application.name", "Rubik's Cube");
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException error)
		{
			System.out.println("There was an error: " + error.getMessage());
		}
		cubes = FileController.readCubesFromFile();
		appFrame = new RubiksFrame(this);
		rotations = new ArrayList<Rotation>();
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
		appFrame.menu();
		appFrame.requestFocus();
	}

	/**
	 * Randomly rotates the layers of the current cube 1000 times to mix it up and start the puzzle.
	 */
	public void scramble()
	{
		disposeVictoryFrame();
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
	public void rotateLayer(boolean isNewRotation, int direction, int layer, int amount)
	{
		if (appFrame.getCubePanel().getCubeInfoPanel().isGameStart())
		{
			appFrame.getCubePanel().getCubeInfoPanel().incrementMoves();
		}
		cubes[size].rotateLayer(direction, layer, amount);
		if (isNewRotation) rotations.add(new Rotation(false, direction, layer, amount));
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
	public void rotateCube(boolean isNewRotation, int direction, int amount)
	{
		cubes[size].rotateCube(direction, amount);
		rotations.add(new Rotation(true, direction, -1, amount));
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}
	
	public void undo()
	{
		if (rotations.size() > 0)
		{
			Rotation rotate = rotations.get(rotations.size() - 1);
			if (rotate.isCubeRotation()) rotateCube(false, rotate.getDirection(), rotate.getAmount() + 2);
			else rotateLayer(false, rotate.getDirection(), rotate.getLayer(), rotate.getAmount() + 2);
			rotations.remove(rotations.size() - 1);
		}
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
		victoryFrame = new VictoryFrame(this);
	}

	/**
	 * Passes a new personal best to the VictoryFrame.
	 * 
	 * @param pb
	 *            A new personal best.
	 */
	public void reportPB(String pb)
	{
		if (victoryFrame != null)
		{
			victoryFrame.reportPB(pb);
		}
	}

	/**
	 * Gets rid of the VictoryFrame if it exists.
	 */
	public void disposeVictoryFrame()
	{
		if (victoryFrame != null)
		{
			victoryFrame.dispose();
			victoryFrame = null;
		}
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

	/**
	 * @return the isMac
	 */
	public boolean isMac()
	{
		return isMac;
	}
}
