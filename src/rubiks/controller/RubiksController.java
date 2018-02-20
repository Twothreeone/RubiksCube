package rubiks.controller;

import rubiks.view.RubiksFrame;
import rubiks.model.RubiksCube;
import rubiks.model.RubiksPiece;

public class RubiksController
{
	private RubiksFrame appFrame;
	private RubiksCube cube;
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
		cube = FileController.readCubesFromFile();
		appFrame.loadCube();
		appFrame.requestFocus();
		updateInfoPanel();
	}

	public void menu()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateCube();
		FileController.saveCubesToFile(cube);
		appFrame.menu();
		appFrame.requestFocus();
	}

	public void scramble()
	{
		appFrame.disposeVictoryFrame();
		for (int i = 0; i < 1/*0000*/; i++)
		{
			cube.rotateLayer((int) (Math.random() * 3), (int) (Math.random() * 3), (int) (Math.random() * 3) + 1);
			appFrame.getCubePanel().updateColors();
		}
		appFrame.getCubePanel().getCubeInfoPanel().startGame();
		appFrame.requestFocus();
	}

	public void solve()
	{
		cube = new RubiksCube(size);
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
		cube.rotateLayer(direction, layer, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
		if (appFrame.getCubePanel().getCubeInfoPanel().isGameStart())
		{
			appFrame.getCubePanel().detectVictory();
		}
	}

	public void rotateCube(int direction, int amount)
	{
		cube.rotateCube(direction, amount);
		appFrame.getCubePanel().updateColors();
		appFrame.requestFocus();
	}

	public void updateCube(String time, String timePB, String moves, String movesPB, int deciseconds, int seconds, int minutes, int hours, int moveCount, boolean gameStart)
	{
		cube.setTime(time);
		cube.setTimePB(timePB);
		cube.setMoves(moves);
		cube.setMovesPB(movesPB);
		cube.setDeciseconds(deciseconds);
		cube.setSeconds(seconds);
		cube.setMinutes(minutes);
		cube.setHours(hours);
		cube.setMoveCount(moveCount);
		cube.setGameStart(gameStart);
	}

	public void updateInfoPanel()
	{
		appFrame.getCubePanel().getCubeInfoPanel().updateInfoPanel(cube.getTime(), cube.getTimePB(), cube.getMoves(), cube.getMovesPB(), cube.getDeciseconds(), cube.getSeconds(), cube.getMinutes(),
				cube.getHours(), cube.getMoveCount(), cube.isGameStart());
	}

	public void victory()
	{
		appFrame.victory();
	}

	public void exit()
	{
		if (cube != null)
		{
			appFrame.getCubePanel().getCubeInfoPanel().updateCube();
			FileController.saveCubesToFile(cube);
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
		return cube.getCube();
	}
}
