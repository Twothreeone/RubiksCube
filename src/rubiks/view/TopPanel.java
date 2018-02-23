package rubiks.view;

import rubiks.controller.RubiksController;

public class TopPanel extends FacePanel
{
	private static final long serialVersionUID = 1L;
	
	public TopPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
		updateColors();
	}

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
