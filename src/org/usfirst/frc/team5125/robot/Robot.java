package org.usfirst.frc.team5125.robot;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class Robot extends SampleRobot {

		VictorSP blMotor = new VictorSP (0);
		VictorSP tlMotor = new VictorSP (1);
		VictorSP trMotor = new VictorSP (2);
		VictorSP brMotor = new VictorSP (3);
		Joystick leftStick = new Joystick(0);
		Joystick rightStick = new Joystick(1);
		Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		double dist = 0.0;
		ADXRS450_Gyro gyro = new ADXRS450_Gyro();

		public Robot() {
			enc.setDistancePerPulse(1/1440);
			gyro.calibrate();
			gyro.reset();
		}

	public void operatorControl() {
		
		while (isOperatorControl() && isEnabled()) {
			tlMotor.set(Math.pow(-leftStick.getY(), 3)); 
			blMotor.set(Math.pow(-leftStick.getY(), 3));

			trMotor.set(Math.pow(rightStick.getY(), 3));
			brMotor.set(Math.pow(rightStick.getY(), 3));
		}
	}
	
	public void autonomous() {
		
	}
	
}