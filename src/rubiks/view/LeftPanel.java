package rubiks.view;

import rubiks.controller.RubiksController;

public class LeftPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;

	/**
	 * Calls helper methods to create the LeftPanel.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public LeftPanel(RubiksController appController)
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
			for (int j = appController.getSize() - 1; j > -1; j--)
			{
				this.buttonArray[arrayIndex].setID(new int[] { j, i, 0, 4, j, i });
				arrayIndex++;
			}
		}
	}
}
