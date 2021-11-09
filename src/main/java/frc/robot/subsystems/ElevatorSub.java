// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private TalonFX leftMotor; 
  private TalonFX rightMotor; 

  public ElevatorSub() {
    leftMotor = new TalonFX(CanIDs.leftFalcon.id);
    rightMotor = new TalonFX(CanIDs.rightFalcon.id);

    right.setInverted(true);
  
  }

  public void setLeftPower(double power){
    left.set(ControlMode.PercentOutput, power);
  }
  
  public void setRightPower(double power){ 
    right.set(ControlMode.PercentOutput, power);
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
