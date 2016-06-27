package main.data;

import main.enums.EnumTableModifiedColumnID;

import java.io.Serializable;

/**
 * Class that models the vehicle's engine
 * It contains information about the number of cylinders, displacement, fuel, turbo or super charger, start-stop technology, and transmission.
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public class VehicleDataEngine implements Serializable
{
    private double cylinders, displacement;
    private double fuel, isTurbocharged, isSupercharged, hasStartStopTechnology;
    private double drivetrain;
    private double transmissionType, transmissionNumberOfSpeeds;

    /**
     * Basic constructor
     * @param vehicleDataRow row of vehicle data obtained from reading the table
     */
    public VehicleDataEngine(final String[] vehicleDataRow) {
        cylinders = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.cylinders]);
        displacement = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.displ]);

        fuel = DataParser.parseFuelType(vehicleDataRow[EnumTableModifiedColumnID.fuelType1]);
        isTurbocharged = DataParser.parseTurboCharger(vehicleDataRow[EnumTableModifiedColumnID.tCharger]);
        isSupercharged = DataParser.parseSuperCharger(vehicleDataRow[EnumTableModifiedColumnID.sCharger]);
        hasStartStopTechnology = DataParser.parseStartStop(vehicleDataRow[EnumTableModifiedColumnID.startStop]);

        drivetrain = DataParser.parseDriveType(vehicleDataRow[EnumTableModifiedColumnID.drive]);
        transmissionType = DataParser.parseTransmissionType(vehicleDataRow[EnumTableModifiedColumnID.trany]);
        transmissionNumberOfSpeeds = DataParser.parseTransmissionNumberOfSpeeds(vehicleDataRow[EnumTableModifiedColumnID.trany]);
    }

    /**
     * Get the vehicle's data from this object
     * @return data in 1D array
     */
    public double[] getData() {
        return new double[]{cylinders, displacement, fuel, isTurbocharged, isSupercharged, hasStartStopTechnology, drivetrain, transmissionType, transmissionNumberOfSpeeds};
    }

    @Override
    public String toString() {
        return "Vehicle Engine Data: " + "\tcylinders=" + cylinders + ",\tdisplacement=" + displacement + ",\tfuel=" + fuel + ",\tisTurbocharged=" + isTurbocharged + ",\tisSupercharged=" + isSupercharged + ",\thasStartStopTechnology=" + hasStartStopTechnology + ",\tdrivetrain=" + drivetrain + ",\ttransmissionType=" + transmissionType + ",\ttransmissionNumberOfSpeeds=" + transmissionNumberOfSpeeds;
    }
}