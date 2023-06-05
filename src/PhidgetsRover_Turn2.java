//Add Phidgets Library
import com.phidget22.*;

public class PhidgetsRover_Turn2{
    public static void main(String[] args) throws Exception {

        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();

        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(3000);
        rightMotors.open(3000);

       // 1.38 seconds per m, 1.28 seconds per m, 1.31 seconds per m average 1.323 repeating seconds per m (100% speed)
        leftMotors.setTargetVelocity(0.5);
        rightMotors.setTargetVelocity(0.5);

        //Wait for 2 second
        Thread.sleep(2000);

        //Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        
        Thread.sleep(2000);
        
        //turn 180
        leftMotors.setTargetVelocity(0.3);
        rightMotors.setTargetVelocity(-0.3);
        
        Thread.sleep(2600);
        
        //Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        
        Thread.sleep(2000);
        
        leftMotors.setTargetVelocity(0.5);
        rightMotors.setTargetVelocity(0.5);

        Thread.sleep(2000);
        
    }
}
  