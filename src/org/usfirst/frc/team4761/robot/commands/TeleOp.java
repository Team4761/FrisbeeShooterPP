package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TeleOp extends CommandGroup {
    
    public  TeleOp() {
    	addParallel(new Drive());
    }
}
