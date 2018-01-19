package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class SaveLoadPanel extends JPanel
{
	RubiksController appController;
	
	public SaveLoadPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		this.setBackground(Color.WHITE);
	}
}
