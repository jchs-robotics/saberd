// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  private TalonFX LeftTopShooterTalonFX = new TalonFX(13);
  private TalonFX LeftBottomShooterTalonFX = new TalonFX(23);
  private TalonFX RightTopShooterTalonFX = new TalonFX(16);
  private TalonFX RightBottomShooterTalonFX = new TalonFX(17);



  public ShooterSubsystem() {
    LeftTopShooterTalonFX.getConfigurator().apply(ShooterConstants.configs);
    LeftBottomShooterTalonFX.getConfigurator().apply(ShooterConstants.configs);
    RightTopShooterTalonFX.getConfigurator().apply(ShooterConstants.configs);
    RightBottomShooterTalonFX.getConfigurator().apply(ShooterConstants.configs);

    LeftTopShooterTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    LeftTopShooterTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    LeftBottomShooterTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    LeftBottomShooterTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    RightTopShooterTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    RightTopShooterTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);

    RightBottomShooterTalonFX.getConfigurator().refresh(ShooterConstants.currentLimits);
    RightBottomShooterTalonFX.getConfigurator().apply(ShooterConstants.currentLimits);


  }

  /**
   * Method to run the shooter at a particular setpoint.
   * @param setpoint the percent output at which the shooter should run.
   */
  public void runShooter(double setpoint) {
    LeftTopShooterTalonFX.set(setpoint);
    LeftBottomShooterTalonFX.set(setpoint);
    RightTopShooterTalonFX.set(setpoint);
    RightBottomShooterTalonFX.set(setpoint);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("LTShooter Percent Output", LeftTopShooterTalonFX.get());
    SmartDashboard.putNumber("LBShooter Percent Output", LeftBottomShooterTalonFX.get());
    SmartDashboard.putNumber("RTShooter Percent Output", RightTopShooterTalonFX.get());
    SmartDashboard.putNumber("RBShooter Percent Output", RightBottomShooterTalonFX.get());
  }

  public void LeftTopShooterTalonFX(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'LeftTopShooterTalonFX'");
  }

  public void LeftBottomShooterTalonFX(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'LeftBottomShooterTalonFX'");
  }

public void RightTopShooterTalonFX(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'RightTopShooterTalonFX'");
}

public void RightBottomShooterTalonFX(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'RightBottomShooterTalonFX'");
}
}
