package rubiks.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.Font;

public class MenuButton extends JButton
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private int size;

	/**
	 * Creates the MenuButton and calls helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 * @param size
	 *            The size of cube the button corresponds to.
	 */
	public MenuButton(RubiksController appController, int size)
	{
		super();
		this.appController = appController;
		this.size = size;
		setupButton();
		setupListeners();
	}

	/**
	 * Helper method for the constructor, sets up the look of the button.
	 */
	private void setupButton()
	{
		this.setForeground(Color.WHITE);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		this.setText(size + "x" + size + "x" + size);
		this.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * Helper method for the constructor, sets up the functionality of the button.
	 */
	private void setupListeners()
	{
		this.addActionListener(click -> appController.loadCube(size));
		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				setBackground(Color.GRAY);
			}

			public void mouseReleased(MouseEvent e)
			{
				setBackground(Color.DARK_GRAY);
				setBorder(new LineBorder(Color.BLACK, 5));
			}

			public void mouseEntered(MouseEvent e)
			{
				setBorder(new LineBorder(Color.WHITE, 5));
			}

			public void mouseExited(MouseEvent e)
			{
				setBorder(new LineBorder(Color.BLACK, 5));
			}
		});
	}
}
