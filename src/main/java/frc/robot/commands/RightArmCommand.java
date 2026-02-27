package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class RightArmCommand extends Command {
    private ArmSubsystem armSubsystem;

    public RightArmCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        armSubsystem.RightArmTalonFX(1);
        System.out.println("Right Arm Running");
    }
    
    @Override 
    public void end(boolean interrupted) {
        armSubsystem.RightArmTalonFX(0);
        System.out.println("Left Arm Stopped");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
