package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class LeftPanel extends FacePanel
{
	public LeftPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.YELLOW);
	}
}
