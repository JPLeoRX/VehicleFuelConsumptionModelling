package main.data;

import main.utils.UtilArraysDouble;

import java.io.Serializable;

/**
 * Class that models the vehicle
 * It contains all the data from the data set, splitted into several objects.
 * It converts the string data into numeric values.
 * It prepares input-output pairs for machine learning purposes.
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public class VehicleData implements Serializable
{
    private VehicleDataBody vehicleDataBody;
    private VehicleDataEngine vehicleDataEngine;
    private VehicleDataFuelConsumption vehicleDataFuelConsumption;

    /**
     * Basic constructor
     * @param vehicleDataRow row of vehicle data obtained from reading the table
     */
    public VehicleData(final String[] vehicleDataRow) {
        vehicleDataBody = new VehicleDataBody(vehicleDataRow);
        vehicleDataEngine = new VehicleDataEngine(vehicleDataRow);
        vehicleDataFuelConsumption = new VehicleDataFuelConsumption(vehicleDataRow);
    }

    /**
     * Get the data that will be used as input
     * @return input 1D array
     */
    public double[] getInput() {
        return UtilArraysDouble.merge(vehicleDataBody.getData(), vehicleDataEngine.getData());
    }

    /**
     * Get the data that will be used as output
     * @return output 1D array
     */
    public double[] getOutput() {
        return vehicleDataFuelConsumption.getData();
    }

    @Override
    public String toString() {
        return "Vehicle Data: " +
                "\n\tBody:            " + vehicleDataBody +
                "\n\tEngine:          " + vehicleDataEngine +
                "\n\tFuelConsumption: " + vehicleDataFuelConsumption;
    }
}