package main.data;

import main.enums.EnumDataDrivetrainType;
import main.enums.EnumDataFuelType;
import main.enums.EnumDataTransmissionType;
import main.enums.EnumDataVehicleClass;

/**
 * Class that performs parsing of data from strings to numeric values
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class DataParser
{
    public static double parseGuzzler(String guzzler) {
        if (guzzler == null || guzzler.equals(""))
            return 0;
        else
            return 1;
    }

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

    public static double parseTransmissionNumberOfSpeeds(String tranny) {
        if (tranny.contains("AV-S") || tranny.contains("AV") || tranny.contains("variable"))
            return 0;
        for (char c : tranny.toCharArray())
            if (Character.isDigit(c))
                return Integer.valueOf(String.valueOf(c));
        throw new IllegalArgumentException("Illegal tranny value: " + tranny);
    }

    public static double parseVehicleClass(String vclass) {
        if (vclass.equals("Small Pickup Trucks"))
            return EnumDataVehicleClass.SMALL_PICKUP_TRUCK;
        else if (vclass.equals("Small Pickup Trucks 2WD"))
            return EnumDataVehicleClass.SMALL_PICKUP_TRUCK;
        else if (vclass.equals("Small Pickup Trucks 4WD"))
            return EnumDataVehicleClass.SMALL_PICKUP_TRUCK;
        else if (vclass.equals("Standard Pickup Trucks"))
            return EnumDataVehicleClass.STANDARD_PICKUP_TRUCK;
        else if (vclass.equals("Standard Pickup Trucks 2WD"))
            return EnumDataVehicleClass.STANDARD_PICKUP_TRUCK;
        else if (vclass.equals("Standard Pickup Trucks 4WD"))
            return EnumDataVehicleClass.STANDARD_PICKUP_TRUCK;
        else if (vclass.equals("Standard Pickup Trucks/2wd"))
            return EnumDataVehicleClass.STANDARD_PICKUP_TRUCK;
        else if (vclass.equals("Special Purpose Vehicle"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Special Purpose Vehicles"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Special Purpose Vehicle 2WD"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Special Purpose Vehicle 4WD"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Special Purpose Vehicles/2wd"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Special Purpose Vehicles/4wd"))
            return EnumDataVehicleClass.SPECIAL_PURPOSE_VEHICLE;
        else if (vclass.equals("Sport Utility Vehicle - 2WD"))
            return EnumDataVehicleClass.SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Sport Utility Vehicle - 4WD"))
            return EnumDataVehicleClass.SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Small Sport Utility Vehicle 2WD"))
            return EnumDataVehicleClass.SMALL_SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Small Sport Utility Vehicle 4WD"))
            return EnumDataVehicleClass.SMALL_SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Standard Sport Utility Vehicle 2WD"))
            return EnumDataVehicleClass.STANDARD_SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Standard Sport Utility Vehicle 4WD"))
            return EnumDataVehicleClass.STANDARD_SPORT_UTILITY_VEHICLE;
        else if (vclass.equals("Small Station Wagons"))
            return EnumDataVehicleClass.SMALL_STATION_WAGON;
        else if (vclass.equals("Midsize Station Wagons"))
            return EnumDataVehicleClass.MIDSIZE_STATION_WAGON;
        else if (vclass.equals("Midsize-Large Station Wagons"))
            return EnumDataVehicleClass.MIDSIZE_LARGE_STATION_WAGON;
        else if (vclass.equals("Minicompact Cars"))
            return EnumDataVehicleClass.MINICOMPACT_CAR;
        else if (vclass.equals("Compact Cars"))
            return EnumDataVehicleClass.COMPACT_CAR;
        else if (vclass.equals("Subcompact Cars"))
            return EnumDataVehicleClass.SUBCOMPACT_CAR;
        else if (vclass.equals("Two Seaters"))
            return EnumDataVehicleClass.TWO_SEATER;
        else if (vclass.equals("Midsize Cars"))
            return EnumDataVehicleClass.MIDSIZE_CAR;
        else if (vclass.equals("Large Cars"))
            return EnumDataVehicleClass.LARGE_CAR;
        else if (vclass.equals("Vans"))
            return EnumDataVehicleClass.VAN;
        else if (vclass.equals("Vans, Cargo Type"))
            return EnumDataVehicleClass.VAN;
        else if (vclass.equals("Vans, Passenger Type"))
            return EnumDataVehicleClass.VAN;
        else if (vclass.equals("Vans Passenger"))
            return EnumDataVehicleClass.VAN;
        else if (vclass.equals("Minivan - 2WD"))
            return EnumDataVehicleClass.MINIVAN;
        else if (vclass.equals("Minivan - 4WD"))
            return EnumDataVehicleClass.MINIVAN;
        else
            throw new IllegalArgumentException("Illegal vclass value: " + vclass);
    }
}