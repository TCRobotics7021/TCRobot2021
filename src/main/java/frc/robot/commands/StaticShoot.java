// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class StaticShoot extends CommandBase {
  /** Creates a new ChallengeFourShooting. */
  double TX;

  double Top_Rpms;
  
  double Bot_Rpms;

  double Time_Delay; 

  Timer TDelay = new Timer(); 

  int Distance;
  
  double turretSpeed;

  boolean shootingStarted;



  public StaticShoot(int Distance) {
    this.Distance = Distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.Accumulator_subsystem);
    addRequirements(RobotContainer.Limelight_subsystem);
    addRequirements(RobotContainer.shooter_subsystem);
    addRequirements(RobotContainer.Turret_subsystem);    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    TDelay.reset();
    TDelay.start();
    shootingStarted = false;
    RobotContainer.Limelight_subsystem.setPipeline(1);
    if(Distance == 1){
      Top_Rpms = 3400;

      Bot_Rpms = 3500;
    }
    if(Distance == 2){
      Top_Rpms = 3150;

      Bot_Rpms = 3500;
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
      if(RobotContainer.OPpanel.getRawButton(4)== false){
        if(shootingStarted == false){
        TX = RobotContainer.Limelight_subsystem.getTx();
        turretSpeed = TX * 1/10;
        if(turretSpeed < 0){
          turretSpeed -= 0;
        }else{
          turretSpeed += 0;
        }
        if (turretSpeed > .5) {
          turretSpeed = .5;
        } 
        if (turretSpeed < -.5) {
          turretSpeed = -.5;    }
      }else{
        turretSpeed = 0;
      }
        RobotContainer.Turret_subsystem.setSpeed(turretSpeed);

      RobotContainer.shooter_subsystem.setRpms(Top_Rpms, Bot_Rpms);

      if(TDelay.hasElapsed(2)) {
        RobotContainer.Accumulator_subsystem.setSpeed(RobotContainer.ACC_EMPTY_SPEED);
        RobotContainer.Intake_subsystem.set_Intake_Speed(0, .6);
        shootingStarted = true;
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooter_subsystem.setRpms(0, 0);
    RobotContainer.Accumulator_subsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
