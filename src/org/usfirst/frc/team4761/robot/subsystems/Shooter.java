package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private boolean spinning = false;
    private double defaultSpeed = 0.5;
    
    public void spin(double speed) {
    	if(speed < 0 || speed > 1) {
			System.out.println("Invalid speed for spinner (must be 0..1)");
		}
		RobotMap.spinnerMotor1.set(speed);
		RobotMap.spinnerMotor2.set(speed);
    }
    
    public void stopSpinning() { 
    	RobotMap.spinnerMotor1.set(0);
    	RobotMap.spinnerMotor2.set(0);
    }
	
	public void emergencyStop() {
		RobotMap.spinnerMotor1.stopMotor();
		RobotMap.spinnerMotor2.stopMotor();
	}
}

