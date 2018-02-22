package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import rubiks.controller.RubiksController;

public class MenuPanel extends JPanel
{
	RubiksController appController;
	SpringLayout springLayout;
	MenuButtonPanel menuButtonPanel;

	public MenuPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		springLayout = new SpringLayout();
		menuButtonPanel = new MenuButtonPanel(appController);
		setupPanel();
		setupLayout();
	}

	private void setupPanel()
	{	
		this.setLayout(springLayout);
		this.add(menuButtonPanel);
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}
	
	private void setupLayout()
	{
		springLayout.putConstraint(SpringLayout.NORTH, menuButtonPanel, 200, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, menuButtonPanel, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, menuButtonPanel, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, menuButtonPanel, 0, SpringLayout.WEST, this);
	}
}
