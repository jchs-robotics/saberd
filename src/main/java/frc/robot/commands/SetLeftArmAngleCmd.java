// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.ArmSubsystem;

// /* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
// public class SetLeftArmAngleCmd extends Command {
//   /** Creates a new SrtLeftArmAngleCmd. */
//   private final ArmSubsystem arm;
//     private final double target;

//   public SetLeftArmAngleCmd(ArmSubsystem arm, double targetDegrees) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     this.arm = arm;
//         this.target = targetDegrees;
//         addRequirements(arm);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     arm.setLeftTarget(target);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     arm.setLeftTarget(target);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return arm.leftAtSetpoint();
    
//   }
// }
