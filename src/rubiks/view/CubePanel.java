package rubiks.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import rubiks.controller.RubiksController;

public class CubePanel extends JPanel
{
	private RubiksController appController;
	private CubeInfoPanel cubeInfoPanel;
	private CubeFunctionsPanel cubeFunctionsPanel;
	private RotateLayersPanel rotateLayersPanel;
	private RotateCubePanel rotateCubePanel;
	private FacePanel frontPanel;
	private FacePanel topPanel;
	private FacePanel bottomPanel;
	private FacePanel leftPanel;
	private FacePanel rightPanel;
	
	public CubePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		cubeInfoPanel = new CubeInfoPanel(appController);
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
		this.add(cubeInfoPanel);
		this.add(topPanel);
		this.add(cubeFunctionsPanel);
		this.add(leftPanel);
		this.add(frontPanel);
		this.add(rightPanel);
		this.add(rotateLayersPanel);
		this.add(bottomPanel);
		this.add(rotateCubePanel);
		this.setBackground(Color.BLACK);
		setBorder(new LineBorder(Color.BLACK, 5));
	}
	
	public void deselect()
	{
		frontPanel.deselect();
		topPanel.deselect();
		rightPanel.deselect();
		bottomPanel.deselect();
		leftPanel.deselect();
	}
	
	public int[] findSelected()
	{
		if (frontPanel.findSelected() != null)
		{
			return frontPanel.findSelected();
		}
		else if (topPanel.findSelected() != null)
		{
			return topPanel.findSelected();
		}
		else if (rightPanel.findSelected() != null)
		{
			return rightPanel.findSelected();
		}
		else if (bottomPanel.findSelected() != null)
		{
			return bottomPanel.findSelected();
		}
		else if (leftPanel.findSelected() != null)
		{
			return leftPanel.findSelected();
		}
		return null;
	}
	
	public void updateColors()
	{
		frontPanel.updateColors();
		topPanel.updateColors();
		rightPanel.updateColors();
		bottomPanel.updateColors();
		leftPanel.updateColors();
	}
}