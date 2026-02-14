// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShooterCommand extends Command {

  private ShooterSubsystem shooterSubsystem;
  /** Creates a new ShooterCommand. */
  public ShooterCommand(ShooterSubsystem shooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(this.shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.runLeftShooter(-1);
    System.out.println("Left Shooter Running");
  }

  @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stopLeftShooter(0);
        System.out.println("Left Shooter stopped");
    }

  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
