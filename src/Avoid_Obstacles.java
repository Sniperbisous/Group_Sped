package Phidgetsrover;

import java.util.Scanner;

//Add Phidgets Library
import com.phidget22.*;

public class Avoid_Obstacles
{
    public static void main(String[] args) throws Exception 
    {
    	//Establishes a scanner
    	Scanner Input = new Scanner(System.in);
        System.out.println("What task would you like to perform? ( Original(0), task (1), task (2), task(3) )");
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
        
        if(in == 0)
        {
        	while (true) 
        	{
        		System.out.println("Distance: " + sonar.getDistance() + " mm");
            
        		if (sonar.getDistance() < 200) 
        		{
        			//Object detected! Stop motors
        			leftMotors.setTargetVelocity(0);
        			rightMotors.setTargetVelocity(0);
        		} 
            
        		else 
        		{
        			//Move forward slowly (25% max speed)
        			leftMotors.setTargetVelocity(0.25);
        			rightMotors.setTargetVelocity(0.25);
        		}

        		//Wait for 250 milliseconds
        		Thread.sleep(250);
        	}
        }
        
        //task 1
        else if(in == 1)
        {
        	while (true) 
        	{
        		System.out.println("Distance: " + sonar.getDistance() + " mm");
            
        		if (sonar.getDistance() < 100) 
        		{
        			//Object detected! Stop motors
        			leftMotors.setTargetVelocity(0);
        			rightMotors.setTargetVelocity(0);
        		} 
            
        		else 
        		{
        			//Move forward slowly (25% max speed)
        			leftMotors.setTargetVelocity(0.50);
        			rightMotors.setTargetVelocity(0.50);
        		}

        		//Wait for 250 milliseconds
        		Thread.sleep(250);
        	}
        }
        
        //task 2
        else if(in == 2)
        {
        	while (true) 
        	{
        		System.out.println("Distance: " + sonar.getDistance() + " mm");
            
        		if (sonar.getDistance() < 200) 
        		{
        			//Object detected! reverse slowly
        			leftMotors.setTargetVelocity(-0.25);
        			rightMotors.setTargetVelocity(-0.25);
        			
        			//Wait for 1 second
            		Thread.sleep(1000);
            		
            		//turn right 90 degrees
        			leftMotors.setTargetVelocity(0.30);
        			rightMotors.setTargetVelocity(-0.30);
        			
        			//Wait for 1.3 second
            		Thread.sleep(1300);
            		
            		//continue forward
            		leftMotors.setTargetVelocity(0.5);
        			rightMotors.setTargetVelocity(0.5);
        		} 
            
        		else 
        		{
        			//Move forward slowly (25% max speed)
        			leftMotors.setTargetVelocity(0.25);
        			rightMotors.setTargetVelocity(0.25);
        		}

        		//Wait for 250 milliseconds
        		Thread.sleep(250);
        	}
        }
        
        //task 3
        else
        {
        	//Sets the update time to 100 millisecond
        	sonar.setDataInterval(100);
        	while (true) 
        	{
        		System.out.println("Distance: " + sonar.getDistance() + " mm");
            
        		if (sonar.getDistance() < 200) 
        		{
        			//Object detected! reverse slowly
        			leftMotors.setTargetVelocity(-0.25);
        			rightMotors.setTargetVelocity(-0.25);
        			
        			//Wait for 1 second
            		Thread.sleep(1000);
            		
            		//turn right 90 degrees
        			leftMotors.setTargetVelocity(0.30);
        			rightMotors.setTargetVelocity(-0.30);
        			
        			//Wait for 1.3 second
            		Thread.sleep(1300);
            		
            		//continue forward
            		leftMotors.setTargetVelocity(0.5);
        			rightMotors.setTargetVelocity(0.5);
        		} 
            
        		else 
        		{
        			//Move forward slowly (25% max speed)
        			leftMotors.setTargetVelocity(0.25);
        			rightMotors.setTargetVelocity(0.25);
        		}

        		//Wait for 100 milliseconds
        		Thread.sleep(100);
        	}
        }

       
    }
}
  

