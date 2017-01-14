package org.usfirst.frc.team1923.robot;

import org.usfirst.frc.team1923.robot.triggers.*;
import org.usfirst.frc.team1923.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Drive
		public static CANTalon leftDriveOne = new CANTalon(8);
		public static CANTalon leftDriveTwo = new CANTalon(9);
		public static CANTalon leftDriveThree = new CANTalon(10);
		public static CANTalon rightDriveOne = new CANTalon(1);
		public static CANTalon rightDriveTwo = new CANTalon(2);
		public static CANTalon rightDriveThree = new CANTalon(3);
	
		VisionTrigger visionTrig = new VisionTrigger();
		
		public static Compressor mainCompressor = new Compressor(11);
		public static DoubleSolenoid shifterSolenoid = new DoubleSolenoid(11,0,1);
		
	
	public RobotMap(){	
		
	}
	
}
