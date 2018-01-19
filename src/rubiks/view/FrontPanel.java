package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class FrontPanel extends FacePanel
{
	public FrontPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.GREEN);
	}
}
