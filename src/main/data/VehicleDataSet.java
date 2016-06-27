package main.data;

import main.constants.NormalizationLimits;
import main.utils.UtilArraysGeneric;
import main.utils.UtilDataSets;
import main.utils.UtilNormalizer;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.util.arrayutil.NormalizedField;

import java.io.Serializable;

public class VehicleDataSet implements Serializable
{
    private VehicleData[] vehiclesData;
    private double[][] inputTableRaw, outputTableRaw;
    private NormalizedField[] inputColumnsNormalizedFields, outputColumnsNormalizedFields;
    private double[][] inputTableNorm, outputTableNorm;
    private MLDataSet completeDataSet, trainingSet, testingSet;

    public VehicleDataSet(String[][] table) {
        this.initialize_CreateVehiclesData(table);
        this.initialize_CreateTablesRaw();
        this.initialize_CreateNormalizedFields();
        this.initialize_CreateTablesNorm();
        this.initialize_CreateDataSetComplete();
        this.initialize_CreateDataSetsTrainingTesting(0.1);
    }

    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------- Initialization ----------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void initialize_CreateVehiclesData(String[][] table) {
        // Create new array of vehicle data
        vehiclesData = new VehicleData[table.length];

        // For each element in the table
        for (int i = 0; i < table.length; i++)
            // Store it as vehicle data
            vehiclesData[i] = new VehicleData(table[i]);

        // Shuffle the resulting array
        vehiclesData = UtilArraysGeneric.shuffle(vehiclesData, 1);
    }

    private void initialize_CreateTablesRaw() {
        // Create new arrays
        this.inputTableRaw = new double[vehiclesData.length][vehiclesData[0].getInput().length];
        this.outputTableRaw = new double[vehiclesData.length][vehiclesData[0].getOutput().length];

        // For each vehicle data element
        for (int i = 0; i < vehiclesData.length; i++) {
            // Store its input
            inputTableRaw[i] = vehiclesData[i].getInput();

            // Store its output
            outputTableRaw[i] = vehiclesData[i].getOutput();
        }
    }

    private void initialize_CreateNormalizedFields() {
        inputColumnsNormalizedFields = UtilNormalizer.getNormalizedFieldsColumns(inputTableRaw, NormalizationLimits.MIN, NormalizationLimits.MAX);
        outputColumnsNormalizedFields = UtilNormalizer.getNormalizedFieldsColumns(outputTableRaw, NormalizationLimits.MIN, NormalizationLimits.MAX);
    }

    private void initialize_CreateTablesNorm() {
        inputTableNorm = UtilNormalizer.normalize(inputTableRaw, inputColumnsNormalizedFields);
        outputTableNorm = UtilNormalizer.normalize(outputTableRaw, outputColumnsNormalizedFields);
    }

    private void initialize_CreateDataSetComplete() {
        // Create new data set
        completeDataSet = new BasicMLDataSet();

        // For each vehicle data element
        for (int i = 0; i < vehiclesData.length; i++) {
            // Get input
            BasicMLData inputData = new BasicMLData(inputTableNorm[i]);

            // Get output
            BasicMLData outputData = new BasicMLData(outputTableNorm[i]);

            // Add input-output pair to the data set
            completeDataSet.add(new BasicMLDataPair(inputData, outputData));
        }
    }

    private void initialize_CreateDataSetsTrainingTesting(double testingRatio) {
        trainingSet = UtilDataSets.generateTrainingSet(completeDataSet, (int) (completeDataSet.size() * testingRatio));
        testingSet = UtilDataSets.generateTestingSet(completeDataSet, (int) (completeDataSet.size() * testingRatio));
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------- Getters ------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public NormalizedField[] getInputColumnsNormalizedFields() {
        return inputColumnsNormalizedFields;
    }

    public NormalizedField[] getOutputColumnsNormalizedFields() {
        return outputColumnsNormalizedFields;
    }

    public MLDataSet getTrainingSet() {
        return trainingSet;
    }

    public MLDataSet getTestingSet() {
        return testingSet;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}