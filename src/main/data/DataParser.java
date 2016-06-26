package main.data;

import main.enums.EnumDataDrivetrainType;
import main.enums.EnumDataFuelType;
import main.enums.EnumDataTransmissionType;

/**
 * Created by Leo on 26-Jun-16.
 */
public class DataParser
{
    public static double parseTurboCharger(String tCharger) {
        if (tCharger == null || tCharger.equals(""))
            return 0;
        else if (tCharger.equals("T"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal tCharger value: " + tCharger);
    }

    public static double parseSuperCharger(String sCharger) {
        if (sCharger == null || sCharger.equals(""))
            return 0;
        else if (sCharger.equals("S"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal sCharger value: " + sCharger);
    }

    public static double parseStartStop(String startstop) {
        if (startstop == null || startstop.equals("") || startstop.equals("N"))
            return 0;
        else if (startstop.equals("Y"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal startstop value: " + startstop);
    }

    public static double parseFuelType(String fueltype) {
        if (fueltype.equals("Regular Gasoline"))
            return EnumDataFuelType.REGULAR_GASOLINE;
        else if (fueltype.equals("Midgrade Gasoline"))
            return EnumDataFuelType.MIDGRADE_GASOLINE;
        else if (fueltype.equals("Premium Gasoline"))
            return EnumDataFuelType.PREMIUM_GASOLINE;
        else if (fueltype.equals("Diesel"))
            return EnumDataFuelType.DIESEL;
        else
            throw new IllegalArgumentException("Illegal fueltype value: " + fueltype);
    }

    public static double parseDriveType(String drive) {
        if (drive.equals("4-Wheel Drive"))
            return EnumDataDrivetrainType.FOUR_WHEEL_OR_ALL_WHEEL_DRIVE;
        else if (drive.equals("Front-Wheel Drive"))
            return EnumDataDrivetrainType.FRONT_WHEEL_DRIVE;
        else if (drive.equals("All-Wheel Drive"))
            return EnumDataDrivetrainType.FOUR_WHEEL_OR_ALL_WHEEL_DRIVE;
        else if (drive.equals("4-Wheel or All-Wheel Drive"))
            return EnumDataDrivetrainType.FOUR_WHEEL_OR_ALL_WHEEL_DRIVE;
        else if (drive.equals("Rear-Wheel Drive"))
            return EnumDataDrivetrainType.REAR_WHEEL_DRIVE;
        else if (drive.equals("Part-time 4-Wheel Drive"))
            return EnumDataDrivetrainType.FOUR_WHEEL_OR_ALL_WHEEL_DRIVE;
        else
            throw new IllegalArgumentException("Illegal drive value: " + drive);
    }

    public static double parseTransmissionType(String tranny) {
        if (tranny.contains("Manual"))
            return EnumDataTransmissionType.MANUAL;
        else if (tranny.contains("AV-S"))
            return EnumDataTransmissionType.AUTOMATED_VARIABLE;
        else if (tranny.contains("AM-S"))
            return EnumDataTransmissionType.AUTOMATED_MANUAL;
        else if (tranny.contains("AV") || tranny.contains("variable"))
            return EnumDataTransmissionType.AUTOMATED_VARIABLE;
        else if (tranny.contains("AM"))
            return EnumDataTransmissionType.AUTOMATED_MANUAL;
        else if (tranny.contains("Automatic") || tranny.contains("Auto"))
            return EnumDataTransmissionType.AUTOMATIC;
        else
            throw new IllegalArgumentException("Illegal tranny value: " + tranny);

    }
}
