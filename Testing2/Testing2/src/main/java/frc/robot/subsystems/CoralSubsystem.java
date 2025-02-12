// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CoralSubsystem extends SubsystemBase {
    private TalonFX elevatorMotor = new TalonFX(2);
    private PIDController elevatorPidController = new PIDController(0.02, .001, 0);

    /** Creates a new ExampleSubsystem. */
    public CoralSubsystem() {
        Slot0Configs slot0Configs = new Slot0Configs();
        slot0Configs.kP = 2.4; // An error of 1 rotation results in 2.4 V output
        slot0Configs.kI = 0; // no output for integrated error
        slot0Configs.kD = 0.1; // A velocity of 1 rps results in 0.1 V output
        elevatorMotor.getConfigurator().apply(slot0Configs);

    }

    public void setPIDGoal(int position) {
        // create a position closed-loop request, voltage output, slot 0 configs
        final PositionVoltage m_request = new PositionVoltage(0).withSlot(0);

        // set position to 10 rotations
        elevatorMotor.setControl(m_request.withPosition(position));
    }

    public boolean goalReached(int goal) {
        double tolerance = 0.05;
        double currentPosition = elevatorMotor.getPosition().getValueAsDouble();
        if ((Math.abs(currentPosition - goal) < tolerance)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Encoder", elevatorMotor.getPosition().getValueAsDouble());
        SmartDashboard.putNumber("Elevator Speed", elevatorMotor.get());
    }

    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public TalonFX getElevatorMotorFx() {
        return elevatorMotor;
    }

    public PIDController getElevatorPIDcontroller() {
        return elevatorPidController;
    }

}
