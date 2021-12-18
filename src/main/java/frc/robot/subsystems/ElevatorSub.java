// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import static frc.robot.Constants.*;

public class ElevatorSub extends SubsystemBase {
  private TalonFX lmotor;
  private TalonFX rmotor;
  private Encoder encoder;
  //private LimitSwitchNormal limSwitch;
  /** Creates a new ElevatorSub. */
  public ElevatorSub(TalonFX left, TalonFX right, Encoder encoder) {
    this.lmotor = left;
    this.rmotor = right;
    this.encoder = encoder;
    //this.limSwitch = limitSwitch;
    this.lmotor.setInverted(true);
    //this.lmotor.setNeutralMode(NeutralMode.Brake);
    //this.rmotor.setNeutralMode(NeutralMode.Brake);
    //this.encoder.setDistancePerPulse(DISTANCE_PER_REVOLUTION);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder value:", this.encoder.get());
    // This method will be called once per scheduler run
    /*if (this.encoder.getDistance() >= ELEVATOR_HEIGHT - 0.5) {
      this.setPower(0);
    } else if (this.encoder.getDistance() <= 0.5) {
      this.setPower(0);
    }*/
  }
  public void setPower(double power) {
    this.lmotor.set(ControlMode.PercentOutput, power);
    this.rmotor.set(ControlMode.PercentOutput, power);
  }
  public TalonFX getLeft() {
    return this.lmotor;
  }
  public TalonFX getRight() {
    return this.rmotor;
  }
  public Encoder getEncoder() {
    return this.encoder;
  }
}
