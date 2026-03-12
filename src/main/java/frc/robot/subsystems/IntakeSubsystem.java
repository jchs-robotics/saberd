// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class IntakeSubsystem extends SubsystemBase {

  private TalonFX LeftIntakeTalonFX = new TalonFX(18);
  private TalonFX RightIntakeTalonFX = new TalonFX(15);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    LeftIntakeTalonFX.getConfigurator().apply(ShooterConstants.configs);
    RightIntakeTalonFX.getConfigurator().apply(ShooterConstants.configs);

    LeftIntakeTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    LeftIntakeTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    RightIntakeTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    RightIntakeTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Intake Percent Output", LeftIntakeTalonFX.get());
    SmartDashboard.putNumber("Right Intake Percent Output", RightIntakeTalonFX.get());
  }

  public void LeftIntakeTalonFX(double setpoint) {
    LeftIntakeTalonFX.set(setpoint);
  }

  private boolean leftIntakeRunning = false;
  private double lintakeSpeed = 0.7;

  public void toggleLeftIntake() {
    leftIntakeRunning = !leftIntakeRunning;

    if (leftIntakeRunning) {
      LeftIntakeTalonFX(lintakeSpeed);
    } else {
      LeftIntakeTalonFX(0);
    }
  }

  public void stopLeftIntake() {
    leftIntakeRunning = false;
    LeftIntakeTalonFX(0);
  }

  private boolean rightIntakeRunning = false;
  private double rintakeSpeed = -0.7;

  public void toggleRightIntake() {
    rightIntakeRunning = !rightIntakeRunning;

    if (rightIntakeRunning) {
      RightIntakeTalonFX(rintakeSpeed);
    } else {
      RightIntakeTalonFX(0);
    }
  }

  public void stopRightIntake() {
    rightIntakeRunning = false;
    RightIntakeTalonFX(0);
  }

  public void RightIntakeTalonFX(double setpoint) {
    RightIntakeTalonFX.set(setpoint);
  }

  
}
