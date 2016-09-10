package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Slap extends CommandGroup {
    public  Slap() {
        int waitTime = SmartDashboard.getInt("flipper_waittime", 250); //probably updated
    	addSequential(new MoveFlipper(SmartDashboard.getNumber("flipper_forward", -0.25), waitTime)); //forward
    	addSequential(new MoveFlipper(SmartDashboard.getNumber("flipper_backward", 0.25), (int) waitTime * 1.08)); //backward
    	addSequential(new MoveFlipper(0, 10)); //stop
    }
}
