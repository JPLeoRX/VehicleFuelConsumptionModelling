package main.data;

import main.enums.EnumTableModifiedColumnID;

import java.io.Serializable;

/**
 * Class that models the vehicle's body
 * It contains information about luggage and passenger volume, vehicle class, make and model and it's production year
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public class VehicleDataBody implements Serializable
{
    private double vehicleClass, year;
    private double hatchbackLuggageVolume, hatchbackPassengerVolume;
    private double luggageVolume2door, luggageVolume4door;
    private double passengerVolume2door, passengerVolume4door;
    private String make, model;

    /**
     * Basic constructor
     * @param vehicleDataRow row of vehicle data obtained from reading the table
     */
    public VehicleDataBody(String[] vehicleDataRow) {
        hatchbackLuggageVolume = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.hlv]);
        hatchbackPassengerVolume = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.hpv]);

        luggageVolume2door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.lv2]);
        luggageVolume4door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.lv4]);

        passengerVolume2door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.pv2]);
        passengerVolume4door = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.pv4]);

        vehicleClass = DataParser.parseVehicleClass(vehicleDataRow[EnumTableModifiedColumnID.VClass]);
        year = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.year]);

        make = vehicleDataRow[EnumTableModifiedColumnID.make];
        model = vehicleDataRow[EnumTableModifiedColumnID.model];
    }

    /**
     * Get the vehicle's data from this object
     * @return data in 1D array
     */
    public double[] getData() {
        return new double[]{vehicleClass, year, hatchbackLuggageVolume, hatchbackPassengerVolume, luggageVolume2door, luggageVolume4door, passengerVolume2door, passengerVolume4door};
    }

    @Override
    public String toString() {
        return "Vehicle Body Data: " + "\thatchbackLuggageVolume=" + hatchbackLuggageVolume + ",\thatchbackPassengerVolume=" + hatchbackPassengerVolume + ",\tluggageVolume2door=" + luggageVolume2door + ",\tluggageVolume4door=" + luggageVolume4door + ",\tpassengerVolume2door=" + passengerVolume2door + ",\tpassengerVolume4door=" + passengerVolume4door + ",\tvehicleClass=" + vehicleClass + ",\tyear=" + year + ",\tmake=" + make + ",\tmodel=" + model;
    }
}