package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class CubeInfoPanel extends JPanel
{
	private RubiksController appController;
	
	public CubeInfoPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		this.setBackground(Color.DARK_GRAY);
	}
}
