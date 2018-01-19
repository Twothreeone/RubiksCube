package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class RotateLayersPanel extends RotatePanel
{
	public RotateLayersPanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.CYAN);
	}
}
