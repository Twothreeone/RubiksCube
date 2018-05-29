package rubiks.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class RotateCubePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private JButton panelLabel, up, right, down, left, rotateLeft, rotateRight;

	/**
	 * Creates the RotateCubePanel by setting default values and calling helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public RotateCubePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		panelLabel = new JButton("<html>Rotate<br/>&nbsp;Cube</html>");
		up = new JButton();
		right = new JButton();
		down = new JButton();
		left = new JButton();
		rotateLeft = new JButton();
		rotateRight = new JButton();
		setupPanel();
		setupListeners();
	}

	/**
	 * Sets up the look of the panel and all of its components.
	 */
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(rotateLeft);
		this.add(up);
		this.add(rotateRight);
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
		setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * Sets up the functionality of all of the components.
	 */
	private void setupListeners()
	{
		up.addActionListener(click -> appController.rotateCube(true, 2, 1));
		right.addActionListener(click -> appController.rotateCube(true, 1, 1));
		down.addActionListener(click -> appController.rotateCube(true, 2, 3));
		left.addActionListener(click -> appController.rotateCube(true, 1, 3));
		rotateLeft.addActionListener(click -> appController.rotateCube(true, 0, 3));
		rotateRight.addActionListener(click -> appController.rotateCube(true, 0, 1));
	}
}
