// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;


public class AshleyArts2 extends SequentialCommandGroup {
  public AshleyArts2(Drive m_robotDrive) {        
    Trajectory trajectory1 = m_robotDrive.loadTrajectoryFromFile("AshleyArts2");

    
    addCommands(
        new InstantCommand(() -> {
            m_robotDrive.resetOdometry(trajectory1.getInitialPose());
        }),
        m_robotDrive.createCommandForTrajectory(trajectory1, false).withTimeout(50).withName("AshleyArts2"));
}
}
