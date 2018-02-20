package rubiks.view;

import rubiks.controller.RubiksController;

public class RightPanel extends FacePanel
{
	public RightPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
		updateColors();
	}

	private void setupPanel()
	{
		int arrayIndex = 0;
		for (int i = 0; i < appController.getSize(); i++)
		{
			for (int j = 0; j < appController.getSize(); j++)
			{
				this.buttonArray[arrayIndex].setID(new int[] { j, i, appController.getSize() - 1, 2, j, i });
				arrayIndex++;
			}
		}
	}
}
