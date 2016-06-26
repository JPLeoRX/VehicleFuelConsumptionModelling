package main.data;

import main.enums.EnumTableModifiedColumnID;

/**
 * Created by Leo on 26-Jun-16.
 */
public class VehicleBodyData
{
    double hatchbackLuggageVolume;
    double hatchbackPassengerVolume;

    double luggageVolume2door;
    double luggageVolume4door;

    double passengerVolume2door;
    double passengerVolume4door;

    double vehicleClass;
    double year;

    String make;
    String model;

    public VehicleBodyData(String[] vehicleDataRow) {
        hatchbackLuggageVolume = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.hlv]);
        hatchbackPassengerVolume = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.hpv]);

        luggageVolume2door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.lv2]);
        luggageVolume4door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.lv4]);

        passengerVolume2door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.pv2]);
        passengerVolume4door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.pv4]);

        vehicleClass = DataParser.parseVehicleClass(vehicleDataRow[EnumTableModifiedColumnID.VClass]);
        year = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.year]);
    }

    @Override
    public String toString() {
        return "Vehicle Body Data: " +
                "\thatchbackLuggageVolume=" + hatchbackLuggageVolume +
                ",\thatchbackPassengerVolume=" + hatchbackPassengerVolume +
                ",\tluggageVolume2door=" + luggageVolume2door +
                ",\tluggageVolume4door=" + luggageVolume4door +
                ",\tpassengerVolume2door=" + passengerVolume2door +
                ",\tpassengerVolume4door=" + passengerVolume4door +
                ",\tvehicleClass=" + vehicleClass +
                ",\tyear=" + year +
                ",\tmake='" + make + '\'' +
                ",\tmodel='" + model + '\''
                ;
    }
}
