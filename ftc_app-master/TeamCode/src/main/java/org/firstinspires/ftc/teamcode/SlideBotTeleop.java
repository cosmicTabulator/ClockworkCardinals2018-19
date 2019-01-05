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

        float slide;
        float sweeper;

        robot.init(hardwareMap);

        robot.slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while(opModeIsActive()){

            if(gamepad1.right_bumper){
                c = 0.6f;
            } else{
                c = 0.25f;
            }

            if(gamepad1.left_bumper){
                sweeper = 0.35f;
            } else {
                sweeper = 0;
            }

            lPower = c*gamepad1.left_stick_y;
            rPower = c*gamepad1.right_stick_y;

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            slide = gamepad2.left_stick_y;

            robot.slide.setPower(slide);
            robot.sweeper.setPower(sweeper);

            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }
}
