package rubiks.view;

import rubiks.controller.RubiksController;

public class BottomPanel extends FacePanel
{
	public BottomPanel(RubiksController appController)
	{
		super(appController);
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.buttonArray[0].setID(new int[] {0, 2, 0});
		this.buttonArray[1].setID(new int[] {0, 2, 1});
		this.buttonArray[2].setID(new int[] {0, 2, 2});
		this.buttonArray[3].setID(new int[] {1, 2, 0});
		this.buttonArray[4].setID(new int[] {1, 2, 1});
		this.buttonArray[5].setID(new int[] {1, 2, 2});
		this.buttonArray[6].setID(new int[] {2, 2, 0});
		this.buttonArray[7].setID(new int[] {2, 2, 1});
		this.buttonArray[8].setID(new int[] {2, 2, 2});
	}
}
