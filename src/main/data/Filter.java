package main.data;

import main.enums.EnumTableModifiedColumnID;
import main.enums.EnumTableOriginalColumnID;
import main.utils.UtilArraysGeneric;

import java.util.ArrayList;

/**
 * Created by Leo on 26-Jun-16.
 */
public class Filter
{
    public static String[][] selectGasolineOnly(final String[][] table) {
        ArrayList<String[]> selectedRows = new ArrayList<>();

        // For each vehicle in data set
        for (int row = 0; row < table.length; row++)
            // If it is gasoline
            if (isGasoline(table[row][EnumTableModifiedColumnID.fuelType1], table[row][EnumTableModifiedColumnID.fuelType2]))
                // Add it to the array
                selectedRows.add(table[row]);

        return UtilArraysGeneric.getArray2D(selectedRows, String.class);
    }

    public static String[][] selectDieselOnly(final String[][] table) {
        ArrayList<String[]> selectedRows = new ArrayList<>();

        // For each vehicle in data set
        for (int row = 0; row < table.length; row++)
            // If it is gasoline
            if (isDiesel(table[row][EnumTableModifiedColumnID.fuelType1], table[row][EnumTableModifiedColumnID.fuelType2]))
                // Add it to the array
                selectedRows.add(table[row]);

        return UtilArraysGeneric.getArray2D(selectedRows, String.class);
    }

    private static boolean isGasoline(final String fueltype1, final String fueltype2) {
        // If the first fuel type is correct
        if (fueltype1.equals("Regular Gasoline") || fueltype1.equals("Midgrade Gasoline") || fueltype1.equals("Premium Gasoline"))
            // And if no secondary fuel is used
            if (fueltype2 == null || fueltype2.equals(""))
                return true;

        return false;
    }

    private static boolean isDiesel(final String fueltype1, final String fueltype2) {
        // If the first fuel type is correct
        if (fueltype1.equals("Diesel"))
            // And if no secondary fuel is used
            if (fueltype2 == null || fueltype2.equals(""))
                return true;

        return false;
    }
}