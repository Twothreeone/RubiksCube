package rubiks.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class CubeFunctionsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private JButton menu, scramble, solve, undo, redo;
	private JPanel undoRedo;

	/**
	 * Creates the CubeFunctionsPanel by setting default values and calling helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public CubeFunctionsPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		menu = new JButton("Menu");
		scramble = new JButton("Scramble");
		solve = new JButton("Solve");
		undo = new JButton();
		redo = new JButton();
		undoRedo = new JPanel();
		setupPanel();
		setupListeners();
	}

	/**
	 * Helper method for the constructor, sets up the look of the panel and its components.
	 */
	private void setupPanel()
	{
		this.setLayout(new GridLayout(4, 1));
		this.add(menu);
		this.add(scramble);
		this.add(solve);
		this.add(undoRedo);
		menu.setOpaque(true);
		menu.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		menu.setForeground(Color.WHITE);
		menu.setBackground(Color.DARK_GRAY);
		menu.setBorder(new LineBorder(Color.BLACK, 5));
		scramble.setOpaque(true);
		scramble.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		scramble.setForeground(Color.WHITE);
		scramble.setBackground(Color.DARK_GRAY);
		scramble.setBorder(new LineBorder(Color.BLACK, 5));
		solve.setOpaque(true);
		solve.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		solve.setForeground(Color.WHITE);
		solve.setBackground(Color.DARK_GRAY);
		solve.setBorder(new LineBorder(Color.BLACK, 5));
		undoRedo.setLayout(new GridLayout(1, 2));
		undoRedo.add(undo);
		undoRedo.add(redo);
		undo.setOpaque(true);
		undo.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/undoInactive.png")));
		undo.setBackground(Color.DARK_GRAY);
		undo.setBorder(new LineBorder(Color.BLACK, 5));
		redo.setOpaque(true);
		redo.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/redoInactive.png")));
		redo.setBackground(Color.DARK_GRAY);
		redo.setBorder(new LineBorder(Color.BLACK, 5));
		undoRedo.setBackground(Color.BLACK);
		this.setBackground(Color.BLACK);
	}

	/**
	 * Sets up the functionality of all of the components.
	 */
	private void setupListeners()
	{
		menu.addActionListener(click -> appController.menu());
		scramble.addActionListener(click -> appController.scramble());
		solve.addActionListener(click -> appController.solve());
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
