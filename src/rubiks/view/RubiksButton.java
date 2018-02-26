package rubiks.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class RubiksButton extends JButton
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private Color backgroundColor;
	private boolean selected;
	private int[] id;

	/**
	 * Creates the RubiksButton with a few helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public RubiksButton(RubiksController appController)
	{
		super();
		this.appController = appController;
		selected = false;
		setupButton();
		setupListeners();
	}

	/**
	 * Helper method for the constructor, sets up the look of the button.
	 */
	private void setupButton()
	{
		this.setOpaque(true);
		this.setBorder(new LineBorder(Color.BLACK, 10 / appController.getSize() + 1));
	}

	/**
	 * Helper method for the constructor, sets up the functionality of the button.
	 */
	private void setupListeners()
	{
		this.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.deselect();
				setBorder(new LineBorder(Color.LIGHT_GRAY, 10 / appController.getSize() + 1));
				selected = true;
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
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
					setBorder(new LineBorder(Color.WHITE, 10 / appController.getSize() + 1));
				}
			}

			public void mouseExited(MouseEvent exit)
			{
				if (!selected)
				{
					setBorder(new LineBorder(Color.BLACK, 10 / appController.getSize() + 1));
				}
			}
		});
	}

	/**
	 * Puts the button into a deselected state.
	 */
	public void deselect()
	{
		selected = false;
		this.setBorder(new LineBorder(Color.BLACK, 10 / appController.getSize() + 1));
	}

	/**
	 * @param backgroundColor
	 *            the backgroundColor to set
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
	 * @param id
	 *            the id to set
	 */
	public void setID(int[] id)
	{
		this.id = id;
	}
}
