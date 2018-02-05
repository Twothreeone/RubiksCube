package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import javax.swing.JFrame;

public class RubiksFrame extends JFrame
{
	private RubiksController appController;
	private MenuPanel menuPanel;
	private CubePanel cubePanel;

	/**
	 * Constructor for the RubiksFrame, sets the data members and sets up the frame.
	 * 
	 * @param appController
	 *            The app's RubiksController, used to allow the RubiksFrame and other objects to
	 *            communicate with the RubiksController.
	 */
	public RubiksFrame(RubiksController appController)
	{
		super();
		this.appController = appController;
		menuPanel = new MenuPanel(appController);
		setupFrame();
	}

	/**
	 * Helper method for the constructor, used to set the necessary parameters for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(menuPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 900);
		this.setTitle("Rubik's Cube");
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void loadCube(int size)
	{
		cubePanel = new CubePanel(appController);
		this.setContentPane(cubePanel);
		this.revalidate();
	}
	
	public void menu()
	{
		this.setContentPane(menuPanel);
		this.revalidate();
	}
	
	/**
	 * @return the cubePanel
	 */
	public CubePanel getCubePanel()
	{
		return cubePanel;
	}
}
