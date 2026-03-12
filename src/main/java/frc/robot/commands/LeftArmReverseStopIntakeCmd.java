// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class LeftArmReverseStopIntakeCmd extends Command {

  private final ArmSubsystem arm;
  private final IntakeSubsystem intake;

  public LeftArmReverseStopIntakeCmd(ArmSubsystem arm, IntakeSubsystem intake) {
    this.arm = arm;
    this.intake = intake;

    addRequirements(arm, intake);
  }

  @Override
  public void initialize() {
    intake.stopLeftIntake();   // force intake OFF
  }

  @Override
  public void execute() {
    arm.LeftArmTalonFX(-0.15);  // reverse speed
  }

  @Override
  public void end(boolean interrupted) {
    arm.LeftArmTalonFX(0);     // stop arm when released
  }

  @Override
  public boolean isFinished() {
    return false; // runs while held
  }
}
