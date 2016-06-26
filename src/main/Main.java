package main;

import main.data.Filter;
import main.utils.UtilExcel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Execution started");

        String[][] table = UtilExcel.readTable(FilesWithData.DATA_TABLE_MODIFIED_FILEPATH, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_ROWS, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_COLS, FilesWithData.DATA_TABLE_MODIFIED_SHEET_INDEX);
        System.out.println("Table read");

        String[][] gasolineOnly = Filter.selectGasolineOnly(table);
        String[][] dieselOnly = Filter.selectDieselOnly(table);
    }
}
