// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DistanceMotor extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ExampleSubsystem m_subsystem;
    private final double m_requiredDistance;
    double dist = 0;
    double speed = 0;

    /**
     * Creates a new DistanceMotor.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DistanceMotor(ExampleSubsystem subsystem, double requiredDistance) {
        m_subsystem = subsystem;
        m_requiredDistance = requiredDistance;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        dist = m_subsystem.testeruno.getEncoder().getPosition(); 
        if (dist < m_requiredDistance) {
            speed = 0.2;
        } else {
            speed = -0.2;
        }
        //m_subsystem.testeruno.set(speed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        dist = m_subsystem.testeruno.getEncoder().getPosition();
        double calc =  m_subsystem.slowDown.calculate(dist, m_requiredDistance);
        if(calc > 0.2) {
            calc = 0.2;
        } else if (calc < -0.2) {
            calc = -0.2;
        }
        m_subsystem.testeruno.set(calc);
        System.out.println("Current distance:" + dist + " Target Distance: " + m_requiredDistance + " PID calculation: " + m_subsystem.slowDown.calculate(dist, m_requiredDistance));

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_subsystem.testeruno.set(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (speed > 0) {
            if (dist >= m_requiredDistance) {
                return true;
            } else {
                return false;
            }
        } else if (speed < 0) {
            if (dist <= m_requiredDistance) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}