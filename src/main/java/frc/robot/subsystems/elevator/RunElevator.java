package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PaddedXbox;

public class RunElevator extends CommandBase {
    private ElevatorSub elevator;
    private Double power;
    private PaddedXbox joystick;

    public RunElevator(ElevatorSub elevator, Double power, PaddedXbox joystick){
        this.elevator = elevator;
        this.power = power;
        this.joystick = joystick;
    }

    public RunElevator(ElevatorSub elevator, Double power){
        this.elevator = elevator;
        this.power = power;
    }

    @Override
    public void initialize() {

    }

    public void execute(double power) {
        elevator.setPower(power);
    }

    public void End(boolean interrupted) {
        elevator.setPower(0);
    }

    public boolean isFinished() {
        return false;
    }
}
