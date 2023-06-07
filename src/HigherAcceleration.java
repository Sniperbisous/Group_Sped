
//Add Phidgets Library
import com.phidget22.*;

public class HigherAcceleration 
{
	   public static void main(String[] args) throws Exception 
	   {

	       //Connect to wireless rover
	       Net.addServer("", "192.168.100.1", 5661, "", 0);

	       //Create
	       DCMotor leftMotors = new DCMotor();
	       DCMotor rightMotors = new DCMotor();

	       //Address
	       leftMotors.setHubPort(5);
	       leftMotors.setChannel(0);
	       rightMotors.setHubPort(5);
	       rightMotors.setChannel(1);

	       //Open
	       leftMotors.open(5000);
	       rightMotors.open(5000);

	       //Increase acceleration
	       leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
	       rightMotors.setAcceleration(rightMotors.getMaxAcceleration());

	       //Move forward at full speed
	       leftMotors.setTargetVelocity(1);
	       rightMotors.setTargetVelocity(1);

	       //Wait for 1 second
	       Thread.sleep(1000);

	       //Reverse at full speed
	       leftMotors.setTargetVelocity(-1);
	       rightMotors.setTargetVelocity(-1);

	       //Wait for 1 second
	       Thread.sleep(1000);

	       //Stop motors
	       leftMotors.setTargetVelocity(0);
	       rightMotors.setTargetVelocity(0);
	   }
	}
	
