package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class CubeInfoPanel extends JPanel
{
	private RubiksController appController;
	
	public CubeInfoPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}
}
