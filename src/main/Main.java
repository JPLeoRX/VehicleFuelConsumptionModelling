package main;

import main.constants.FilesWithData;
import main.data.*;
import main.utils.common.UtilExcel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Execution started");

        String[][] table = UtilExcel.readTable(FilesWithData.DATA_TABLE_MODIFIED_FILEPATH, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_ROWS, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_COLS, FilesWithData.DATA_TABLE_MODIFIED_SHEET_INDEX);
        System.out.println("Table read");

        String[][] gasolineOnly = DataFilter.selectGasolineOnly(table);
        String[][] dieselOnly = DataFilter.selectDieselOnly(table);
        System.out.println("Table filtered");

        VehicleDataSet vehicleDataSet = new VehicleDataSet(gasolineOnly);
        System.out.println("Dataset created");

        Network network = new Network(vehicleDataSet.getInputColumnsNormalizedFields().length, new int[]{100}, vehicleDataSet.getOutputColumnsNormalizedFields().length, vehicleDataSet, 0.9, 0.5);
        network.test(vehicleDataSet.getTestingSet(), true);

        System.out.println("Execution finished");
    }
}
