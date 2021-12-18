// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSub;
/** Moves the Elevator a certain distance. */
public class MoveElevatorDistance extends CommandBase {
  private ElevatorSub elevator;
  private double distance;
  private double initdist;
  private boolean dir;
  /** Creates a new MoveElevatorDistance. 
   * @param dist The distance to move the elevator (positive for up, negative for down)
  */
  public MoveElevatorDistance(ElevatorSub elev, double dist) {
    this.elevator = elev;
    this.distance = dist;
    this.dir = this.distance > 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.initdist = this.elevator.getEncoder().get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (dir) {
      this.elevator.setPower(0.25);
    } else {
      this.elevator.setPower(-0.25);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.elevator.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (dir) {
      return this.initdist + this.distance <= this.elevator.getEncoder().get();
    }
    return this.initdist + this.distance >= this.elevator.getEncoder().get();
  }
}
