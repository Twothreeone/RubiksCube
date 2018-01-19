package rubiks.view;

import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public abstract class FacePanel extends JPanel
{
	protected RubiksController appController;
	
	public FacePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
	}
}
