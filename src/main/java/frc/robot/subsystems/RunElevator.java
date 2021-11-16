// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.PaddedXbox;

public class RunElevator extends CommandBase {
  private ElevatorSub elevatorSub;
  private PaddedXbox paddedXbox;
  private double power;

  /** Creates a new ExampleSubsystem. */
  public RunElevator(ElevatorSub elevatorSub, PaddedXbox paddedXbox, double power) {
    this.elevatorSub = elevatorSub;
    this.paddedXbox = paddedXbox;
    this.power = power;
  }

  public RunElevator(ElevatorSub elevatorSub, double power) {
    this.elevatorSub = elevatorSub;
    this.power = power;
  }

  

  public void initialize() {
  }

  public void execute(double power) {
    elevatorSub.setPower(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevatorSub.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}
