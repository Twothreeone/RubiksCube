package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RotateLayersPanel extends JPanel
{
	private RubiksController appController;
	private JTextArea panelTextArea;
	private JButton up;
	private JButton right;
	private JButton down;
	private JButton left;

	public RotateLayersPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		panelTextArea = new JTextArea();
		up = new JButton();
		right = new JButton();
		down = new JButton();
		left = new JButton();
		setupPanel();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(new JLabel());
		this.add(up);
		this.add(new JLabel());
		this.add(left);
		this.add(panelTextArea);
		this.add(right);
		this.add(new JLabel());
		this.add(down);
		panelTextArea.setText("Rotate Layers");
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
		this.setBackground(Color.DARK_GRAY);
	}

	private void setupListeners()
	{
		up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int[] id = appController.findSelected();
				if (id != null)
				{
					if (id[3] == 0 || id[3] == 1 || id[3] == 3)
					{
						appController.rotateLayer(2, id[4], 1);
					}
					else if (id[3] == 2)
					{
						appController.rotateLayer(0, id[4], 3);
					}
					else if (id[3] == 4)
					{
						appController.rotateLayer(0, id[4], 1);
					}
				}
			}
		});
		right.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int[] id = appController.findSelected();
				if (id != null)
				{
					if (id[3] == 0 || id[3] == 2 || id[3] == 4)
					{
						appController.rotateLayer(1, id[5], 1);
					}
					else if (id[3] == 1)
					{
						appController.rotateLayer(0, id[5], 1);
					}
					else if (id[3] == 3)
					{
						appController.rotateLayer(0, id[5], 3);
					}
				}
			}
		});
		down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int[] id = appController.findSelected();
				if (id != null)
				{
					if (id[3] == 0 || id[3] == 1 || id[3] == 3)
					{
						appController.rotateLayer(2, id[4], 3);
					}
					else if (id[3] == 2)
					{
						appController.rotateLayer(0, id[4], 1);
					}
					else if (id[3] == 4)
					{
						appController.rotateLayer(0, id[4], 3);
					}
				}
			}
		});
		left.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int[] id = appController.findSelected();
				if (id != null)
				{
					if (id[3] == 0 || id[3] == 2 || id[3] == 4)
					{
						appController.rotateLayer(1, id[5], 3);
					}
					else if (id[3] == 1)
					{
						appController.rotateLayer(0, id[5], 3);
					}
					else if (id[3] == 3)
					{
						appController.rotateLayer(0, id[5], 1);
					}
				}
			}
		});
	}
}
