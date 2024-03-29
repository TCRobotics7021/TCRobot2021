/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoStaticShoot;
import frc.robot.commands.AutoStaticShoot2;
import frc.robot.commands.BallTracking;
import frc.robot.commands.Timed_Drive;
import frc.robot.commands.Timed_Turret;
import frc.robot.subsystems.Turret;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TrenchBallShoot extends SequentialCommandGroup {
  /**
   * Creates a new TrenchBallShoot.
   */
  public TrenchBallShoot() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(
      new Timed_Turret(.5,-1),
      new AutoStaticShoot(2.5),
      new Timed_Drive(.5, .3),
      new IntakeTrenchBalls(),
      new Timed_Drive(2.5, -.2),
      new Timed_Drive(.25, .1),
      new AutoStaticShoot2(3)
    );
  }
}
