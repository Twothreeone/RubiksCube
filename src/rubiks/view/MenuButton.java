package rubiks.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
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
		this.setForeground(Color.WHITE);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		this.setText(size + "x" + size + "x" + size);
		this.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		this.setBorder(new LineBorder(Color.BLACK, 5));
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
