// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PaddedXbox;
import frc.robot.subsystems.ElevatorSub;

public class RunElevator extends CommandBase {
  private ElevatorSub elev;
  private PaddedXbox xbox;
  /** Creates a new RunElevator. */
  public RunElevator(ElevatorSub elevator, PaddedXbox xbox) {
    this.elev = elevator;
    this.xbox = xbox;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.elev);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.elev.setPower(this.xbox.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.elev.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
