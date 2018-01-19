package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class BottomPanel extends FacePanel
{
	public BottomPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.MAGENTA);
	}
}
