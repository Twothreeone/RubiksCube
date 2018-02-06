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
	private FacePanel[] facePanels;

	public CubePanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		cubeInfoPanel = new CubeInfoPanel(appController);
		cubeFunctionsPanel = new CubeFunctionsPanel(appController);
		rotateLayersPanel = new RotateLayersPanel(appController);
		rotateCubePanel = new RotateCubePanel(appController);
		facePanels = new FacePanel[5];
		facePanels[0] = new FrontPanel(appController);
		facePanels[1] = new TopPanel(appController);
		facePanels[2] = new RightPanel(appController);
		facePanels[3] = new BottomPanel(appController);
		facePanels[4] = new LeftPanel(appController);
		setupPanel();
	}

	private void setupPanel()
	{
		this.setLayout(new GridLayout(3, 3));
		this.add(cubeFunctionsPanel);
		this.add(facePanels[1]);
		this.add(cubeInfoPanel);
		this.add(facePanels[4]);
		this.add(facePanels[0]);
		this.add(facePanels[2]);
		this.add(rotateCubePanel);
		this.add(facePanels[3]);
		this.add(rotateLayersPanel);
		this.setBackground(Color.BLACK);
		setBorder(new LineBorder(Color.BLACK, 5));
	}

	public void deselect()
	{
		for (int i = 0; i < 5; i++)
		{
			facePanels[i].deselect();
		}
	}

	public int[] findSelected()
	{
		for (int i = 0; i < 5; i++)
		{
			if (facePanels[i].findSelected() != null)
			{
				return facePanels[i].findSelected();
			}
		}
		return null;
	}

	public void updateColors()
	{
		for (int i = 0; i < 5; i++)
		{
			facePanels[i].updateColors();
		}
	}
	
	public void detectVictory()
	{
		int winCondition = 0;
		for (int i = 0; i < 5; i++)
		{
			winCondition += facePanels[i].detectVictory();
		}
		if (winCondition >= 5)
		{
			cubeInfoPanel.victory();
		}
	}

	/**
	 * @return the cubeInfoPanel
	 */
	public CubeInfoPanel getCubeInfoPanel()
	{
		return cubeInfoPanel;
	}
}
