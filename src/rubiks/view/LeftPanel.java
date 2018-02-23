package rubiks.view;

import rubiks.controller.RubiksController;

public class LeftPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;
	
	public LeftPanel(RubiksController appController)
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
			for (int j = appController.getSize() - 1; j > -1; j--)
			{
				this.buttonArray[arrayIndex].setID(new int[] { j, i, 0, 4, j, i });
				arrayIndex++;
			}
		}
	}
}
