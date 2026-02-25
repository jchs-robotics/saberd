// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShooterCommand extends Command {
  /** Creates a new ShooterCommand. */
  private ShooterSubsystem shooterSubsystem;
  public ShooterCommand(ShooterSubsystem shooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(this.shooterSubsystem);
  }

//   public ShooterCommand() {
//     //TODO Auto-generated constructor stub
// }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.LeftTopShooterTalonFX(-0.5);
    System.out.println("LTShooter Running");

    shooterSubsystem.LeftBottomShooterTalonFX(0.5);
    System.out.println("LBShooter Running");

    shooterSubsystem.RightTopShooterTalonFX(0.5);
    System.out.println("RTShooter Running");

    shooterSubsystem.RightBottomShooterTalonFX(-0.5);
    System.out.println("RBShooter Running");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.LeftTopShooterTalonFX(0);
    System.out.println("LTShooter Stopped");

    shooterSubsystem.LeftBottomShooterTalonFX(0);
    System.out.println("LBShooter Stopped");

    shooterSubsystem.RightTopShooterTalonFX(0);
    System.out.println("RTShooter Stopped");

    shooterSubsystem.RightBottomShooterTalonFX(0);
    System.out.println("RBShooter Stopped");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
