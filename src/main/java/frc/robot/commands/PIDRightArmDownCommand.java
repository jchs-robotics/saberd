// package frc.robot.commands;

// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.ArmSubsystem;
// import edu.wpi.first.wpilibj.DutyCycleEncoder;

// public class PIDRightArmDownCommand extends Command{
//     private final ArmSubsystem armSubsystem;
//     private final PIDController pidController;
//     private final double endpoint;

//     public PIDRightArmDownCommand(ArmSubsystem armSubsystem, double setpoint) {
//         this.armSubsystem = armSubsystem;
//         this.pidController = new PIDController(0.1, 0, 0.01); //set values (finalized versions go to constants)
//         pidController.setSetpoint(setpoint);
//         endpoint = setpoint;
//         addRequirements(armSubsystem);
//         DutyCycleEncoder m_encoder = new DutyCycleEncoder(0);
//     }

//     @Override
//     public void initialize() {
//         System.out.println("PID Command Starting");
//         pidController.reset();
//     }

//     @Override
//     public void execute() {
//         double speed = pidController.calculate(armSubsystem.rightArmEncoder); //set encoders in subsystem (wont work as is currently)
//         armSubsystem.setMotors(speed);
//     }

//     @Override 
//     public void end(boolean interrupted) {
//         armSubsystem.setMotors(0);
//         System.out.println("PID Command Over");
//     }

//     @Override
//     public boolean isFinished() {
//         return armSubsystem.stopfighting(endpoint);
//     }

// }
