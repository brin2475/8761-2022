// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Shoot;
import frc.robot.commands.Shoot_Reload;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;






/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  

  private static final DriveSubsystem Drive = new DriveSubsystem();

  private static final CannonSubsystem Cannon = new CannonSubsystem();

  private static final IntakeSubsystem Intake = new IntakeSubsystem();

  private static final Joystick Gamecube = new Joystick(Constants.Gamecube);
  private static final Joystick WILLS_BORING_JOYSTICK = new Joystick(Constants.Joystick);


  

      private static SendableChooser<SequentialCommandGroup> AutoModeChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    AutoModeChooser();

    defaultSuffleBoardTab();

      
    Drive.setDefaultCommand(
      new RunCommand(
        () -> Drive.Pilot(Gamecube.getX(), -Gamecube.getZ()), Drive
)
    );
  Cannon.setDefaultCommand(
    new RunCommand(() -> Cannon.Shoot(WILLS_BORING_JOYSTICK.getY()), 
    Cannon)
  );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

    @SuppressWarnings("unused")
  private void configureButtonBindings() {

    JoystickButton trigger = new JoystickButton(WILLS_BORING_JOYSTICK, 1);

    
// When trigger held run intake
    trigger.whenHeld(
      new StartEndCommand(() -> Intake.Load(Constants.Intake), 
      () -> Intake.stop(), 
      Intake)
    );

   

  }


  private void AutoModeChooser() {
    AutoModeChooser.setDefaultOption("Shoot", new Shoot(Drive, Cannon));
    //AutoModeChooser.addOption("Shoot_Reload", new Shoot_Reload(Drive, Cannon));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   
  public Command getAutonomousCommand() {

    // An ExampleCommand will run in autonomous
    //return AutoModeChooser.getSelected();
    return  new Shoot(Drive, Cannon);
  }

public void defaultSuffleBoardTab() {
  Shuffleboard.selectTab("smartDashboard");
  SmartDashboard.putData("Auto Mode", AutoModeChooser);
}

}
