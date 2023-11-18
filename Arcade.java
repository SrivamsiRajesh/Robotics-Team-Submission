import com.revrobotics.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;

// We have imported all the revrobotics packages using * and joystick package to retrieve inputs from the joystick or controller 

// The vars for the program are lMotor(Left Motor) and rMotor(Right Motor)
CANSparkMax lMotor = new CANSparkMax(1, MotorType.kBrushless);
leftMotor.setInverted(false);
leftMotor.set(0.5);

CANSparkMax rMotor = new CANSparkMax(2, MotorType.kBrushless);
rightMotor.setInverted(false);
rightMotor.set(0.5);

DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

Joystick joystick = new Joystick(0);

double speed = joystick.getY();
double rotation = joystick.getX();

drive.arcadeDrive(speed, rotation);
