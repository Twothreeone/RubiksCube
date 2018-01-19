package rubiks.view;

import javax.swing.JPanel;
import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public abstract class FacePanel extends JPanel
{
	protected RubiksController appController;
	protected RubiksButton[] buttonArray;
	
	public FacePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		buttonArray = new RubiksButton[9];
		for (int i = 0; i < 9; i++)
		{
			buttonArray[i] = new RubiksButton(appController);
		}
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++)
		{
			this.add(buttonArray[i]);
		}
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.BLACK, 3));
	}
}
