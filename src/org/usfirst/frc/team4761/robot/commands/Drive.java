package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.OI;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {}

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.robotDrive.setSafetyEnabled(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.robotDrive.mecanumDrive_Cartesian(OI.drivingJoystick.getX(), OI.drivingJoystick.getY(), OI.drivingJoystick.getZ(), 0);
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
