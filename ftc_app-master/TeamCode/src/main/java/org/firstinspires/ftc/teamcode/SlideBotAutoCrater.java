package org.firstinspires.ftc.teamcode;//package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by graha on 1/5/2017.
 */

@Autonomous(name = "SlideBotAutoCrater", group = "Tank")

public class SlideBotAutoCrater extends LinearOpMode {

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
                    sleep(1000);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 3:
                    robot.right.setPower(1);
                    robot.left.setPower(-1);
                    sleep(500);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 4:
                    robot.right.setPower(1);
                    robot.left.setPower(1);
                    sleep(1000);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 5:
                    robot.right.setPower(1);
                    robot.left.setPower(-1);
                    sleep(250);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 6:
                    robot.right.setPower(1);
                    robot.left.setPower(1);
                    sleep(3000);
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state++;
                    break;

                case 7:
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
