// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DistanceMotor;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LEDBlueCommand;
import frc.robot.commands.LEDFireCommand;
import frc.robot.commands.LEDStrobeCommand;
import frc.robot.commands.MoveElevatorToPosition;
import frc.robot.commands.SwitchMotor;
import frc.robot.commands.TimeMotor;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.ColorSensorV3.LEDPulseFrequency;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final CoralSubsystem m_CoralSubsystem= new CoralSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  // private final CommandXboxController m_driverController =
  //     new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight 
   * joysticks}.
   */
  private void configureBindings() {
    ShuffleboardTab tab = Shuffleboard.getTab("testing");
    // tab.add("TimeMotor", new TimeMotor(m_exampleSubsystem)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("EncoderReseter", Commands.runOnce(() -> m_exampleSubsystem.resetEncoder())).withWidget(BuiltInWidgets.kCommand);
    // tab.add("DistanceMotor116", new DistanceMotor(m_CoralSubsystem, 116.0)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("DistanceMotor50", new DistanceMotor(m_CoralSubsystem, 50.0)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("SwitchMotor", new SwitchMotor(m_exampleSubsystem)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("LEDBlue", new LEDBlueCommand(m_exampleSubsystem)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("LEDFire", new LEDFireCommand(m_exampleSubsystem)).withWidget(BuiltInWidgets.kCommand);
    // tab.add("LEDStrobe", new LEDStrobeCommand(m_exampleSubsystem)).withWidget(BuiltInWidgets.kCommand);
    tab.add("100", new MoveElevatorToPosition(m_CoralSubsystem, 100)).withWidget(BuiltInWidgets.kCommand);
    tab.add("0", new MoveElevatorToPosition(m_CoralSubsystem, 0)).withWidget(BuiltInWidgets.kCommand);


    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.x().whileTrue(new ExampleCommand(m_exampleSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return new InstantCommand();
  }
}
