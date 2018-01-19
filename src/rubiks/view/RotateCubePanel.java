package rubiks.view;

import java.awt.Color;
import rubiks.controller.RubiksController;

public class RotateCubePanel extends RotatePanel
{
	public RotateCubePanel(RubiksController appController)
	{
		super(appController);
		this.setBackground(Color.BLACK);
	}
}
