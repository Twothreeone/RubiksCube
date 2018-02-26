package rubiks.view;

import rubiks.controller.RubiksController;

public class TopPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;

	/**
	 * Calls helper methods to create the TopPanel.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public TopPanel(RubiksController appController)
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
		for (int i = appController.getSize() - 1; i > -1; i--)
		{
			for (int j = 0; j < appController.getSize(); j++)
			{
				this.buttonArray[arrayIndex].setID(new int[] { i, 0, j, 1, j, i });
				arrayIndex++;
			}
		}
	}
}
