package rubiks.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class MenuButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;

	/**
	 * Creates the MenuButtons and calls a helper method.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public MenuButtonPanel(RubiksController appController)
	{
		super();
		buttons = new JButton[30];
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new MenuButton(appController, i + 2);
		}
		setupPanel();
	}

	/**
	 * Helper method for the constructor, sets up the look of the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(new GridLayout(6, 5));
		for (JButton button : buttons)
		{
			this.add(button);
		}
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 10));
	}
}
