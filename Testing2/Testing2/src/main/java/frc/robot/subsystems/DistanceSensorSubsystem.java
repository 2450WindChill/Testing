package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class DistanceSensorSubsystem extends SubsystemBase {

  // Creating distancesensor
  Rev2mDistanceSensor distanceSensor = new Rev2mDistanceSensor(Port.kOnboard); 

  /** Creates a new ExampleSubsystem. 
     * @return */
    public void ExampleSubsystem() {
  }

  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
        });
  }

  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void periodic() {
    double range = distanceSensor.getRange();
    System.out.println("Range: " + range); 
  }

  @Override
  public void simulationPeriodic() {
  }
}
