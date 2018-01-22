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
	protected final Color[] colors = new Color[] { 
			new Color(223, 223, 223), // White
			new Color(0, 40, 240),    // Blue
			new Color(255, 0, 40),    // Red
			new Color(0, 180, 40),    // Green
			new Color(240, 80, 0),    // Orange
			new Color(240, 240, 0) }; // Yellow

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

	protected void setColors()
	{
		int[][] colorsAndOrientation;
		for (int i = 0; i < 9; i++)
		{
			colorsAndOrientation = appController.getCube()[this.buttonArray[i].getID()[0]][this.buttonArray[i].getID()[1]][this.buttonArray[i].getID()[2]].getColorsAndOrientation();
			for (int j = 0; j < colorsAndOrientation.length; j++)
			{
				if (colorsAndOrientation[j][1] == buttonArray[i].getID()[3])
				{
					buttonArray[i].setBackgroundColor(colors[colorsAndOrientation[j][0]]);
					break;
				}
			}
		}
	}
}
