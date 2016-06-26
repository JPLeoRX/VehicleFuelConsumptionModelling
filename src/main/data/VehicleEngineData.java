package main.data;

import main.enums.EnumTableModifiedColumnID;

/**
 * Created by Leo on 26-Jun-16.
 */
public class VehicleEngineData
{
    double cylinders;
    double displacement;

    double fuel;
    double isTurbocharged;
    double isSupercharged;
    double hasStartStopTechnology;

    double drivetrain;

    double transmissionType;
    double transmissionNumberOfSpeeds;

    public VehicleEngineData(String[] vehicleDataRow) {
        cylinders = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.cylinders]);
        displacement = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.displ]);

        fuel = DataParser.parseFuelType(vehicleDataRow[EnumTableModifiedColumnID.fuelType1]);
        isTurbocharged = DataParser.parseTurboCharger(vehicleDataRow[EnumTableModifiedColumnID.tCharger]);
        isSupercharged = DataParser.parseSuperCharger(vehicleDataRow[EnumTableModifiedColumnID.sCharger]);
        hasStartStopTechnology = DataParser.parseStartStop(vehicleDataRow[EnumTableModifiedColumnID.startStop]);

        drivetrain = DataParser.parseDriveType(vehicleDataRow[EnumTableModifiedColumnID.drive]);
        transmissionType = DataParser.parseTransmissionType(vehicleDataRow[EnumTableModifiedColumnID.trany]);
    }

    @Override
    public String toString() {
        return "Vehicle Engine Data: " + "\tcylinders=" + cylinders + ",\tdisplacement=" + displacement + ",\tfuel=" + fuel + ",\tisTurbocharged=" + isTurbocharged + ",\tisSupercharged=" + isSupercharged + ",\thasStartStopTechnology=" + hasStartStopTechnology + ",\tdrivetrain=" + drivetrain + ",\ttransmissionType=" + transmissionType + ",\ttransmissionNumberOfSpeeds=" + transmissionNumberOfSpeeds;
    }
}
