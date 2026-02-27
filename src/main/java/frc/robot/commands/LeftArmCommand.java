package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class LeftArmCommand extends Command {
    private ArmSubsystem armSubsystem;

    public LeftArmCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
        
    }

    @Override
    public void initialize() {}


    @Override
    public void execute() {
        armSubsystem.LeftArmTalonFX(0.5);
        System.out.println("Left Arm Running");
    }

    @Override 
    public void end(boolean interrupted) {
        armSubsystem.LeftArmTalonFX(0);
        System.out.println("Left Arm Stopped");

    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
