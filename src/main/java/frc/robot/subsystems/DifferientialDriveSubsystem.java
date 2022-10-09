// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DifferientialDriveSubsystem extends SubsystemBase {
  //Declare Motors
  WPI_TalonFX frontLeftDriveMotor;
  WPI_TalonFX backLeftDriveMotor;
  MotorControllerGroup leftSide;
  WPI_TalonFX frontRightDriveMotor;
  WPI_TalonFX backRightDriveMotor;
  MotorControllerGroup rightSide;
  DifferentialDrive differentialDrive;
  /** Creates a new SimpleDriveSubsystem. */
  public DifferientialDriveSubsystem(WPI_TalonFX frontLeftDriveMotor, WPI_TalonFX backLeftDriveMotor,
   WPI_TalonFX frontRightDriveMotor, WPI_TalonFX backRightDriveMotor ) {
     
     this.frontLeftDriveMotor = frontLeftDriveMotor;
     this.backLeftDriveMotor = backLeftDriveMotor;
     leftSide = new MotorControllerGroup(frontLeftDriveMotor, backRightDriveMotor);

     this.frontRightDriveMotor = frontLeftDriveMotor;
     this.backRightDriveMotor = backRightDriveMotor;
     rightSide = new MotorControllerGroup(backRightDriveMotor, backRightDriveMotor);

     differentialDrive = new DifferentialDrive(leftSide, rightSide);
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void simpleArcadeDrive(double speed, double rotation, Boolean squareInputs){
    differentialDrive.arcadeDrive(speed, rotation, squareInputs);
  }
}
