// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  // Initialize shooterMotors
  private TalonFX leftShooterMotor = new TalonFX(13);



  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    // configure the motor's factory default settings
    leftShooterMotor.getConfigurator().apply(ShooterConstants.configs);

    // apply current configuration to the motor
    leftShooterMotor.getConfigurator().refresh(ShooterConstants.currentLimits);
    leftShooterMotor.getConfigurator().apply(ShooterConstants.currentLimits);
  }

  /**
   * Method to run the shooter at a particular setpoint.
   * @param setpoint the percent output at which the shooter should run.
   */

  public void runLeftShooter(double setpoint) {
    leftShooterMotor.set(setpoint);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Percent output", leftShooterMotor.get());
  }

  public void stopLeftShooter(int i) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stopLeftShooter'");
  }

public Command shooterCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'shooterCommand'");
}
}
