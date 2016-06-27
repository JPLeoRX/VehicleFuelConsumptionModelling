package main.data;

import main.enums.EnumTableModifiedColumnID;
import main.utils.UtilArraysGeneric;

import java.util.ArrayList;

/**
 * Class that performs filtering of damaged/incomplete data and allows selection of vehicles by fuel type (gasoline or diesel)
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class DataFilter
{
    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------- Core Methods -------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Select only cars that run on gasoline, with no additional fuel used
     * Filter out invalid data
     * @param table the full table, read from Excel file
     * @return 2D array with only selected rows
     */
    public static String[][] selectGasolineOnly(final String[][] table) {
        // Create new array list to store selected data
        ArrayList<String[]> selectedVehicleDataRows = new ArrayList<>();

        // For each vehicle in the table
        for (int vehicleDataRowIndex = 0; vehicleDataRowIndex < table.length; vehicleDataRowIndex++)
            // If it is gasoline and valid
            if (isGasoline(table[vehicleDataRowIndex]) && isValid(table[vehicleDataRowIndex]))
                // Add it to the array list
                selectedVehicleDataRows.add(table[vehicleDataRowIndex]);

        // Return the results, converted into 2D array
        return UtilArraysGeneric.getArray2D(selectedVehicleDataRows, String.class);
    }

    /**
     * Select only cars that run on diesel, with no additional fuel used
     * Filter out invalid data
     * @param table the full table, read from Excel file
     * @return 2D array with only selected rows
     */
    public static String[][] selectDieselOnly(final String[][] table) {
        // Create new array list to store selected data
        ArrayList<String[]> selectedVehicleDataRows = new ArrayList<>();

        // For each vehicle in data set
        for (int vehicleDataRowIndex = 0; vehicleDataRowIndex < table.length; vehicleDataRowIndex++)
            // If it is diesel and valid
            if (isDiesel(table[vehicleDataRowIndex]) && isValid(table[vehicleDataRowIndex]))
                // Add it to the array list
                selectedVehicleDataRows.add(table[vehicleDataRowIndex]);

        // Return the results, converted into 2D array
        return UtilArraysGeneric.getArray2D(selectedVehicleDataRows, String.class);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------- Filters (Row Wrappers) ---------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Is this a pure gasoline car?
     * @param row row with vehicle data, obtained from the table
     * @return
     */
    private static boolean isGasoline(String[] row) {
        // Redirect call
        return isGasoline(row[EnumTableModifiedColumnID.fuelType1], row[EnumTableModifiedColumnID.fuelType2], row[EnumTableModifiedColumnID.atvtype]);
    }

    /**
     * Is this a pure diesel car?
     * @param row row with vehicle data, obtained from the table
     * @return
     */
    private static boolean isDiesel(String[] row) {
        // Redirect call
        return isDiesel(row[EnumTableModifiedColumnID.fuelType1], row[EnumTableModifiedColumnID.fuelType2], row[EnumTableModifiedColumnID.atvtype]);
    }

    /**
     * Is this a valid car data?
     * @param row row with vehicle data, obtained from the table
     * @return
     */
    private static boolean isValid(String[] row) {
        // Redirect call
        return isValid(row[EnumTableModifiedColumnID.cylinders], row[EnumTableModifiedColumnID.drive], row[EnumTableModifiedColumnID.trany]);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------- Filters ------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private static boolean isGasoline(final String fueltype1, final String fueltype2, final String atvType) {
        // If the first fuel type is correct
        if (fueltype1.equals("Regular Gasoline") || fueltype1.equals("Midgrade Gasoline") || fueltype1.equals("Premium Gasoline"))
            // And if no secondary fuel is used
            if (fueltype2 == null || fueltype2.equals(""))
                // And if no alternative fuel is used
                if (atvType == null || atvType.equals(""))
                    // If all conditions are satisfied - return true
                    return true;

        // If some of the conditions fail - return false
        return false;
    }

    private static boolean isDiesel(final String fueltype1, final String fueltype2, final String atvType) {
        // If the first fuel type is correct
        if (fueltype1.equals("Diesel"))
            // And if no secondary fuel is used
            if (fueltype2 == null || fueltype2.equals(""))
                // And if alternative fuel is diesel
                if (atvType != null && atvType.equals("Diesel"))
                    // If all conditions are satisfied - return true
                    return true;

        // If some of the conditions fail - return false
        return false;
    }

    private static boolean isValid(final String cylinders, final String drive, final String tranny) {
        // If valid cylinders data is presented
        if (cylinders != null && !cylinders.equals("") && !cylinders.equals("NA"))
            // If valid drivetrain data is presented
            if (drive != null && !drive.equals("") && !drive.equals("2-Wheel Drive"))
                // If valid transmission data is presented
                if (tranny != null && !tranny.equals(""))
                    // If all conditions are satisfied - return true
                    return true;

        // If some of the conditions fail - return false
        return false;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}