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
	JButton three;
	
	public MenuPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		three = new JButton();
		setupPanel();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.add(three);
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}
	
	private void setupListeners()
	{
		three.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.loadCube(3);
			}
		});
	}
}
