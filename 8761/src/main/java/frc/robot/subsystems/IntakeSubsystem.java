// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class IntakeSubsystem extends SubsystemBase {
  private WPI_TalonSRX intakemaster;
  /** Creates a new Intake. */
  public IntakeSubsystem(){
    intakemaster = new WPI_TalonSRX(4);
  }

  public void Run(double Speed){

    intakemaster.set(ControlMode.PercentOutput, Speed);
    
  }

  public void Autointake(double IntakeSpeed) {
    Run(IntakeSpeed);
    
  }

  public void Load(double Intakespeed){
    intakemaster.set(ControlMode.PercentOutput, Intakespeed);
      }

      public void stop() {
        intakemaster.stopMotor();
      }

  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
