package rubiks.view;

import rubiks.controller.RubiksController;

public class BottomPanel extends FacePanel
{
	public BottomPanel(RubiksController appController)
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
			for (int j = 0; j < 3; j++)
			{
				this.buttonArray[arrayIndex].setID(new int[] { i, 2, j, 3, j, i });
				arrayIndex++;
			}
		}
	}
}
