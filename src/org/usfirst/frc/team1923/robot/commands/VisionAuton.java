package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1923.robot.*;

/**
 *
 */
public class VisionAuton extends Command {

    public VisionAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Should follow a vision target around
    	
    	double centerX;
    	synchronized (Robot.imgLock) {
    		centerX = Robot.centerX;
    	}
    	double turn = centerX - (Robot.IMG_WIDTH / 2);
    	Robot.driveSubsystem.arcadeDrive(0.2, turn * 0.005);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
