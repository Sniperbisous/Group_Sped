
//Add Phidgets Library
import com.phidget22.*;

public class PhidgetsRover_Avoid {
    
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

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

        while (true) {

            System.out.println("Distance: " + sonar.getDistance() + " mm");
            
            if (sonar.getDistance() < 400) 
            {
                //Object detected! Stop motors
                leftMotors.setTargetVelocity(0);
                rightMotors.setTargetVelocity(0);
                
                Thread.sleep(500);
                
                //turn 90
                leftMotors.setTargetVelocity(0.3);
                rightMotors.setTargetVelocity(-0.3);
                
                Thread.sleep(1300);
            } 
            else 
            {
                //Move forward slowly (50% max speed)
                leftMotors.setTargetVelocity(0.5);
                rightMotors.setTargetVelocity(0.5);
            }

            //Wait for 100milliseconds
            Thread.sleep(100);
        }
    }
}
  