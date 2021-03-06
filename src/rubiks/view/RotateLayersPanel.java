package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class RotateLayersPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private JButton panelLabel, up, right, down, left;

	/**
	 * Creates the RotateLayersPanel by setting default values and calling helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public RotateLayersPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		panelLabel = new JButton("<html>Rotate<br/>Layers</html>");
		up = new JButton();
		right = new JButton();
		down = new JButton();
		left = new JButton();
		setupPanel();
		setupListeners();
	}

	/**
	 * Sets up the look of the panel and all of its components.
	 */
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(new JLabel());
		this.add(up);
		this.add(new JLabel());
		this.add(left);
		this.add(panelLabel);
		this.add(right);
		this.add(new JLabel());
		this.add(down);
		panelLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		panelLabel.setOpaque(true);
		panelLabel.setBorder(new LineBorder(Color.WHITE, 3));
		panelLabel.setBackground(Color.BLACK);
		panelLabel.setForeground(Color.WHITE);
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
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * Sets up the functionality of all of the components.
	 */
	private void setupListeners()
	{
		up.addActionListener(click ->
		{
			int[] id = appController.findSelected();
			if (id != null)
			{
				if (id[3] == 0 || id[3] == 1 || id[3] == 3)
					appController.rotateLayer(true, 2, id[4], 1);
				else if (id[3] == 2)
					appController.rotateLayer(true, 0, id[4], 3);
				else if (id[3] == 4)
					appController.rotateLayer(true, 0, id[4], 1);
			}
		});
		right.addActionListener(click ->
		{
			int[] id = appController.findSelected();
			if (id != null)
			{
				if (id[3] == 0 || id[3] == 2 || id[3] == 4)
					appController.rotateLayer(true, 1, id[5], 1);
				else if (id[3] == 1)
					appController.rotateLayer(true, 0, id[5], 1);
				else if (id[3] == 3)
					appController.rotateLayer(true, 0, id[5], 3);
			}
		});
		down.addActionListener(click ->
		{
			int[] id = appController.findSelected();
			if (id != null)
			{
				if (id[3] == 0 || id[3] == 1 || id[3] == 3)
					appController.rotateLayer(true, 2, id[4], 3);
				else if (id[3] == 2)
					appController.rotateLayer(true, 0, id[4], 1);
				else if (id[3] == 4)
					appController.rotateLayer(true, 0, id[4], 3);
			}
		});
		left.addActionListener(click ->
		{
			int[] id = appController.findSelected();
			if (id != null)
			{
				if (id[3] == 0 || id[3] == 2 || id[3] == 4)
					appController.rotateLayer(true, 1, id[5], 3);
				else if (id[3] == 1)
					appController.rotateLayer(true, 0, id[5], 3);
				else if (id[3] == 3)
					appController.rotateLayer(true, 0, id[5], 1);
			}
		});
	}
}
