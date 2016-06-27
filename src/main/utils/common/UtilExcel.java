package main.utils.common;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Class that provides methods for simple reading of data from Excel files
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilExcel
{
    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------- Core Methods ------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Read an Excel table into a 2D array
     * @param tableFilepath path to the Excel table
     * @param tableNumberOfRows number of rows
     * @param tableNumberOfColumns number of columns
     * @param tableSheetIndex index of the sheet where the table is stored
     * @return a 2D array of data from the table
     */
    public static String[][] readTable(final String tableFilepath, final int tableNumberOfRows, final int tableNumberOfColumns, final int tableSheetIndex) {
        // Create a new 2D array, to store the results
        final String[][] data = new String[tableNumberOfRows][tableNumberOfColumns];

        // Create a workbook
        final XSSFWorkbook workbook = openWorkBook(new File(tableFilepath));

        // Get a sheet with data from the workbook
        final XSSFSheet sheet = workbook.getSheetAt(tableSheetIndex);

        // For each row in a sheet
        for (Row row : sheet)
            // For each cell in a row
            for (Cell cell : row)
                // Save data from cell in 2D array
                data[cell.getRowIndex()][cell.getColumnIndex()] = getCellValue(cell);

        // Close the workbook
        closeWorkBook(workbook);

        // Return results
        return data;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ Helpers IO ------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Open a workbook
     * @param file file to open
     * @return opened workbook
     */
    private static XSSFWorkbook openWorkBook(final File file) {
        // Create new workbook
        XSSFWorkbook workbook = null;

        // Try opening
        try { workbook = new XSSFWorkbook(OPCPackage.open(file)); }

        // Catch errors
        catch (Exception e) { e.printStackTrace(); }

        // Return result
        return workbook;
    }

    /**
     * Close a workbook
     * @param workbook workbook to close
     */
    private static void closeWorkBook(final XSSFWorkbook workbook) {
        // Try closing
        try { workbook.close(); }

        // Catch errors
        catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Get the data stored in Excel cell in String representation
     * @param cell the cell in Excel table
     * @return data from the cell as a string
     */
    private static String getCellValue(final Cell cell) {
        // If it's a string
        if (cell.getCellType() == Cell.CELL_TYPE_STRING)
            return cell.getStringCellValue();

        // If it's a digit
        else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
            return String.valueOf(cell.getNumericCellValue());

        // If it's a boolean
        else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
            return String.valueOf(cell.getBooleanCellValue());

        // If it's empty
        else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
            return "";

        // If none of the above - throw exception
        else
            throw new IllegalArgumentException("Unrecognized or invalid cell type");
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}