package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import javax.swing.JFrame;

public class VictoryFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
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
		victoryPanel = new VictoryPanel(appController);
		setupFrame();
	}

	/**
	 * Helper method for the constructor, used to set the necessary parameters for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(victoryPanel);
		this.setLocationRelativeTo(appController.getAppFrame());
		this.setLocation(this.getX() - 270, this.getY() - 100);
		this.setUndecorated(true);
		this.setSize(540, 200);
		this.setBackground(new Color(100, 100, 100, 245));
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void reportPB(String pb)
	{
		victoryPanel.reportPB(pb);
		this.setSize(540, this.getHeight() + 110);
		this.setLocation(this.getX(), this.getY() - 55);
	}
}
