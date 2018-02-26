package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import rubiks.controller.RubiksController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private SpringLayout springLayout;
	private MenuButtonPanel menuButtonPanel;
	private JLabel title;
	private JLabel title2;
	private JLabel author;

	/**
	 * Creates the MenuPanel by setting default values and calling helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public MenuPanel(RubiksController appController)
	{
		super();
		springLayout = new SpringLayout();
		menuButtonPanel = new MenuButtonPanel(appController);
		springLayout.putConstraint(SpringLayout.NORTH, menuButtonPanel, 200, SpringLayout.NORTH, this);
		title = new JLabel(
				"<html><font color='red'>R</font><font color='orange'>u</font><font color='yellow'>b</font><font color='green'>i</font><font color='blue'>k</font>'s <font color='silver'> Cube</font></html>\"");
		title2 = new JLabel("Simulator");
		author = new JLabel("by Ben Charlesworth");
		setupPanel();
		setupLayout();
	}

	/**
	 * Sets up the look of the panel and its components.
	 */
	private void setupPanel()
	{
		this.setLayout(springLayout);
		this.add(menuButtonPanel);
		this.add(title);
		this.add(title2);
		this.add(author);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Lucida Grande", Font.ITALIC, 140));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.LIGHT_GRAY);
		title2.setFont(new Font("Lucida Grande", Font.ITALIC, 50));
		title2.setHorizontalAlignment(SwingConstants.TRAILING);
		author.setForeground(Color.LIGHT_GRAY);
		author.setFont(new Font("Lucida Grande", Font.ITALIC, 40));
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * Sets up the layout of all of the components.
	 */
	private void setupLayout()
	{
		springLayout.putConstraint(SpringLayout.NORTH, author, 0, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.SOUTH, author, 0, SpringLayout.NORTH, menuButtonPanel);
		springLayout.putConstraint(SpringLayout.NORTH, title2, 0, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.SOUTH, title2, 0, SpringLayout.NORTH, menuButtonPanel);
		springLayout.putConstraint(SpringLayout.EAST, title2, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, title, -50, SpringLayout.NORTH, menuButtonPanel);
		springLayout.putConstraint(SpringLayout.EAST, title, -5, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, menuButtonPanel, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, menuButtonPanel, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, menuButtonPanel, 0, SpringLayout.WEST, this);
	}
}
