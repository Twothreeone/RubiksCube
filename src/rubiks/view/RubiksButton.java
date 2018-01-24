package rubiks.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class RubiksButton extends JButton
{
	private RubiksController appController;
	private Color backgroundColor;
	private boolean selected;
	private int[] id;
	
	public RubiksButton(RubiksController appController)
	{
		super();
		this.appController = appController;
		selected = false;
		setupButton();
		setupListeners();
	}
	
	private void setupButton()
	{
		this.setOpaque(true);
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}
	
	private void setupListeners()
	{
		this.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent click)
			{
				appController.deselect();
				setBorder(new LineBorder(Color.LIGHT_GRAY, 5));
				selected = true;
			}
			
			public void mousePressed(MouseEvent onClick)
			{
				setBackground(backgroundColor.darker());
			}
			
			public void mouseReleased(MouseEvent offClick)
			{
				setBackground(backgroundColor);
			}
			
			public void mouseEntered(MouseEvent enter)
			{
				if (!selected)
				{
					setBorder(new LineBorder(Color.WHITE, 5));
				}
			}
			
			public void mouseExited(MouseEvent exit)
			{
				if (!selected)
				{
					setBorder(new LineBorder(Color.BLACK, 5));
				}
			}
		});
	}
	
	public void deselect()
	{
		selected = false;
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(Color backgroundColor)
	{
		this.backgroundColor = backgroundColor;
		this.setBackground(backgroundColor);
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected()
	{
		return selected;
	}

	/**
	 * @return the id
	 */
	public int[] getID()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(int[] id)
	{
		this.id = id;
	}
}
