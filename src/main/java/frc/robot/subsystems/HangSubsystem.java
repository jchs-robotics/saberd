// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class HangSubsystem extends SubsystemBase {
  /** Creates a new HangSubsystem. */
  private TalonFX LeftHangTalonFX = new TalonFX(24);
  private TalonFX RightHangTalonFX = new TalonFX(25);
  public HangSubsystem() {
    LeftHangTalonFX.getConfigurator().apply(ShooterConstants.configs);

    LeftHangTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    LeftHangTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    RightHangTalonFX.getConfigurator().apply(ShooterConstants.configs);

    RightHangTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    RightHangTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    LeftHangTalonFX.setNeutralMode(NeutralModeValue.Brake);
    RightHangTalonFX.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Index Percent Output", LeftHangTalonFX.get());
    SmartDashboard.putNumber("Index Percent Output", RightHangTalonFX.get());
  }

  public void LeftHangTalonFX(double setpoint) {
    LeftHangTalonFX.set(setpoint);
  }

  public void RightHangTalonFX(double setpoint) {
    RightHangTalonFX.set(setpoint);
  }
}
