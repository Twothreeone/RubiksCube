package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class RightPanel extends FacePanel
{
	public RightPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.BLUE);
	}
}
