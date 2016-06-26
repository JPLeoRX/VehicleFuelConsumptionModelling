package main.data;

import main.enums.EnumTableModifiedColumnID;

/**
 * Created by Leo on 26-Jun-16.
 */
public class VehicleFuelConsumptionData
{
    double cityMPG;
    double combinedMPG;
    double highwayMPG;

    double unadjustedCityMPG;
    double unadjustedHighwayMPG;

    double guzzlerTax;

    public VehicleFuelConsumptionData(String[] vehicleDataRow) {
        cityMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.city08]);
        combinedMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.comb08]);
        highwayMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.highway08]);

        unadjustedCityMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.UCity]);
        unadjustedHighwayMPG = Double.valueOf(vehicleDataRow[EnumTableModifiedColumnID.UHighway]);

        guzzlerTax = DataParser.parseGuzzler(vehicleDataRow[EnumTableModifiedColumnID.guzzler]);
    }

    @Override
    public String toString() {
        return "Vehicle Fuel Consumption Data: " +
                "\tcityMPG=" + cityMPG +
                ",\tcombinedMPG=" + combinedMPG +
                ",\tguzzlerTax=" + guzzlerTax +
                ",\thighwayMPG=" + highwayMPG +
                ",\tunadjustedCityMPG=" + unadjustedCityMPG +
                ",\tunadjustedHighwayMPG=" + unadjustedHighwayMPG;
    }
}
