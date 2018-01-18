package rubiks.view;

import rubiks.controller.RubiksController;
import javax.swing.JFrame;

public class RubiksFrame extends JFrame
{
	RubiksController appController;
	RubiksPanel appPanel;

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
		appPanel = new RubiksPanel(appController);
		setupFrame();
	}

	/**
	 * Helper method for the constructor, used to set the necessary parameters for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 900);
		this.setTitle("Rubik's Cube");
		this.setResizable(false);
		this.setVisible(true);
	}
}
