
//Add Phidgets Library
import com.phidget22.*;
import java.util.Scanner; 

public class Turn_Roverkit 
{

    public static void main(String[] args) throws Exception 
    {
    	//Establishes a scanner
	Scanner Input = new Scanner(System.in);
        System.out.println("What task would you like to perform? ( Original(0), task (1), task (2) )");
        int in = Input.nextInt();
            
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
        	
        // (360)
        if(in == 0)
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
    	
    	//Task 1 (-360)
        else if(in == 1)
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
    	
        
    	//Task 2 (move forward, 180, then back)
        else
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
  

