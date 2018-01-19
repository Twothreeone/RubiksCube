package rubiks.view;

import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public abstract class RotatePanel extends JPanel
{
	protected RubiksController appController;
	
	public RotatePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
	}
}
