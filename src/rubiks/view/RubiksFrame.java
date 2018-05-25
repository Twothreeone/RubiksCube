package rubiks.view;

import rubiks.controller.RubiksController;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class RubiksFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private MenuPanel menuPanel;
	private CubePanel cubePanel;
	private JMenuBar menuBar;

	/**
	 * Constructor for the RubiksFrame, sets the data members and sets up the frame.
	 * 
	 * @param appController
	 *            The app's RubiksController, used to allow the RubiksFrame and other objects to
	 *            communicate with the RubiksController.
	 */
	public RubiksFrame(RubiksController appController)
	{
		super();
		this.appController = appController;
		menuPanel = new MenuPanel(appController);
		setupFrame();
		setupListeners();
	}

	/**
	 * Helper method for the constructor, used to set the necessary parameters for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(menuPanel);
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setTitle("Rubik's Cube");
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * Helper method for the constructor, used to give the keyboard functionality and to do stuff when
	 * the window's state changes.
	 */
	private void setupListeners()
	{
		this.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent key)
			{
				int code = key.getKeyCode();
				if (code == KeyEvent.VK_UP)
				{
					int[] id = appController.findSelected();
					if (id != null)
					{
						if (id[3] == 0 || id[3] == 1 || id[3] == 3)
							appController.rotateLayer(2, id[4], 1);
						else if (id[3] == 2)
							appController.rotateLayer(0, id[4], 3);
						else if (id[3] == 4)
							appController.rotateLayer(0, id[4], 1);
					}
				}
				if (code == KeyEvent.VK_RIGHT)
				{
					int[] id = appController.findSelected();
					if (id != null)
					{
						if (id[3] == 0 || id[3] == 2 || id[3] == 4)
							appController.rotateLayer(1, id[5], 1);
						else if (id[3] == 1)
							appController.rotateLayer(0, id[5], 1);
						else if (id[3] == 3)
							appController.rotateLayer(0, id[5], 3);
					}
				}
				if (code == KeyEvent.VK_DOWN)
				{
					int[] id = appController.findSelected();
					if (id != null)
					{
						if (id[3] == 0 || id[3] == 1 || id[3] == 3)
							appController.rotateLayer(2, id[4], 3);
						else if (id[3] == 2)
							appController.rotateLayer(0, id[4], 1);
						else if (id[3] == 4)
							appController.rotateLayer(0, id[4], 3);
					}
				}
				if (code == KeyEvent.VK_LEFT)
				{
					int[] id = appController.findSelected();
					if (id != null)
					{
						if (id[3] == 0 || id[3] == 2 || id[3] == 4)
							appController.rotateLayer(1, id[5], 3);
						else if (id[3] == 1)
							appController.rotateLayer(0, id[5], 3);
						else if (id[3] == 3)
							appController.rotateLayer(0, id[5], 1);
					}
				}
				if (code == KeyEvent.VK_W)
					appController.rotateCube(2, 1);
				if (code == KeyEvent.VK_D)
					appController.rotateCube(1, 1);
				if (code == KeyEvent.VK_S)
					appController.rotateCube(2, 3);
				if (code == KeyEvent.VK_A)
					appController.rotateCube(1, 3);
				if (code == KeyEvent.VK_Q)
					appController.rotateCube(0, 3);
				if (code == KeyEvent.VK_E)
					appController.rotateCube(0, 1);
			}
		});
		this.addWindowListener(new WindowAdapter()
		{
			public void windowActivated(WindowEvent e)
			{
				appController.disposeVictoryFrame();
			}

			public void windowClosing(WindowEvent e)
			{
				appController.exit();
			}
		});
	}

	/**
	 * Resets the contentPane to a CubePanel.
	 */
	public void loadCube()
	{
		cubePanel = new CubePanel(appController);
		this.setContentPane(cubePanel);
		this.revalidate();
	}

	/**
	 * Resets the contentPane to a MenuPanel.
	 */
	public void menu()
	{
		appController.disposeVictoryFrame();
		this.setContentPane(menuPanel);
		this.revalidate();
	}

	/**
	 * @return the cubePanel
	 */
	public CubePanel getCubePanel()
	{
		return cubePanel;
	}
}
