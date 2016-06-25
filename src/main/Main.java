package main;

import main.utils.UtilExcel;

public class Main {
    public static void main(String[] args) {
        String[][] table = UtilExcel.readTable(FilesWithData.DATA_TABLE_FILEPATH, FilesWithData.DATA_TABLE_NUMBER_OF_ROWS, FilesWithData.DATA_TABLE_NUMBER_OF_COLS, FilesWithData.DATA_TABLE_SHEET_INDEX);
        System.out.println("Table read");
    }
}
