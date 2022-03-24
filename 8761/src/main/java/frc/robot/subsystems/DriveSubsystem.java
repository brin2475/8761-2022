// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DriveSubsystem extends SubsystemBase {
  private PWMSparkMax Left, Right;
    private DifferentialDrive drive;
    
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    Left = new PWMSparkMax(Constants.Left);
    Right = new PWMSparkMax(Constants.Right);
    
    drive = new DifferentialDrive(Left, Right);
    drive.setSafetyEnabled(false);  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Pilot(double speed, double rotation){
    drive.arcadeDrive(speed, rotation);
  }

  public void autoDrive(double speed, double turn){
    autoDrive(speed, turn);
  }

  public void stop(){
    drive.stopMotor();
  }
}
