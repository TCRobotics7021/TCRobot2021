// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ResetSmartDashboard extends CommandBase {
  /** Creates a new ResetSmartDashboard. */
  public ResetSmartDashboard() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Set Top Rpms 1", 0);
    SmartDashboard.putNumber("Set Top Rpms 2", 0);
    SmartDashboard.putNumber("Set Top Rpms 3", 0);
    SmartDashboard.putNumber("Set Top Rpms 4", 0);
    SmartDashboard.putNumber("Set Top Rpms 5", 0);
    SmartDashboard.putNumber("Set Bot Rpms 1", 0);
    SmartDashboard.putNumber("Set Bot Rpms 2", 0);
    SmartDashboard.putNumber("Set Bot Rpms 3", 0);
    SmartDashboard.putNumber("Set Bot Rpms 4", 0);
    SmartDashboard.putNumber("Set Bot Rpms 5", 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
