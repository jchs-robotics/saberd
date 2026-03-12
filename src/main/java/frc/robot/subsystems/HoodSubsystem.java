// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class HoodSubsystem extends SubsystemBase {
  private TalonFX HoodTalonFX = new TalonFX(20);
  /** Creates a new HoodSubsystem. */
  public HoodSubsystem() {
    HoodTalonFX.getConfigurator().apply(ShooterConstants.configs);

    HoodTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    HoodTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hood Percent Output", HoodTalonFX.get());
  }

  public void HoodTalonFX(double setpoint) {
    HoodTalonFX.set(setpoint);
  }

}
