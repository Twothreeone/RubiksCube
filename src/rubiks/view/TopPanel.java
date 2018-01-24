package rubiks.view;

import rubiks.controller.RubiksController;

public class TopPanel extends FacePanel
{
	public TopPanel(RubiksController appController)
	{
		super(appController);
		orientation = 1;
		setupPanel();
		updateColors();
	}
	
	private void setupPanel()
	{
		this.buttonArray[0].setID(new int[] {2, 0, 0, 0, 2});
		this.buttonArray[1].setID(new int[] {2, 0, 1, 1, 2});
		this.buttonArray[2].setID(new int[] {2, 0, 2, 2, 2});
		this.buttonArray[3].setID(new int[] {1, 0, 0, 0, 1});
		this.buttonArray[4].setID(new int[] {1, 0, 1, 1, 1});
		this.buttonArray[5].setID(new int[] {1, 0, 2, 2, 1});
		this.buttonArray[6].setID(new int[] {0, 0, 0, 0, 0});
		this.buttonArray[7].setID(new int[] {0, 0, 1, 1, 0});
		this.buttonArray[8].setID(new int[] {0, 0, 2, 2, 0});
	}
}
