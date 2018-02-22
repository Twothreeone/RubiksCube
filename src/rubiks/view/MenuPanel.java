package rubiks.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import rubiks.controller.RubiksController;

public class MenuPanel extends JPanel
{
	RubiksController appController;
	JButton[] buttons;

	public MenuPanel(RubiksController appController)
	{
		super();
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
