package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public abstract class RotatePanel extends JPanel
{
	protected RubiksController appController;
	
	public RotatePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
	}
}
