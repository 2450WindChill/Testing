package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class DistanceSensorSubsystem extends SubsystemBase {
  // Create an I2C instance for communication with the sensor
  //private final int I2C_PORT = 0;
  
  // Create an I2C object to communicate with the sensor
  //I2C distanceSensor = new I2C(I2C_PORT);

  REV2mDistanceSensor distanceSensor = new REV2mDistanceSensor(I2C.Port.kOnboard); 

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
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
    double distance = distanceSensor.getDistance();
    System.out.println("Distance: " + distance); 
  }

  @Override
  public void simulationPeriodic() {
  }
}
