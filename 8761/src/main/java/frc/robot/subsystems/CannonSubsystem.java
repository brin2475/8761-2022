// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class CannonSubsystem extends SubsystemBase {
  private WPI_TalonSRX Master, Slave;
  /** Creates a new CannonSubsystem. */
  public CannonSubsystem() {
    Master = new WPI_TalonSRX(Constants.Cannon_Master);
    Slave = new WPI_TalonSRX(Constants.Cannon_Slave);

  Slave.follow(Master);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot(double speed){
    Master.set(ControlMode.PercentOutput, speed);
  }

  public void Autoshoot(double speed){
    Shoot(speed);
  }

  public void Stop() {
    Master.stopMotor();
  }

  public void Reload(double reload){
    Master.set(ControlMode.PercentOutput, reload);
  }


}
