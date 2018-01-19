package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class CubeFunctionsPanel extends JPanel
{
	RubiksController appController;
	
	public CubeFunctionsPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		this.setBackground(Color.ORANGE);
	}
}
