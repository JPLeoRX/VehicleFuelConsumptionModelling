package main.utils;

import main.utils.machine_learning.UtilNormalizer;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.util.arrayutil.NormalizedField;

import java.text.NumberFormat;

/**
 * Class that provides methods for simple printing of data
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilPrinter
{
    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- Internal Helpers ----------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private static final int FRACTION_DIGITS = 3;
    private static final NumberFormat NUMBER_FORMAT = getNumberFormat(FRACTION_DIGITS);

    /**
     * Get a number format object
     * @param fractionDigits number of fraction digits for double printing
     * @return NumberFormat object
     */
    private static NumberFormat getNumberFormat(int fractionDigits) {
        // Get current number format object
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        // Set maximum number of fraction digits
        numberFormat.setMaximumFractionDigits(fractionDigits);

        // Set minimum number of fraction digits
        numberFormat.setMinimumFractionDigits(fractionDigits);

        // Return the number format object
        return numberFormat;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------- Converters - Double to String ----------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Convert
     * @param number number to be converted to a string
     * @return formatted string of a number
     */
    public static String getStr(double number) {
        // Return formatted number
        return NUMBER_FORMAT.format(number);
    }

    /**
     * Convert
     * @param numbers 1D numbers array to be converted to a string
     * @return formatted string of a 1D numbers array
     */
    public static String getStr(double[] numbers) {
        // Create new message
        String message = "";

        // For each element in array
        for (int i = 0; i < numbers.length; i++) {
            // If not the last element
            if (i != numbers.length - 1)
                // Append to string with tab
                message += NUMBER_FORMAT.format(numbers[i]) + ",\t\t";
                // If it is the last element
            else
                // Append to string without tab
                message += NUMBER_FORMAT.format(numbers[i]);
        }

        // Return results
        return message.trim();
    }

    /**
     * Convert
     * @param numbers 2D numbers array to be converted to a string
     * @return formatted string of a 2D numbers array
     */
    public static String getStr(double[][] numbers) {
        // Create new message
        String message = "";

        // For each row in array
        for (int rowIndex = 0; rowIndex < numbers.length; rowIndex++)
            message += "Row #" + (rowIndex + 1) + ":  \t\t" + getStr(numbers[rowIndex]) + "\n";

        // Return results
        return message.trim();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------- Converters - String to String ----------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Convert
     * @param data 1D numbers array to be converted to a string
     * @return formatted string of a 1D numbers array
     */
    public static String getStr(String[] data) {
        // Create new message
        String message = "";

        // For each element in array
        for (int i = 0; i < data.length; i++) {
            // If not the last element
            if (i != data.length - 1)
                // Append to string with tab
                message += data[i] + ",\t\t";
                // If it is the last element
            else
                // Append to string without tab
                message += data[i];
        }

        // Return results
        return message.trim();
    }

    /**
     * Convert
     * @param data 2D numbers array to be converted to a string
     * @return formatted string of a 2D numbers array
     */
    public static String getStr(String[][] data) {
        // Create new message
        String message = "";

        // For each row in array
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++)
            message += "Row #" + (rowIndex + 1) + ":  \t\t" + getStr(data[rowIndex]) + "\n";

        // Return results
        return message.trim();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------- Converters - MLData objects to String -------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Convert
     * @param mlData MLData object
     * @return string representation of data
     */
    public static String getStr(MLData mlData) {
        // Return string of MLData's array
        return getStr(mlData.getData());
    }

    /**
     * Convert
     * @param mlData MLData object
     * @param normalizedField normalization data
     * @return denormalized string representation of data
     */
    public static String getStr(MLData mlData, NormalizedField normalizedField) {
        // Return string of MLData's array
        return getStr(UtilNormalizer.denormalize(mlData.getData(), normalizedField));
    }

    /**
     * Convert
     * @param mlDataPair MLDataPair object
     * @return string representation of data pair
     */
    public static String getStr(MLDataPair mlDataPair) {
        // Initialize message string
        String message = "MLDataPair:\n";

        // Get input data as a string
        String input = "\tInput:             " + getStr(mlDataPair.getInput()) + "\n";

        // Get output data as a string
        String output = "\tExpected Output:   " + getStr(mlDataPair.getIdeal());

        // Combine messages
        message += input + output;

        // Return resulting message
        return message;
    }

    /**
     * Convert
     * @param mlDataPair MLDataPair object
     * @param normalizedField normalization data
     * @return denormalized string representation of data pair
     */
    public static String getStr(MLDataPair mlDataPair, NormalizedField normalizedField) {
        // Initialize message string
        String message = "MLDataPair:\n";

        // Get input data as a string
        String input = "\tInput:             " + getStr(mlDataPair.getInput(), normalizedField) + "\n";

        // Get output data as a string
        String output = "\tExpected Output:   " + getStr(mlDataPair.getIdeal(), normalizedField);

        // Combine messages
        message += input + output;

        // Return resulting message
        return message;
    }

    /**
     * Convert
     * @param mlDataSet MLDataSet object
     * @return string representation of data set
     */
    public static String getStr(MLDataSet mlDataSet) {
        // Initialize message string
        String message = "MLDataSet:\n";

        // Initialize pair counter
        int pairCount = 1;

        // For each data pair in the set
        for (MLDataPair pair : mlDataSet) {
            // Add pair title to message
            message += "\tPair #" + pairCount + ":\n";

            // Add input to message
            message += "\t\tInput:             " + getStr(pair.getInput()) + "\n";

            // Add output to message
            message += "\t\tExpected Output:   " + getStr(pair.getIdeal()) + "\n";

            // Increment pair counter
            pairCount++;
        }

        // Return resulting message
        return message;
    }

    /**
     * Convert
     * @param mlDataSet MLDataSet object
     * @param normalizedField normalization data
     * @return denormalized string representation of data set
     */
    public static String getStr(MLDataSet mlDataSet, NormalizedField normalizedField) {
        // Initialize message string
        String message = "MLDataSet:\n";

        // Initialize pair counter
        int pairCount = 1;

        // For each data pair in the set
        for (MLDataPair pair : mlDataSet) {
            // Add pair title to message
            message += "\tPair #" + pairCount + ":\n";

            // Add input to message
            message += "\t\tInput:             " + getStr(pair.getInput(), normalizedField) + "\n";

            // Add output to message
            message += "\t\tExpected Output:   " + getStr(pair.getIdeal(), normalizedField) + "\n";

            // Increment pair counter
            pairCount++;
        }

        // Return resulting message
        return message;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}