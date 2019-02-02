package org.firstinspires.ftc.teamcode;//package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
/**
 * Created by graha on 1/5/2017.
 */

@Autonomous(name = "SlideBotAutoDepot", group = "Tank")

public class SlideBotAutoDepot extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    int state = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            switch (state){

                case 0:
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 1:
                    robot.slide.setPower(1);
                    sleep(11500);
                    robot.slide.setPower(0);
                    state++;
                    break;

                case 2:
                    robot.right.setPower(1);
                    robot.left.setPower(1);
                    sleep(3000);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 3:
                    robot.sweeper.setPower(1);
                    sleep(1000);
                    robot.sweeper.setPower(1);
                    state++;
                    break;

                default:
                    break;
            }

            robot.waitForTick(20);

            idle();

        }

        }

}
