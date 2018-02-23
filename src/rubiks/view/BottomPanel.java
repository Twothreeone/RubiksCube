package rubiks.view;

import rubiks.controller.RubiksController;

public class BottomPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;
	
	public BottomPanel(RubiksController appController)
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
				this.buttonArray[arrayIndex].setID(new int[] { i, appController.getSize() - 1, j, 3, j, i });
				arrayIndex++;
			}
		}
	}
}
