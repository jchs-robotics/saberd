// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private TalonFX LeftArmTalonFX = new TalonFX(19);
  private TalonFX RightArmTalonFX = new TalonFX(21);

  public ArmSubsystem() {
    LeftArmTalonFX.getConfigurator().apply(ShooterConstants.configs);
    RightArmTalonFX.getConfigurator().apply(ShooterConstants.configs);

    LeftArmTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    LeftArmTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    RightArmTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    RightArmTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Arm Percent Output", LeftArmTalonFX.get());
    SmartDashboard.putNumber("Right Arm Percent Output", RightArmTalonFX.get());
  }

  public void LeftArmTalonFX(double setpoint) {
    LeftArmTalonFX.set(setpoint);
  }

  public void RightArmTalonFX(double setpoint) {
    RightArmTalonFX.set(setpoint);
  }
}
