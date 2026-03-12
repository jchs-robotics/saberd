// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.encoder.*;
import com.revrobotics.spark.config.EncoderConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants.ArmConstants;



public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private TalonFX LeftArmTalonFX = new TalonFX(19);
  private TalonFX RightArmTalonFX = new TalonFX(21);

  // left encoder
  public final double leftArmEncoder = LeftArmTalonFX.getPosition().getValueAsDouble();


  // right encoder
  public final double rightArmEncoder = RightArmTalonFX.getPosition().getValueAsDouble();


  public ArmSubsystem() {
    LeftArmTalonFX.getConfigurator().apply(ArmConstants.configs);
    RightArmTalonFX.getConfigurator().apply(ArmConstants.configs);



    LeftArmTalonFX.getConfigurator().refresh(ArmConstants.currentLimits);
    LeftArmTalonFX.getConfigurator().apply(ArmConstants.currentLimits);


    RightArmTalonFX.getConfigurator().refresh(ArmConstants.currentLimits);
    RightArmTalonFX.getConfigurator().apply(ArmConstants.currentLimits);

    LeftArmTalonFX.setNeutralMode(NeutralModeValue.Brake);
    RightArmTalonFX.setNeutralMode(NeutralModeValue.Brake);

    MotorOutputConfigs rightMotorOutput = new MotorOutputConfigs();
    rightMotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    // invert the right motor
    RightArmTalonFX.getConfigurator().apply(rightMotorOutput);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Arm Encoder", getLeftEncoder());
    SmartDashboard.putNumber("Right Arm Encoder", getRightEncoder());
  }

  public void zeroEncoders() {
    LeftArmTalonFX.setPosition(0);
    RightArmTalonFX.setPosition(0);
}

  public double getLeftEncoder() {
    return LeftArmTalonFX.getPosition().getValueAsDouble();
}

public double getRightEncoder() {
    return RightArmTalonFX.getPosition().getValueAsDouble();
}


  public void LeftArmTalonFX() {
    LeftArmTalonFX.setPosition(0);
  }

  public void LeftArmTalonFX(double setpoint){
    LeftArmTalonFX.set(setpoint);
  }

  public void RightArmTalonFX(double setpoint){
    RightArmTalonFX.setPosition(setpoint);
  }


  public void RightArmTalonFX() {
    RightArmTalonFX.setPosition(0);
  }


  


  public boolean stopfighting(double endpoint) {
    if (rightArmEncoder < (endpoint + 2) && rightArmEncoder > (endpoint -2)) {
      return true;
    } else {
      return false;
    }
  }
}
