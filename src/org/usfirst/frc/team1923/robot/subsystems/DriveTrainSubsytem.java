package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;
import org.usfirst.frc.team1923.robot.commands.DriveJoystickCommand;
import org.usfirst.frc.team1923.robot.commands.GearShiftCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem handles drive CANTalons.
 */
public class DriveTrainSubsytem extends Subsystem{
	
	public double oldLeftSpeed = 0,
			oldRightSpeed = 0;

	protected void initDefaultCommand() {
		setDefaultCommand(new DriveJoystickCommand());
	}

	public void stop(){
		rawDrive(0, 0);
	}
	
	public void arcadeDrive(double power, double turn){
		
		
	
		RobotMap.leftDriveOne.set((power+turn));
		RobotMap.leftDriveTwo.set((power+turn));
		RobotMap.leftDriveThree.set((power+turn));

		RobotMap.rightDriveOne.set(-(power-turn));
		RobotMap.rightDriveTwo.set(-(power-turn));
		RobotMap.rightDriveThree.set(-(power-turn));

		
	}
	
	public void rawDrive(double left, double right){
		
		RobotMap.leftDriveOne.set(left);
		RobotMap.leftDriveTwo.set(left);
		RobotMap.leftDriveThree.set(left);

		RobotMap.rightDriveOne.set(right);
		RobotMap.rightDriveTwo.set(right);
		RobotMap.rightDriveThree.set(right);
		
	}

	
	//returns true if any of the motors are moving
	public boolean isDriving(){
		return (RobotMap.leftDriveOne.get() != 0 ||
				RobotMap.leftDriveTwo.get() != 0 ||
				RobotMap.leftDriveThree.get() != 0 ||
				RobotMap.rightDriveOne.get() != 0 ||
				RobotMap.rightDriveTwo.get() != 0 ||
				RobotMap.rightDriveThree.get() != 0);
	}
}