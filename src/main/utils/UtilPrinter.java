package main.utils;

/**
 * Class that provides methods for simple printing of data
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public class UtilPrinter {
    public static void print(String[][] array2D) {
        for (String[] row : array2D) {
            for (String word : row)
                System.out.print(word + ", \t");
            System.out.print("\n");
        }
    }
}