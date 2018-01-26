package rubiks.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import rubiks.controller.RubiksController;

public class RotateCubePanel extends JPanel
{
	private RubiksController appController;
	private JTextArea panelTextArea;
	private JButton up;
	private JButton right;
	private JButton down;
	private JButton left;
	private JButton rotateLeft;
	private JButton rotateRight;
	
	public RotateCubePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		panelTextArea = new JTextArea();
		up = new JButton();
		right = new JButton();
		down = new JButton();
		left = new JButton();
		rotateLeft = new JButton();
		rotateRight = new JButton();
		setupPanel();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(rotateLeft);
		this.add(up);
		this.add(rotateRight);
		this.add(left);
		this.add(panelTextArea);
		this.add(right);
		this.add(new JLabel());
		this.add(down);
		panelTextArea.setText("Rotate Cube");
		panelTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		panelTextArea.setLineWrap(true);
		panelTextArea.setWrapStyleWord(true);
		panelTextArea.setEditable(false);
		panelTextArea.setForeground(Color.WHITE);
		panelTextArea.setBackground(Color.DARK_GRAY);
		up.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/upArrow.png")));
		up.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/upArrowPressed.png")));
		up.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/upArrowRollover.png")));
		up.setBackground(Color.DARK_GRAY);
		up.setBorderPainted(false);
		right.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rightArrow.png")));
		right.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rightArrowPressed.png")));
		right.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rightArrowRollover.png")));
		right.setBackground(Color.DARK_GRAY);
		right.setBorderPainted(false);
		down.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/downArrow.png")));
		down.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/downArrowPressed.png")));
		down.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/downArrowRollover.png")));
		down.setBackground(Color.DARK_GRAY);
		down.setBorderPainted(false);
		left.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/leftArrow.png")));
		left.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/leftArrowPressed.png")));
		left.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/leftArrowRollover.png")));
		left.setBackground(Color.DARK_GRAY);
		left.setBorderPainted(false);
		rotateLeft.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateLeftArrow.png")));
		rotateLeft.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateLeftArrowPressed.png")));
		rotateLeft.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateLeftArrowRollover.png")));
		rotateLeft.setBackground(Color.DARK_GRAY);
		rotateLeft.setBorderPainted(false);
		rotateRight.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateRightArrow.png")));
		rotateRight.setPressedIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateRightArrowPressed.png")));
		rotateRight.setRolloverIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/rotateRightArrowRollover.png")));
		rotateRight.setBackground(Color.DARK_GRAY);
		rotateRight.setBorderPainted(false);
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void setupListeners()
	{
		up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(2, 1);
			}
		});
		right.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(1, 1);
			}
		});
		down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(2, 3);
			}
		});
		left.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(1, 3);
			}
		});
		rotateLeft.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(0, 3);
			}
		});
		rotateRight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.rotateCube(0, 1);
			}
		});
	}
}
