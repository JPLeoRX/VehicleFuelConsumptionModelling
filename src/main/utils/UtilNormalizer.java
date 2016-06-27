package main.utils;

import org.encog.util.arrayutil.NormalizeArray;
import org.encog.util.arrayutil.NormalizedField;

/**
 * Class that provides methods for simple normalization and denormalization of data
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilNormalizer
{
    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- Normalization Field -------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Obtain a normalized field
     */
    public static NormalizedField getNormalizedField(double[] arrayRaw, double normLimitMin, double normLimitMax) {
        // Create normalizer
        NormalizeArray norm = new NormalizeArray();

        // Set lower limit
        norm.setNormalizedLow(normLimitMin);

        // Set higher limit
        norm.setNormalizedHigh(normLimitMax);

        // Normalize the array
        norm.process(arrayRaw);

        // Return normalized field
        return norm.getStats();
    }

    /**
     * Obtain normalized fields for columns of 2D table
     */
    public static NormalizedField[] getNormalizedFieldsColumns(double[][] table, double normLimitMin, double normLimitMax) {
        // Create normalized fields array
        NormalizedField[] normalizedFields = new NormalizedField[table[0].length];

        // For each column in table
        for (int i = 0; i < normalizedFields.length; i++)
            // Obtain and store its normalized field
            normalizedFields[i] = getNormalizedField(UtilArraysDouble.getColumn(table, i), normLimitMin, normLimitMax);

        // Return results
        return normalizedFields;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //----------------------------------------- Single Element Operations ----------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Normalize one element
     */
    public static double normalize(double valueRaw, NormalizedField normalizedField) {
        // Normalize element
        return normalizedField.normalize(valueRaw);
    }

    /**
     * Denormalize one element
     */
    public static double denormalize(double valueNorm, NormalizedField normalizedField) {
        // Denormalize element
        return normalizedField.deNormalize(valueNorm);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------- Array Operations ---------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Normalize array
     */
    public static double[] normalize(double[] arrayRaw, NormalizedField normalizedField) {
        // Create new array
        double[] normalizedArray = new double[arrayRaw.length];

        // For each element
        for (int i = 0; i < arrayRaw.length; i++)
            // Normalize element
            normalizedArray[i] = normalize(arrayRaw[i], normalizedField);

        // Return results
        return normalizedArray;
    }

    /**
     * Normalize array
     */
    public static double[] normalize(double[] arrayRaw, NormalizedField[] normalizedFields) {
        // Create new array
        double[] normalizedArray = new double[arrayRaw.length];

        // For each element
        for (int i = 0; i < arrayRaw.length; i++)
            // Normalize element
            normalizedArray[i] = normalize(arrayRaw[i], normalizedFields[i]);

        // Return results
        return normalizedArray;
    }

    /**
     * Denormalize array
     */
    public static double[] denormalize(double[] arrayNorm, NormalizedField normalizedField) {
        // Create new array
        double[] denormalizedArray = new double[arrayNorm.length];

        // For each element
        for (int i = 0; i < arrayNorm.length; i++)
            // Denormalize element
            denormalizedArray[i] = denormalize(arrayNorm[i], normalizedField);

        // Return results
        return denormalizedArray;
    }

    /**
     * Denormalize array
     */
    public static double[] denormalize(double[] arrayNorm, NormalizedField[] normalizedFields) {
        // Create new array
        double[] denormalizedArray = new double[arrayNorm.length];

        // For each element
        for (int i = 0; i < arrayNorm.length; i++)
            // Denormalize element
            denormalizedArray[i] = denormalize(arrayNorm[i], normalizedFields[i]);

        // Return results
        return denormalizedArray;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------- Table Operations ---------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Normalize table
     */
    public static double[][] normalize(double[][] tableRaw, NormalizedField[] normalizedFields) {
        // Create new table
        double[][] normalizedTable = new double[tableRaw.length][tableRaw[0].length];

        // For each row
        for (int row = 0; row < tableRaw.length; row++)
            // For each col
            for (int col = 0; col < normalizedFields.length; col++)
                // Normalize element
                normalizedTable[row][col] = normalize(tableRaw[row][col], normalizedFields[col]);

        // Return results
        return normalizedTable;
    }

    /**
     * Denormalize table
     */
    public static double[][] denormalize(double[][] tableNorm, NormalizedField[] normalizedFields) {
        // Create new table
        double[][] denormalizedTable = new double[tableNorm.length][tableNorm[0].length];

        // For each row
        for (int row = 0; row < tableNorm.length; row++)
            // For each col
            for (int col = 0; col < normalizedFields.length; col++)
                // Denormalize element
                denormalizedTable[row][col] = denormalize(tableNorm[row][col], normalizedFields[col]);

        // Return results
        return denormalizedTable;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}