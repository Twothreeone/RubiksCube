package rubiks.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class CubeFunctionsPanel extends JPanel
{
	private RubiksController appController;
	private JButton menu;
	private JButton scramble;
	private JButton solve;

	public CubeFunctionsPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		menu = new JButton();
		scramble = new JButton();
		solve = new JButton();
		setupPanel();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 1));
		this.add(menu);
		this.add(scramble);
		this.add(solve);
		menu.setOpaque(true);
		menu.setText("Menu");
		menu.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		menu.setForeground(Color.WHITE);
		menu.setBackground(Color.DARK_GRAY);
		menu.setBorder(new LineBorder(Color.BLACK, 3));
		scramble.setOpaque(true);
		scramble.setText("Scramble");
		scramble.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		scramble.setForeground(Color.WHITE);
		scramble.setBackground(Color.DARK_GRAY);
		scramble.setBorder(new LineBorder(Color.BLACK, 3));
		solve.setOpaque(true);
		solve.setText("Solve");
		solve.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		solve.setForeground(Color.WHITE);
		solve.setBackground(Color.DARK_GRAY);
		solve.setBorder(new LineBorder(Color.BLACK, 3));
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}

	private void setupListeners()
	{
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.menu();
			}
		});
		scramble.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.scramble();
			}
		});
		solve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.solve(3);
			}
		});
		menu.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent onClick)
			{
				menu.setBackground(Color.DARK_GRAY.brighter());
			}

			public void mouseReleased(MouseEvent offClick)
			{
				menu.setBackground(Color.DARK_GRAY);
			}

			public void mouseEntered(MouseEvent enter)
			{
				menu.setBorder(new LineBorder(Color.WHITE, 3));
			}

			public void mouseExited(MouseEvent exit)
			{
				menu.setBorder(new LineBorder(Color.BLACK, 3));
			}
		});
		scramble.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent onClick)
			{
				scramble.setBackground(Color.DARK_GRAY.brighter());
			}

			public void mouseReleased(MouseEvent offClick)
			{
				scramble.setBackground(Color.DARK_GRAY);
			}

			public void mouseEntered(MouseEvent enter)
			{
				scramble.setBorder(new LineBorder(Color.WHITE, 3));
			}

			public void mouseExited(MouseEvent exit)
			{
				scramble.setBorder(new LineBorder(Color.BLACK, 3));
			}
		});
		solve.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent onClick)
			{
				solve.setBackground(Color.DARK_GRAY.brighter());
			}

			public void mouseReleased(MouseEvent offClick)
			{
				solve.setBackground(Color.DARK_GRAY);
			}

			public void mouseEntered(MouseEvent enter)
			{
				solve.setBorder(new LineBorder(Color.WHITE, 3));
			}

			public void mouseExited(MouseEvent exit)
			{
				solve.setBorder(new LineBorder(Color.BLACK, 3));
			}
		});
	}
}
