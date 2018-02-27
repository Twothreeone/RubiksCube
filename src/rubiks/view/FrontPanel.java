package rubiks.view;

import rubiks.controller.RubiksController;

public class FrontPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;

	/**
	 * Calls helper methods to create the FrontPanel.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public FrontPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
		updateColors();
	}

	/**
	 * Helper method for the constructor, sets up the id's of the buttons.
	 */
	private void setupPanel()
	{
		int arrayIndex = 0;
		for (int i = 0; i < appController.getSize(); i++)
		{
			for (int j = 0; j < appController.getSize(); j++)
			{
				this.buttonArray[arrayIndex].setID(new int[] { 0, i, j, 0, j, i });
				arrayIndex++;
			}
		}
	}
}
