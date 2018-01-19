package rubiks.view;

import javax.swing.JButton;
import rubiks.controller.RubiksController;

public class RubiksButton extends JButton
{
	RubiksController appController;
	int[] id;
	
	public RubiksButton(RubiksController appController)
	{
		super();
		this.appController = appController;
	}
	
	public void setID(int[] id)
	{
		this.id = id;
	}
}
