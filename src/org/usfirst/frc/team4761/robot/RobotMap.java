package org.usfirst.frc.team4761.robot;

import org.usfirst.frc.team4761.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static RobotDrive robotDrive = new RobotDrive(1, 0, 3, 2); //Probably correct
	public static Talon flipperMotor = new Talon(5); //probably correct
	
	//on the sheet it has front and rear but it doesn't matter which is which
	public static Talon spinnerMotor1 = new Talon(4);
	public static Talon spinnerMotor2 = new Talon(5);
	
	public static Shooter shooter = new Shooter();
	
}
