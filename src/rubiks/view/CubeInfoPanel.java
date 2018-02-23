package rubiks.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private DecimalFormat timeFormat;
	private DecimalFormat movesFormat;
	private SpringLayout springLayout;
	private Timer timer;
	private JLabel cubeType;
	private JLabel time;
	private JLabel timePB;
	private JLabel moves;
	private JLabel movesPB;
	private int deciseconds;
	private int seconds;
	private int minutes;
	private int hours;
	private int moveCount;
	private boolean gameStart;

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

	private void setupTimer()
	{
		timer = new Timer(100, new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
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
				if (hours == 99 && minutes == 59 && seconds == 59 && deciseconds == 9)
				{
					timer.stop();
				}
			}
		});
	}

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

	public void quitGame()
	{
		startGame();
		gameStart = false;
	}

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

	public void updateCube()
	{
		if (!gameStart)
		{
			quitGame();
		}
		appController.updateCube(time.getText(), timePB.getText(), moves.getText(), movesPB.getText(), deciseconds, seconds, minutes, hours, moveCount, gameStart);
	}

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
