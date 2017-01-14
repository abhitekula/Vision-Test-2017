package org.usfirst.frc.team1923.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 *
 */
public class VisionTrigger extends Trigger {

    public boolean get() {
    	//If left and right triggers are pressed control robot with vision
    	//if(Robot.oi.leftStick && Robot.oi.right)
        return false;
    }
    

}
