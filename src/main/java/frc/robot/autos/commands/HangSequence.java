// Copyright (c) 2024 FRC 3256
// https://github.com/Team3256
//
// Use of this source code is governed by a 
// license that can be found in the LICENSE file at
// the root directory of this project.

package frc.robot.autos.commands; 
// .commands comes from the file that it is in. the rest of it comes automatically when you create a java file.

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.helpers.DebugCommandBase;
import frc.robot.subsystems.climb.Climb;
import java.util.LinkedList;
//do not have to directly import when importing from two documents in same file?

public class HangSequence extends DebugCommandBase {
  // extends - inherits from another class; DebugCommandBase is imported as you can see above in the import statements
  private CommandXboxController operatorController;
  // CommandXboxController is already included in a library -- check import statements
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int secondaryAxis = XboxController.Axis.kRightY.value;
  //kRightY and kLeftY are constants indicated by the k
  Climb climbSubsystem;
  // Climb is imported 

  public HangSequence(Climb climb, CommandXboxController operator) {
    climbSubsystem = climb;
    operatorController = operator;
    addRequirements(climbSubsystem);
  }

  @Override
  public void initialize() {
    CommandScheduler.getInstance().cancelAll();
    LinkedList<Command> CommandList = new LinkedList<>();

    Command killAllCommands =
        new InstantCommand(
            () -> {
              CommandScheduler.getInstance().cancelAll();
            });

    if (Constants.FeatureFlags.kClimbEnabled) {
      // Command un_hooker = new DehookClimb(climbSubsystem);
      Command grave = climbSubsystem.retractClimber(); // we dont use this so idc that i broke it

      // CommandList.add(un_hooker);
      CommandList.add(grave);
    }

    // Command nextCommandTriggerDown =
    // new InstantCommand(
    // () -> {
    // if (!CommandList.isEmpty() && (timesCommandTriggered & 2) == 0) {
    // Command nextCommand = CommandList.pop();
    // CommandList.add(nextCommand);
    // nextCommand.schedule();
    // }
    // });

    // new Trigger(() -> operatorController.getRawAxis(translationAxis) < -0.5)
    // .onTrue(nextCommandTriggerDown);
    // new Trigger(() -> Math.abs(operatorController.getRawAxis(secondaryAxis)) >
    // 0.5)
    // .onTrue(killAllCommands);
  }
}
