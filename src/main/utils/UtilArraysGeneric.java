package main.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that provides methods for simple manipulation on arrays with generic objects
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilArraysGeneric
{
    /**
     * Extract one row from a 2D array
     * @param data a 2D array
     * @param dataClass the class of data objects
     * @param rowIndex index of row
     * @return row at specified index
     */
    public static <E> E[] getRow(final E[][] data, final Class<E> dataClass, final int rowIndex) {
        // Create new array
        final E[] row = (E[]) Array.newInstance(dataClass, data[0].length);

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
     * @param dataClass the class of data objects
     * @param colIndex index of column
     * @return column at specified index
     */
    public static <E> E[] getColumn(final E[][] data, final Class<E> dataClass, final int colIndex) {
        // Create new array
        final E[] col = (E[]) Array.newInstance(dataClass, data.length);

        // For each element in column
        for (int i = 0; i < col.length; i++)
            // Save element
            col[i] = data[i][colIndex];

        // Return result
        return col;
    }

    /**
     * Convert Array List of arrays into a 2D array
     * @param arrayList the array list to be converted
     * @param dataClass the class of data objects
     * @return
     */
    public static <E> E[][] getArray2D(final ArrayList<E[]> arrayList, final Class<E> dataClass) {
        // Create new array
        E[][] array2D = (E[][]) Array.newInstance(dataClass, arrayList.size(), arrayList.get(0).length);

        // For each row
        for (int rowIndex = 0; rowIndex < array2D.length; rowIndex++)
            // Copy the row
            array2D[rowIndex] = arrayList.get(rowIndex);

        // Return result
        return array2D;
    }
}