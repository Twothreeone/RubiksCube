package rubiks.view;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import rubiks.controller.RubiksController;

public class RubiksPanel extends JPanel
{
	RubiksController appController;
	GridLayout appLayout;
	SaveLoadPanel saveLoadPanel;
	CubeFunctionsPanel cubeFunctionsPanel;
	RotatePanel rotateLayersPanel;
	RotatePanel rotateCubePanel;
	FacePanel frontPanel;
	FacePanel topPanel;
	FacePanel bottomPanel;
	FacePanel leftPanel;
	FacePanel rightPanel;
	
	public RubiksPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		appLayout = new GridLayout(3, 3);
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
		this.setLayout(appLayout);
		this.add(saveLoadPanel);
		this.add(topPanel);
		this.add(cubeFunctionsPanel);
		this.add(leftPanel);
		this.add(frontPanel);
		this.add(rightPanel);
		this.add(rotateLayersPanel);
		this.add(bottomPanel);
		this.add(rotateCubePanel);
	}
}
