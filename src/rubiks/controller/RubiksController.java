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

	public void loadCube(int size)
	{
		this.size = size;
		cubes = FileController.readCubesFromFile();
		appFrame.loadCube();
		appFrame.requestFocus();
		updateInfoPanel();
	}

	public void menu()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateCube();
		FileController.saveCubesToFile(cubes);
		appFrame.menu();
		appFrame.requestFocus();
	}

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

	public void solve()
	{
		cubes[size] = new RubiksCube(size);
		appFrame.getCubePanel().updateColors();
		appFrame.getCubePanel().getCubeInfoPanel().quitGame();
		appFrame.requestFocus();
	}

	public void deselect()
	{
		appFrame.getCubePanel().deselect();
		appFrame.requestFocus();
	}

	public int[] findSelected()
	{
		return appFrame.getCubePanel().findSelected();
	}

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

	public void rotateCube(int direction, int amount)
	{
		cubes[size].rotateCube(direction, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}

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

	public void updateInfoPanel()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateInfoPanel(cubes[size].getTime(), cubes[size].getTimePB(), cubes[size].getMoves(), cubes[size].getMovesPB(), cubes[size].getDeciseconds(),
				cubes[size].getSeconds(), cubes[size].getMinutes(), cubes[size].getHours(), cubes[size].getMoveCount(), cubes[size].isGameStart());
	}

	public void victory()
	{
		appFrame.victory();
	}

	public void exit()
	{
		if (appFrame.getCubePanel() != null)
		{
			appFrame.getCubePanel().getCubeInfoPanel().updateCube();
			FileController.saveCubesToFile(cubes);
		}
		System.exit(0);
	}

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
