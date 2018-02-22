package rubiks.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import rubiks.controller.RubiksController;

public class MenuButtonPanel extends JPanel
{
	RubiksController appController;
	JButton[] buttons;
	
	public MenuButtonPanel(RubiksController appController)
	{
		this.appController = appController;
		buttons = new JButton[20];
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new MenuButton(appController, i + 2);
		}
		setupPanel();
	}
	
	private void setupPanel()
	{
		for (JButton button : buttons)
		{
			this.add(button);
		}
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}
}
