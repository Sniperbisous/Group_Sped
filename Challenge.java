package Phidgetsrover;

import java.util.Scanner;
//Add Phidgets Library
import com.phidget22.*;

public class Challenge 
{
	public static void main(String[] args) throws Exception 
    {
    	//Establishes a scanner
    	Scanner Input = new Scanner(System.in);
        System.out.println("What direction is the first turn? (LEFT = 1, RIGHT = -1)");
        int in = Input.nextInt();

        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();
        DistanceSensor sonar = new DistanceSensor();

        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(5000);
        rightMotors.open(5000);
        sonar.open(5000);
        int time;
        int i = in;
        int u = 0;
        
        while (true) 
    	{
    		System.out.println("Distance: " + sonar.getDistance() + " mm");
        
    		if (sonar.getDistance() < 200) 
    		{
    			//Object detected! Turn right 180 degrees
    			leftMotors.setTargetVelocity(1);
    			rightMotors.setTargetVelocity(-1);
    			
    			//Wait for  0.78 second
        		Thread.sleep(780);
        		
        		time = 1323 - u;
        		u = time;
        		i = (i*(-1));
    		} 
        
    		else 
    		{
    			//Move forward at full speed (100% max speed)
    			leftMotors.setTargetVelocity(1);
    			rightMotors.setTargetVelocity(1);
    			
    			if(u == 1323)
    			{
    				
    				//stop
        			leftMotors.setTargetVelocity(0);
        			rightMotors.setTargetVelocity(0);
        			//Wait for 1 second
            		Thread.sleep(1300);
    				
            		if(i > 0)
            		{
            			//turn left 90 degrees
            			leftMotors.setTargetVelocity(-1);
        				rightMotors.setTargetVelocity(1);
            		}
            		else
            		{
            			//turn right 90 degrees
            			leftMotors.setTargetVelocity(1);
        				rightMotors.setTargetVelocity(-1);
            		}
        			//Wait for  0.39 second
            		Thread.sleep(390);
    			}
    			else
    			{
    				u += 1;
    				//Wait for 0.001 second
            		Thread.sleep(1);
    			}
    			
    		}

    		//Wait for 250 milliseconds
    		Thread.sleep(250);
    	}
    }  
}
