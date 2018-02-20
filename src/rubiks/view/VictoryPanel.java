package rubiks.view;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VictoryPanel extends JPanel
{
	private RubiksController appController;
	private SpringLayout springLayout;
	private JLabel solved;
	private JTextArea pb1;
	private JTextArea pb2;
	private JButton menu;
	private JButton tryAgain;

	public VictoryPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		springLayout = new SpringLayout();
		solved = new JLabel("You Solved It!");
		pb1 = new JTextArea("You got a new personal best time of 00:00:00.0!");
		pb2 = new JTextArea("You got a new personal best move count of 0000!");
		menu = new JButton("Menu");
		tryAgain = new JButton("Try Again");
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(springLayout);
		this.add(solved);
		this.add(pb1);
		this.add(pb2);
		this.add(menu);
		this.add(tryAgain);
		solved.setHorizontalAlignment(SwingConstants.CENTER);
		solved.setFont(new Font("Lucida Grande", Font.BOLD, 60));
		solved.setForeground(Color.WHITE);
		pb1.setEnabled(true);
		pb1.setEditable(false);
		pb1.setLineWrap(true);
		pb1.setWrapStyleWord(true);
		pb1.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		pb1.setForeground(Color.WHITE);
		pb1.setBackground(new Color(0, 0, 0, 0));
		pb2.setEnabled(true);
		pb2.setEditable(false);
		pb2.setLineWrap(true);
		pb2.setWrapStyleWord(true);
		pb2.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		pb2.setForeground(Color.WHITE);
		pb2.setBackground(new Color(0, 0, 0, 0));
		menu.setBorder(new LineBorder(Color.BLACK, 5));
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		tryAgain.setBorder(new LineBorder(Color.BLACK, 5));
		tryAgain.setForeground(Color.WHITE);
		tryAgain.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		this.setBackground(new Color(100, 100, 100, 245));
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}

	private void setupLayout()
	{
		springLayout.putConstraint(SpringLayout.WEST, solved, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, solved, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, solved, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, pb1, 30, SpringLayout.SOUTH, solved);
		springLayout.putConstraint(SpringLayout.EAST, pb1, -5, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, pb1, 5, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, pb2, 20, SpringLayout.SOUTH, pb1);
		springLayout.putConstraint(SpringLayout.EAST, pb2, -5, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, pb2, 5, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, menu, 400, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, menu, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, menu, -20, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, menu, 220, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, tryAgain, 400, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tryAgain, -220, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tryAgain, -20, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tryAgain, -20, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				appController.menu();
			}
		});
		tryAgain.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				appController.scramble();
			}
		});
		menu.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent onClick)
			{
				menu.setForeground(Color.LIGHT_GRAY);
			}
			
			public void mouseReleased(MouseEvent offClick)
			{
				menu.setForeground(Color.WHITE);
			}
			
			public void mouseEntered(MouseEvent enter)
			{
				menu.setBorder(new LineBorder(Color.WHITE, 5));
			}
			
			public void mouseExited(MouseEvent exit)
			{
				menu.setBorder(new LineBorder(Color.BLACK, 5));
			}
		});
		tryAgain.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent onClick)
			{
				tryAgain.setForeground(Color.LIGHT_GRAY);
			}
			
			public void mouseReleased(MouseEvent offClick)
			{
				tryAgain.setForeground(Color.WHITE);
			}
			
			public void mouseEntered(MouseEvent enter)
			{
				tryAgain.setBorder(new LineBorder(Color.WHITE, 5));
			}
			
			public void mouseExited(MouseEvent exit)
			{
				tryAgain.setBorder(new LineBorder(Color.BLACK, 5));
			}
		});
	}
	
	public void reportPB(String pb)
	{
		
	}
}
