import edu.wpi.first.wpilibj2.*;
//  We have imported all the wpilibj packages using *
public class ElevatorSubsystem {
  private CANSparkMax m1;
  private CANSparkMax m2;

  public ElevatorSubsystem() {
    m1 = new CANSparkMax(1, MotorType.kBrushless);
    m2 = new CANSparkMax(2, MotorType.kBrushless);
    // Over here, 1 and 2 are the CAD IDs.
  }

  public void raiserobo() {
    m1.set(1);
    m2.set(1);
  }

  public void lowerrobo() {
    m1.set(-1);
    m2.set(-1);
  }

  public void stoprobo() {
    m1.set(0);
    m2.set(0);
  }
}

// Elevator command connects the button with the motors.
public class ElevatorCommand extends CommandBase {
    private ElevatorSubsystem elevator;
    private JoystickButton button;

    public ElevatorCommand(ElevatorSubsystem elevator, JoystickButton button) {
        this.elevator = elevator;
        this.button = button;
        addRequirements(elevator);
    }
// When you run the program it checks if the button is pressed. If raiserobo is true then raise or else low the robo
    @Override
    public void execute() {
        if (button.get()) {
            elevator.raiserobo();
        } else {
            elevator.lowerrobo();
        }
    }
// If the program is interupted then it stops the motors and displays the elevator is stopped.
    @Override
    public void end(boolean interrupted) {
        elevator.stop();
        System.out.print("Program was interrupted and elevator has stopped ");
    }
}

