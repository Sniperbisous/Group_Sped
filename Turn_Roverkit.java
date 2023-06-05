package Phidgetsrover;

//Add Phidgets Library
import com.phidget22.*;


public class Turn_Roverkit 
{

    public static void main(String[] args) throws Exception 
    {
    	
    		//Connect to wireless rover
    		Net.addServer("", "192.168.100.1", 5661, "", 0);

    		//Create
    		DCMotor leftMotors = new DCMotor();
    		DCMotor rightMotors = new DCMotor();

    	
    		//Address
    		leftMotors.setChannel(0);
    		rightMotors.setChannel(1);

    		//Open
        	leftMotors.open(5000);
        	rightMotors.open(5000);
        	
        {
        	//Turn in one direction
        	leftMotors.setTargetVelocity(1);
        	rightMotors.setTargetVelocity(-1);

        	//Wait for 2 second
        	Thread.sleep(2000);

        	//Stop motors
        	leftMotors.setTargetVelocity(0);
        	rightMotors.setTargetVelocity(0);
    	}
    	
    	//Task 1
    	{
        	//Turn in one direction
        	leftMotors.setTargetVelocity(-1);
        	rightMotors.setTargetVelocity(1);

        	//Wait for 2 second
        	Thread.sleep(2000);

        	//Stop motors
        	leftMotors.setTargetVelocity(0);
        	rightMotors.setTargetVelocity(0);
    	}
    	
    	//Task 2
    	{
    		//Forward
        	leftMotors.setTargetVelocity(1);
        	rightMotors.setTargetVelocity(1);

        	//Wait for 2 second
        	Thread.sleep(2000);
        	
        	//Turn in one direction
        	leftMotors.setTargetVelocity(-0.3);
        	rightMotors.setTargetVelocity(0.3);
        	
        	//Wait for 2 second
        	Thread.sleep(2600);

        	//Stop motors
        	leftMotors.setTargetVelocity(0);
        	rightMotors.setTargetVelocity(0);
        	
        	//back to start
        	leftMotors.setTargetVelocity(1);
        	rightMotors.setTargetVelocity(1);
        	
        	//Wait for 2 second
        	Thread.sleep(2000);
        	
        	//Stop motors
        	leftMotors.setTargetVelocity(0);
        	rightMotors.setTargetVelocity(0);
    	}
    	
    	
    }
}
  

