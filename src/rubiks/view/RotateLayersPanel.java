package rubiks.view;

import rubiks.controller.RubiksController;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import rubiks.controller.RubiksController;
import javax.swing.SwingConstants;

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
		this.setBackground(Color.DARK_GRAY);
		
	}
}
