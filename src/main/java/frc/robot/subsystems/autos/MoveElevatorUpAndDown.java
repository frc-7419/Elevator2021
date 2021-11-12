package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.elevator.ElevatorSub;
import frc.robot.subsystems.elevator.RunElevator;

public class MoveElevatorUpAndDown extends SequentialCommandGroup {
    public MoveElevatorUpAndDown(ElevatorSub elevator, double power) {
        addCommands(new RunElevator(elevator, power));
        addCommands(new RunElevator(elevator, -power));
    }
}
