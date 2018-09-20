package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "SlideBotTeleOp", group = "Tank")

public class SlideBotTeleop extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        float c = -0.5f;

        float drive;
        float turn;

        int motorPos = 0;

        float slide;

        int cooldown = 0;
        double position = 0.5;
        double armPos = 0.5;

        robot.init(hardwareMap);

        robot.slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while(opModeIsActive()){

            if(gamepad1.right_bumper){
                c = 0.6f;
            } else{
                c = 0.25f;
            }

            lPower = c*gamepad1.left_stick_y;
            rPower = c*gamepad1.right_stick_y;

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            slide = gamepad2.left_stick_y;

            if(gamepad2.left_bumper == true){
                motorPos = robot.slide.getCurrentPosition();
            }


            if(gamepad2.right_bumper == true) {
                if (motorPos < robot.slide.getCurrentPosition()) {
                    slide = 0.05f;
                }

                if (motorPos > robot.slide.getCurrentPosition()) {
                    slide = -0.05f;
                }

                if (motorPos == robot.slide.getCurrentPosition()) {
                    slide = 0;
                }
            }

            robot.slide.setPower(slide);

            if(gamepad2.dpad_up){
                position = 0.65;
            }

            if(gamepad2.x){
                armPos = 0.9;
            }

            if(gamepad2.b){
                armPos = 0.0;
            }

            if(gamepad2.dpad_down){
                position = 0;
            }


            robot.latchUp.setPosition(position);
            robot.latchDown.setPosition(1-position);
            robot.arm.setPosition(armPos);

            telemetry.addData("Servo Position", position);
            telemetry.addData("Cooldown", cooldown);
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }
}
