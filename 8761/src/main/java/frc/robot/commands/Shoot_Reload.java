// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot_Reload extends SequentialCommandGroup {
  /** Creates a new Shoot_Reload. */
  public Shoot_Reload(
  DriveSubsystem drive, 
  CannonSubsystem cannon, 
  IntakeSubsystem intake) {

addCommands(

      new StartEndCommand(() ->  drive.autoDrive(0.0,0.0), () -> drive.stop(), drive).withTimeout(0),
      
        new StartEndCommand(() -> intake.Autointake(0.0), () -> intake.stop(), intake).withTimeout(0),
      
      new StartEndCommand(() -> drive.autoDrive(0.0, 0.0), () -> drive.stop(), drive).withTimeout(0)
     

    /**
     *  new StartEndCommand(() -> drive.autoDrive(0.0, 0.0), () -> drive.stop(), drive).withTimeout(2.0),
      
      new StartEndCommand(() -> cannon.Autoshoot(1.0), () -> cannon.Stop(), cannon).withTimeout(6.0),
        
        new StartEndCommand(() -> drive.autoDrive(0.0, 1.0), () -> drive.stop(), drive).withTimeout(1.0)
     */
      );

    
  }
}
