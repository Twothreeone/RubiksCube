package rubiks.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import rubiks.controller.RubiksController;
import java.awt.Font;

public class MenuButton extends JButton
{
	private RubiksController appController;
	private int size;

	public MenuButton(RubiksController appController, int size)
	{
		super();
		this.appController = appController;
		this.size = size;
		setupButton();
		setupListeners();
	}

	private void setupButton()
	{
		this.setText(size + "x" + size + "x" + size);
		this.setFont(new Font("Lucida Grande", Font.BOLD, 30));
	}

	private void setupListeners()
	{
		this.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.loadCube(size);
			}
		});
	}
}
