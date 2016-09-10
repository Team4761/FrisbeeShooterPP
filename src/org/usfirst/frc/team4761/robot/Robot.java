
package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4761.robot.commands.DummyAutonomous;
import org.usfirst.frc.team4761.robot.commands.MoveFlipper;
import org.usfirst.frc.team4761.robot.commands.SetSpinners;
import org.usfirst.frc.team4761.robot.commands.Shoot;
import org.usfirst.frc.team4761.robot.commands.Slap;
import org.usfirst.frc.team4761.robot.commands.TeleOp;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;

    Command autonomousCommand;
    Command teleopCommand;
    Command shootCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		RobotMap.robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		RobotMap.robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		RobotMap.robotDrive.setExpiration(0.1);
		
		oi = new OI();
		Button shootingJsButton1 = new JoystickButton(OI.shootingJoystick, 1);
		Button drivingJsButton1  = new JoystickButton(OI.drivingJoystick,  1);
		Button drivingJsButton2  = new JoystickButton(OI.drivingJoystick,  2);
		Button drivingJsButton3  = new JoystickButton(OI.drivingJoystick,  3);
		Button drivingJsButton4  = new JoystickButton(OI.drivingJoystick,  4);
		
		shootCommand = new Shoot();
		shootingJsButton1.whenPressed(shootCommand);
		drivingJsButton1.cancelWhenPressed(shootCommand);
		
		drivingJsButton2.whenPressed(new MoveFlipper(0.1, 0.2));
		drivingJsButton3.whenPressed(new Slap());
		//drivingJsButton4.whenPressed(new SetSpinners(0.1));
		
		SmartDashboard.putDouble("flipper_forward",  -0.25);
		SmartDashboard.putDouble("flipper_back",     0.25);
		SmartDashboard.putInt   ("flipper_waittime", 250);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = new DummyAutonomous();
    	if (teleopCommand     != null) teleopCommand.cancel();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /** This function is called periodically during autonomous */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        teleopCommand = new TeleOp();
        if (autonomousCommand != null) autonomousCommand.cancel();
        if (teleopCommand     != null) teleopCommand.start();
    }

    /** This function is called periodically during operator control */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /** This function is called periodically during test mode */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
