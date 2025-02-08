// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix.led.CANdle;
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
    }
    
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("elevator encoder", elevatorMotor.getPosition().getValueAsDouble());
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
