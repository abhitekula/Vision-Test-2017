package org.usfirst.frc.team1923.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


import org.usfirst.frc.team1923.robot.commands.GearShiftCommand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick leftStick;

	public Joystick rightStick;
	
	public Joystick operator;

	public JoystickButton upShifter, downShifter, leftTrigger, rightTrigger, LEDButton;
	
	public XboxController xboxController;

	public OI() {
		leftStick = new Joystick(1);
		rightStick = new Joystick(2);
		//operator = new Joystick(3);
		//LEDButton = new JoystickButton(leftStick, 10);

		// Joystick buttons
		upShifter = new JoystickButton(rightStick, 7);
		downShifter = new JoystickButton(leftStick, 7);

		leftTrigger = new JoystickButton(leftStick, 1);
		rightTrigger = new JoystickButton(rightStick, 1);
		
		//Drive Controls
		leftTrigger.whenPressed(new GearShiftCommand(true));
		rightTrigger.whenPressed(new GearShiftCommand(false));
		
		
		//Operator
		xboxController = new XboxController(3);
		
        
	}
}
