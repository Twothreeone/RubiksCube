package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class TopPanel extends FacePanel
{
	public TopPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.RED);
	}
}
