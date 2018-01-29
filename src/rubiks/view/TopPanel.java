package rubiks.view;

import rubiks.controller.RubiksController;

public class TopPanel extends FacePanel
{
	public TopPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
		updateColors();
	}

	private void setupPanel()
	{
		int arrayIndex = 0;
		for (int i = 2; i > -1; i--)
		{
			for (int j = 0; j < 3; j++)
			{
				this.buttonArray[arrayIndex].setID(new int[] { i, 0, j, 1, j, i });
				arrayIndex++;
			}
		}
	}
}
