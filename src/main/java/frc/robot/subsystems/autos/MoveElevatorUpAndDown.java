package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ElevatorSub;
import frc.robot.subsystems.RunElevator;

public class MoveElevatorUpAndDown extends SequentialCommandGroup {
    private ElevatorSub elevatorSub;
    private double power;

    public MoveElevatorUpAndDown(ElevatorSub elevator, double power) {
        addCommands(new RunElevator(elevatorSub, power));
        addCommands(new RunElevator(elevatorSub, -power));

    }
}
