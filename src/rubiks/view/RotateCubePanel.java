package rubiks.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class RotateCubePanel extends JPanel
{
	private RubiksController appController;
	
	public RotateCubePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.setBackground(Color.DARK_GRAY);
	}
}
