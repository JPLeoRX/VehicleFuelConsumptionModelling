package main;

import main.data.DataFilter;
import main.data.VehicleDataBody;
import main.data.VehicleDataEngine;
import main.data.VehicleDataFuelConsumption;
import main.utils.UtilExcel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Execution started");

        String[][] table = UtilExcel.readTable(FilesWithData.DATA_TABLE_MODIFIED_FILEPATH, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_ROWS, FilesWithData.DATA_TABLE_MODIFIED_NUMBER_OF_COLS, FilesWithData.DATA_TABLE_MODIFIED_SHEET_INDEX);
        System.out.println("Table read");

        String[][] gasolineOnly = DataFilter.selectGasolineOnly(table);
        String[][] dieselOnly = DataFilter.selectDieselOnly(table);

        //UtilPrinter.print(dieselOnly);
        //System.out.print(dieselOnly.length);

        for (String[] row : gasolineOnly)
        {
            VehicleDataEngine vehicleEngineData = new VehicleDataEngine(row);
            VehicleDataBody vehicleBodyData = new VehicleDataBody(row);
            VehicleDataFuelConsumption vehicleDataFuelConsumption = new VehicleDataFuelConsumption(row);

            //System.out.println(vehicleEngineData);
            //System.out.println(vehicleBodyData);
            System.out.println(vehicleDataFuelConsumption);
        }

        System.out.println("Number of diesel cars: " + dieselOnly.length);
        System.out.println("Number of benzin cars: " + gasolineOnly.length);
    }
}
