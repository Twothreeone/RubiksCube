package rubiks.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class RubiksButton extends JButton
{
	RubiksController appController;
	Color background;
	int[] id;
	
	public RubiksButton(RubiksController appController)
	{
		super();
		this.appController = appController;
		setupButton();
		setupListeners();
	}
	
	private void setupButton()
	{
		this.setOpaque(true);
		this.setBorder(new LineBorder(Color.BLACK, 5));
		this.setBackground(Color.RED);
		background = this.getBackground();
	}
	
	private void setupListeners()
	{
		this.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent click)
			{
				//TODO: Add functionality
			}
			
			public void mousePressed(MouseEvent onClick)
			{
				setBackground(background.darker());
			}
			
			public void mouseReleased(MouseEvent offClick)
			{
				setBackground(background);
			}
			
			public void mouseEntered(MouseEvent enter)
			{
				setBorder(new LineBorder(Color.WHITE, 5));
			}
			
			public void mouseExited(MouseEvent exit)
			{
				setBorder(new LineBorder(Color.BLACK, 5));
			}
		});
	}
	
	public void setID(int[] id)
	{
		this.id = id;
	}
}
