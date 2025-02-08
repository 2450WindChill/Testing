package frc.robot.commands;

import frc.robot.subsystems.CoralSubsystem;

import javax.swing.text.html.parser.ContentModel;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class MoveElevatorToPosition extends Command {
  private final CoralSubsystem m_coralSubsystem;
  double m_target;
  double tolerance;

  private ProfiledPIDController controller = new ProfiledPIDController(0, 0, 0, new Constraints(0.5, 1));

  public MoveElevatorToPosition(CoralSubsystem coralSubsystem, double target) {
    m_coralSubsystem = coralSubsystem;
    m_target = target;

    addRequirements(m_coralSubsystem);
  }

  public void initialize() {
    controller.reset(m_coralSubsystem.getElevatorMotorFx().getPosition().getValueAsDouble());
    controller.setGoal(m_target);
    controller.setTolerance(tolerance);
  }

  public void execute() {
    m_coralSubsystem.getElevatorMotorFx().set(controller.calculate(m_coralSubsystem.getElevatorMotorFx().getPosition().getValueAsDouble()));
  }

  public void end(boolean interrupted) {
    m_coralSubsystem.getElevatorMotorFx().set(0);
  }

  public boolean isFinished() {
    return controller.atGoal();
  }
}
