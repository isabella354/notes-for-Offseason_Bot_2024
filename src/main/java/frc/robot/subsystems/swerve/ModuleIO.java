// Copyright (c) 2024 FRC 3256
// https://github.com/Team3256
//
// Use of this source code is governed by a 
// license that can be found in the LICENSE file at
// the root directory of this project.

package frc.robot.subsystems.swerve;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

public interface ModuleIO {
  @AutoLog
  public static class ModuleIOInputs {
    public double driveMotorVoltage = 0.0;
    public double driveMotorVelocity = 0.0;
    public double driveMotorPosition = 0.0;
    public double driveMotorStatorCurrent = 0.0;
    public double driveMotorSupplyCurrent = 0.0;
    public double driveMotorTemperature = 0.0;
    public double driveMotorReferenceSlope = 0.0;

    public Rotation2d absolutePosition = new Rotation2d();

    public double angleMotorVoltage = 0.0;
    public double angleMotorPosition = 0.0;
    public double angleMotorStatorCurrent = 0.0;
    public double angleMotorSupplyCurrent = 0.0;
    public double angleMotorTemperature = 0.0;
    public double angleMotorReferenceSlope = 0.0;
  }

  public default void updateInputs(ModuleIOInputs inputs) {}

  public default void setDriveVelocity(double velocity, boolean isOpenLoop) {}

  public default void setAnglePosition(double position) {}

  public default void resetToAbsolute() {}

  public default Rotation2d getCANcoder() {
    return new Rotation2d();
  }
}
