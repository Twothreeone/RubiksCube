package rubiks.view;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;
import javax.swing.SwingConstants;

public class VictoryPanel extends JPanel
{
	private RubiksController appController;
	private SpringLayout springLayout;
	private JLabel greenFireworks;
	private JLabel leftPurpleFireworks;
	private JLabel rightPurpleFireworks;
	
	
	public VictoryPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		springLayout = new SpringLayout();
		greenFireworks = new JLabel();
		leftPurpleFireworks = new JLabel();
		rightPurpleFireworks = new JLabel();
		setupPanel();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(springLayout);
		this.add(greenFireworks);
		this.add(leftPurpleFireworks);
		this.add(rightPurpleFireworks);
		greenFireworks.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/greenFireworks.gif")));
		greenFireworks.setHorizontalAlignment(SwingConstants.CENTER);
		leftPurpleFireworks.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/purpleFireworks.gif")));
		leftPurpleFireworks.setHorizontalAlignment(SwingConstants.CENTER);
		rightPurpleFireworks.setIcon(new ImageIcon(getClass().getResource("/rubiks/view/images/purpleFireworks.gif")));
		rightPurpleFireworks.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBorder(new LineBorder(Color.BLACK, 5));
	}
	
	private void setupLayout()
	{
		springLayout.putConstraint(SpringLayout.NORTH, greenFireworks, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, greenFireworks, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, greenFireworks, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, greenFireworks, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, leftPurpleFireworks, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, leftPurpleFireworks, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, leftPurpleFireworks, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, rightPurpleFireworks, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rightPurpleFireworks, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, rightPurpleFireworks, 0, SpringLayout.EAST, this);
	}
}
