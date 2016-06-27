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
    public static double[] merge(double[] a, double[] b) {
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
}