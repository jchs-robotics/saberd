// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class IndexSubsystem extends SubsystemBase {
  private TalonFX IndexTalonFX = new TalonFX(14);
  /** Creates a new IndexSubsystem. */
  public IndexSubsystem() {
    IndexTalonFX.getConfigurator().apply(ShooterConstants.configs);

    IndexTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    IndexTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Index Percent Output", IndexTalonFX.get());
  }

  public void IndexTalonFX(double setpoint) {
    IndexTalonFX.set(setpoint);
  }

}
