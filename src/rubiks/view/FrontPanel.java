package rubiks.view;

import rubiks.controller.RubiksController;

public class FrontPanel extends FacePanel
{
	public FrontPanel(RubiksController appController)
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
				this.buttonArray[arrayIndex].setID(new int[] { 0, i, j, 0, j, i });
				arrayIndex++;
			}
		}
	}
}
