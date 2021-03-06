package rubiks.view;

import javax.swing.JPanel;
import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public abstract class FacePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	protected RubiksController appController;
	protected RubiksButton[] buttonArray;
	protected final Color[] colors = new Color[] { new Color(223, 223, 223), // White
			new Color(0, 40, 240), // Blue
			new Color(255, 0, 40), // Red
			new Color(0, 180, 40), // Green
			new Color(240, 80, 0).brighter(), // Orange
			new Color(240, 240, 0) }; // Yellow

	/**
	 * Creates a FacePanel by setting default values using the current cube's size and calling a helper
	 * method.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public FacePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		buttonArray = new RubiksButton[appController.getSize() * appController.getSize()];
		for (int i = 0; i < buttonArray.length; i++)
		{
			buttonArray[i] = new RubiksButton(appController);
		}
		setupPanel();
	}

	/**
	 * Helper method for the constructor, sets up the look of the panel and adds the buttons.
	 */
	private void setupPanel()
	{
		this.setLayout(new GridLayout(appController.getSize(), appController.getSize()));
		for (int i = 0; i < buttonArray.length; i++)
		{
			this.add(buttonArray[i]);
		}
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.BLACK, 3));
	}

	/**
	 * Updates the colors of all of the buttons using their ID's and the current cube.
	 */
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

	/**
	 * Calls the deselect method in every RubiksButton belonging to the FacePanel.
	 */
	public void deselect()
	{
		for (RubiksButton button : buttonArray)
		{
			button.deselect();
		}
	}

	/**
	 * Finds a button that is selected and returns its ID.
	 * 
	 * @return The selected button's ID, or null if no button is selected.
	 */
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

	/**
	 * Finds if every button has the same color.
	 * 
	 * @return Whether or not every button has the same color.
	 */
	public int detectVictory()
	{
		Color testColor = buttonArray[0].getBackground();
		for (RubiksButton button : buttonArray)
		{
			if (!button.getBackground().equals(testColor))
			{
				return 0;
			}
		}
		return 1;
	}
}
