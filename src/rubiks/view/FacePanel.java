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
			new Color(223, 223, 223),         // White
			new Color(0, 40, 240),            // Blue
			new Color(255, 0, 40),            // Red
			new Color(0, 180, 40),            // Green
			new Color(240, 80, 0).brighter(), // Orange
			new Color(240, 240, 0) };         // Yellow

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

	public void updateColors()
	{
		int[][] colorsAndOrientation;
		for (RubiksButton button : buttonArray)
		{
			colorsAndOrientation = appController.getCube()[button.getID()[0]][button.getID()[1]][button.getID()[2]].getColorsAndOrientation();
			for (int[] colorAndOrientation : colorsAndOrientation)
			{
				if (colorAndOrientation[1] == button.getID()[3])
				{
					button.setBackgroundColor(colors[colorAndOrientation[0]]);
					break;
				}
			}
		}
	}
	
	public void deselect()
	{
		for (RubiksButton button : buttonArray)
		{
			button.deselect();
		}
	}
	
	public int[] findSelected()
	{
		for (RubiksButton button : buttonArray)
		{
			if (button.isSelected())
			{
				return button.getID();
			}
		}
		return null;
	}
}
