package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import javax.swing.JFrame;

public class VictoryFrame extends JFrame
{
	private RubiksController appController;
	private VictoryPanel victoryPanel;

	/**
	 * Constructor for the RubiksFrame, sets the data members and sets up the frame.
	 * 
	 * @param appController
	 *            The app's RubiksController, used to allow the RubiksFrame and other objects to
	 *            communicate with the RubiksController.
	 */
	public VictoryFrame(RubiksController appController)
	{
		super();
		this.appController = appController;
		setupFrame();
	}

	/**
	 * Helper method for the constructor, used to set the necessary parameters for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(victoryPanel);
		this.setLocationRelativeTo(appController.getAppFrame());
		this.setLocation(this.getX() - 250, this.getY() - 250);
		this.setUndecorated(true);
		this.setSize(500, 500);
		this.setBackground(new Color(100, 100, 100, 240));
		this.setResizable(false);
		this.setVisible(true);
	}
}