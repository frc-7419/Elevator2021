// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveElevatorDistance;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.RunElevator;
import frc.robot.subsystems.ElevatorSub;
import static frc.robot.Constants.CanIds;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private ElevatorSub elevator = new ElevatorSub(new TalonFX(CanIds.leftElevator.id), new TalonFX(CanIds.rightElevator.id), new Encoder(0, 1));
  private PaddedXbox xbox = new PaddedXbox();
  private RunElevator runelev = new RunElevator(this.elevator, this.xbox);
  //private MoveElevatorDistance mDistance = new MoveElevatorDistance(this.elevator, 30.0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(this.xbox, PaddedXbox.F310Map.kGamepadButtonA.value).whenPressed(new MoveElevatorDistance(this.elevator, 10));
  }
  
  public void setDefaultCommands() {
    this.elevator.setDefaultCommand(this.runelev);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //return this.mDistance;
    return new InstantCommand(() -> {this.elevator.setPower(0.25);}, this.elevator);
  }
}
