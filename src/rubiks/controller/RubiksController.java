package rubiks.controller;

import rubiks.view.RubiksFrame;

public class RubiksController
{
	RubiksFrame appFrame;

	/**
	 * Constructor for the RubiksController that creates a RubiksFrame.
	 */
	public RubiksController()
	{
		appFrame = new RubiksFrame(this);
	}
}
