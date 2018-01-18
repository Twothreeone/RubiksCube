package rubiks.view;

import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class RubiksPanel extends JPanel
{
	RubiksController appController;
	
	public RubiksPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
	}
}
