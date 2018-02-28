package rubiks.view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.Timer;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.text.DecimalFormat;
import rubiks.controller.RubiksController;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CubeInfoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private RubiksController appController;
	private DecimalFormat timeFormat, movesFormat;
	private SpringLayout springLayout;
	private Timer timer;
	private JLabel cubeType, time, timePB, moves, movesPB;
	private int deciseconds, seconds, minutes, hours, moveCount;
	private boolean gameStart;

	/**
	 * Creates the CubeInfoPanel by setting default values and calling helper methods.
	 * 
	 * @param appController
	 *            The app's RubiksController.
	 */
	public CubeInfoPanel(RubiksController appController)
	{
		super();
		this.appController = appController;
		timeFormat = new DecimalFormat("00");
		movesFormat = new DecimalFormat("000000");
		springLayout = new SpringLayout();
		cubeType = new JLabel(appController.getSize() + "x" + appController.getSize() + "x" + appController.getSize());
		time = new JLabel("00:00:00.0");
		timePB = new JLabel("Personal Best: 99:59:59.9");
		moves = new JLabel("Moves: 000000");
		movesPB = new JLabel("Personal Best:     999999");
		deciseconds = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		moveCount = 0;
		gameStart = false;
		setupTimer();
		setupPanel();
		setupLayout();
	}

	/**
	 * Helper method for the constructor, sets up the timer.
	 */
	private void setupTimer()
	{
		timer = new Timer(100, event ->
		{
			if (hours == 99 && minutes == 59 && seconds == 59 && deciseconds == 9)
			{
				timer.stop();
			}
			else
			{
				deciseconds++;
				if (deciseconds > 9)
				{
					deciseconds = 0;
					seconds++;
					if (seconds > 59)
					{
						seconds = 0;
						minutes++;
						if (minutes > 59)
						{
							minutes = 0;
							hours++;
						}
					}
				}
				time.setText(timeFormat.format(hours) + ":" + timeFormat.format(minutes) + ":" + timeFormat.format(seconds) + "." + deciseconds);
			}
		});
	}

	/**
	 * Helper method for the constructor, sets up the look of the panel and its components.
	 */
	private void setupPanel()
	{
		this.setLayout(springLayout);
		this.add(time);
		this.add(timePB);
		this.add(cubeType);
		this.add(moves);
		this.add(movesPB);
		time.setForeground(Color.WHITE);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		time.setBorder(new LineBorder(Color.BLACK, 6));
		timePB.setForeground(Color.WHITE);
		timePB.setHorizontalAlignment(SwingConstants.CENTER);
		timePB.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		timePB.setBorder(new LineBorder(Color.BLACK, 6));
		cubeType.setForeground(Color.WHITE);
		cubeType.setHorizontalAlignment(SwingConstants.CENTER);
		cubeType.setFont(new Font("Lucida Grande", Font.PLAIN, 54));
		cubeType.setBorder(new LineBorder(Color.BLACK, 6));
		moves.setForeground(Color.WHITE);
		moves.setHorizontalAlignment(SwingConstants.CENTER);
		moves.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		moves.setBorder(new LineBorder(Color.BLACK, 6));
		movesPB.setForeground(Color.WHITE);
		movesPB.setHorizontalAlignment(SwingConstants.CENTER);
		movesPB.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		movesPB.setBorder(new LineBorder(Color.BLACK, 6));
		this.setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.BLACK, 5));
	}

	/**
	 * Helper method for the constructor, sets up the layout of the components.
	 */
	private void setupLayout()
	{
		springLayout.putConstraint(SpringLayout.EAST, cubeType, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, cubeType, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, time, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, time, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, timePB, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, timePB, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, moves, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, moves, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, movesPB, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, movesPB, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, time, 0, SpringLayout.SOUTH, cubeType);
		springLayout.putConstraint(SpringLayout.NORTH, timePB, 0, SpringLayout.SOUTH, time);
		springLayout.putConstraint(SpringLayout.NORTH, moves, 0, SpringLayout.SOUTH, timePB);
		springLayout.putConstraint(SpringLayout.NORTH, movesPB, 0, SpringLayout.SOUTH, moves);
	}

	/**
	 * Sets the values for beginning a solve.
	 */
	public void startGame()
	{
		timer.stop();
		time.setText("00:00:00.0");
		moves.setText("Moves: 000000");
		deciseconds = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		moveCount = 0;
		gameStart = true;
	}

	/**
	 * Properly increments the moveCount int and moves JLabel.
	 */
	public void incrementMoves()
	{
		if (gameStart)
		{
			if (moveCount < 999999)
			{
				moveCount++;
				moves.setText("Moves: " + movesFormat.format(moveCount));
				if (!timer.isRunning())
				{
					timer.start();
				}
			}
		}
	}

	/**
	 * Ends a given solve.
	 */
	public void quitGame()
	{
		startGame();
		gameStart = false;
	}

	/**
	 * Handles completing a solve and passes personal bests to the appController.
	 */
	public void victory()
	{
		gameStart = false;
		timer.stop();
		appController.victory();
		String tempTime = time.getText();
		String tempTimePB = timePB.getText().substring(15, 25);
		tempTime = tempTime.replaceAll(":", "");
		tempTimePB = tempTimePB.replaceAll(":", "");
		if (Double.parseDouble(tempTime) < Double.parseDouble(tempTimePB))
		{
			timePB.setText("Personal Best: " + time.getText());
			appController.reportPB(time.getText());
		}
		int tempMovesPB = Integer.parseInt(movesPB.getText().substring(19, 25));
		if (moveCount < tempMovesPB)
		{
			movesPB.setText("Personal Best:     " + movesFormat.format(moveCount));
			appController.reportPB(moveCount + "");
		}
	}

	/**
	 * Passes the current cube info to the cube.
	 */
	public void updateCube()
	{
		if (!gameStart)
		{
			quitGame();
		}
		appController.updateCube(time.getText(), timePB.getText(), moves.getText(), movesPB.getText(), deciseconds, seconds, minutes, hours, moveCount, gameStart);
	}

	/**
	 * Updates the cube info from the cube.
	 * 
	 * @param time
	 *            The current time of the solve.
	 * @param timePB
	 *            The best solve time.
	 * @param moves
	 *            The current amount of moves of the solve.
	 * @param movesPB
	 *            The lowest amount of moves used to solve the cube.
	 * @param deciseconds
	 *            The current deciseconds of the cubes solve.
	 * @param seconds
	 *            The current seconds of the cubes solve.
	 * @param minutes
	 *            The current minutes of the cubes solve.
	 * @param hours
	 *            The current hours of the cubes solve.
	 * @param moveCount
	 *            The current amount of moves of the cubes solve.
	 * @param gameStart
	 *            Whether or not the solve has been started.
	 */
	public void updateInfoPanel(String time, String timePB, String moves, String movesPB, int deciseconds, int seconds, int minutes, int hours, int moveCount, boolean gameStart)
	{
		this.time.setText(time);
		this.timePB.setText(timePB);
		this.moves.setText(moves);
		this.movesPB.setText(movesPB);
		this.deciseconds = deciseconds;
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.moveCount = moveCount;
		this.gameStart = gameStart;
	}

	/**
	 * @return the gameStart
	 */
	public boolean isGameStart()
	{
		return gameStart;
	}
}
