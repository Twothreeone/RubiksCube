package rubiks.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class RubiksPanel extends JPanel
{
	private RubiksController appController;
	private SaveLoadPanel saveLoadPanel;
	private CubeFunctionsPanel cubeFunctionsPanel;
	private RotatePanel rotateLayersPanel;
	private RotatePanel rotateCubePanel;
	private FacePanel frontPanel;
	private FacePanel topPanel;
	private FacePanel bottomPanel;
	private FacePanel leftPanel;
	private FacePanel rightPanel;
	
	public RubiksPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		saveLoadPanel = new SaveLoadPanel(appController);
		cubeFunctionsPanel = new CubeFunctionsPanel(appController);
		rotateLayersPanel = new RotateLayersPanel(appController);
		rotateCubePanel = new RotateCubePanel(appController);
		frontPanel = new FrontPanel(appController);
		topPanel = new TopPanel(appController);
		bottomPanel = new BottomPanel(appController);
		leftPanel = new LeftPanel(appController);
		rightPanel = new RightPanel(appController);
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(saveLoadPanel);
		this.add(topPanel);
		this.add(cubeFunctionsPanel);
		this.add(leftPanel);
		this.add(frontPanel);
		this.add(rightPanel);
		this.add(rotateLayersPanel);
		this.add(bottomPanel);
		this.add(rotateCubePanel);
		this.setBackground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
	}
}
