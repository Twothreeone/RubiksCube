package rubiks.view;

import rubiks.controller.RubiksController;

public class LeftPanel extends FacePanel
{
	public LeftPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
		updateColors();
	}

	private void setupPanel()
	{
		int arrayIndex = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 2; j > -1; j--)
			{
				this.buttonArray[arrayIndex].setID(new int[] { j, i, 0, 4, j, i });
				arrayIndex++;
			}
		}
	}
}
