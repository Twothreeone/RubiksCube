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
	RubiksController appController;
	JButton[] buttons;
	
	public MenuButtonPanel(RubiksController appController)
	{
		this.appController = appController;
		buttons = new JButton[30];
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new MenuButton(appController, i + 2);
		}
		setupPanel();
	}
	
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
