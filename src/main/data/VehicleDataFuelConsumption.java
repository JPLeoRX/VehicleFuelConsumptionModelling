package main.data;

import main.enums.EnumTableModifiedColumnID;

import java.io.Serializable;

/**
 * Class that represents the fuel consumption data
 * It contains information about MPGs as well as whether this car is a subject to guzzler tax.
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public class VehicleDataFuelConsumption implements Serializable
{
    private double cityMPG, combinedMPG, highwayMPG;
    private double unadjustedCityMPG, unadjustedHighwayMPG;
    private double guzzlerTax;

    /**
     * Basic constructor
     * @param vehicleDataRow row of vehicle data obtained from reading the table
     */
    public VehicleDataFuelConsumption(final String[] vehicleDataRow) {
        cityMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.city08]);
        combinedMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.comb08]);
        highwayMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.highway08]);

        unadjustedCityMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.UCity]);
        unadjustedHighwayMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.UHighway]);

        guzzlerTax = DataParser.parseGuzzler(vehicleDataRow[EnumTableModifiedColumnID.guzzler]);
    }

    /**
     * Get the vehicle's data from this object
     * @return data in 1D array
     */
    public double[] getData() {
        return new double[]{cityMPG, combinedMPG, highwayMPG, unadjustedCityMPG, unadjustedHighwayMPG, guzzlerTax};
    }

    @Override
    public String toString() {
        return "Vehicle Fuel Consumption Data: " + "\tcityMPG=" + cityMPG + ",\tcombinedMPG=" + combinedMPG + ",\tguzzlerTax=" + guzzlerTax + ",\thighwayMPG=" + highwayMPG + ",\tunadjustedCityMPG=" + unadjustedCityMPG + ",\tunadjustedHighwayMPG=" + unadjustedHighwayMPG;
    }
}