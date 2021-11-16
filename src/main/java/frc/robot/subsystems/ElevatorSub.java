// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSub extends SubsystemBase {
  private TalonFX leftMotor;
  private TalonFX rightMotor;
  private Encoder encoder;



  /** Creates a new ExampleSubsystem. */
  public ElevatorSub(TalonFX leftMotor, TalonFX rightMotor, Encoder encoder) {
    this.leftMotor = leftMotor;
    this.rightMotor = rightMotor;
    this.encoder = new Encoder(null, null);
  }

  public void setPower(double power) {
    leftMotor.set(ControlMode.PercentOutput, power);
    rightMotor.set(ControlMode.PercentOutput, power);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
