package main.utils;

/**
 * Class that provides methods for simple manipulation on arrays with doubles
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilArraysDouble
{
    /**
     * Combine two arrays into one
     * @param a 1st array
     * @param b 2nd array
     * @return merged array
     */
    public static double[] merge(final double[] a, final double[] b) {
        // Create new array
        double[] c = new double[a.length + b.length];

        // Copy the first array
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];

        // Copy the second array
        for (int j = 0; j < b.length; j++)
            c[a.length + j] = b[j];

        // Return results
        return c;
    }

    /**
     * Extract one row from a 2D array
     * @param data a 2D array
     * @param rowIndex index of row
     * @return row at specified index
     */
    public static double[] getRow(final double[][] data, final int rowIndex) {
        // Create new array
        double[] row = new double[data[0].length];

        // For each element in row
        for (int i = 0; i < row.length; i++)
            // Save element
            row[i] = data[rowIndex][i];

        // Return result
        return row;
    }

    /**
     * Extract one column from a 2D array
     * @param data a 2D array
     * @param colIndex index of column
     * @return column at specified index
     */
    public static double[] getColumn(final double[][] data, final int colIndex) {
        // Create new array
        double[] col = new double[data.length];

        // For each element in column
        for (int i = 0; i < col.length; i++)
            // Save element
            col[i] = data[i][colIndex];

        // Return result
        return col;
    }

    /**
     * Clone a double 1D array
     * @param data original array
     * @return cloned 1D arrau
     */
    public static double[] copy(final double[] data) {
        // Create new array
        double[] clone = new double[data.length];

        // Copy each element
        for (int i = 0; i < data.length; i++)
            clone[i] = data[i];

        // Return results
        return clone;
    }
}