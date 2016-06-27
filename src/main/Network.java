package main;

import main.data.VehicleDataSet;
import main.helpers.ErrorTuple;
import main.utils.UtilPrinter;
import main.utils.machine_learning.UtilNetworks;
import main.utils.machine_learning.UtilNormalizer;
import main.utils.machine_learning.UtilTrainingMethods;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;

public class Network
{
    private int numberOfInputs;
    private int[] hiddenStructure;
    private int numberOfOutputs;
    private double learningRate;
    private double learningMomentum;

    private VehicleDataSet vehicleDataSet;
    private MLDataSet trainingSet;
    private MLDataSet testingSet;

    private BasicNetwork network;
    private MLTrain trainingMethod;

    public Network(int numberOfInputs, int[] hiddenStructure, int numberOfOutputs, VehicleDataSet vehicleDataSet, double learningRate, double learningMomentum) {
        this.numberOfInputs = numberOfInputs;
        this.hiddenStructure = hiddenStructure;
        this.numberOfOutputs = numberOfOutputs;

        this.vehicleDataSet = vehicleDataSet;
        this.trainingSet = vehicleDataSet.getTrainingSet();
        this.testingSet = vehicleDataSet.getTestingSet();

        this.learningRate = learningRate;
        this.learningMomentum = learningMomentum;

        this.network = UtilNetworks.createMLP(numberOfInputs, hiddenStructure, numberOfOutputs);
        this.trainingMethod = UtilTrainingMethods.createResilientPropagation(network, trainingSet, learningRate, learningMomentum);
    }


    /**
     * Train the network
     * @param maxEpochs limit in maximum epochs
     */
    public void train(int maxEpochs, boolean print) {
        // Initialize epoch
        int epoch = 0;

        // While current epoch is less than maximum epoch
        while (epoch < maxEpochs) {
            // Perform training
            trainingMethod.iteration();

            // Increment epoch
            epoch++;

            // Print results
            if (print)
                System.out.println("Epoch #" + epoch + "\tTraining Error:   " + trainingMethod.getError());
        }

        // Finalize training
        trainingMethod.finishTraining();
    }

    /**
     * Test the network
     * @param testingSet
     * @param print
     */
    public void test(MLDataSet testingSet, boolean print) {
        // Initialize testing counter
        int testCount = 0;

        // Initialize total error counter
        double totalPercentageError = 0;
        double totalMeanSquaredError = 0;
        double totalRootMeanSquaredError = 0;

        // For each data pair in testing set
        for (MLDataPair dataPair : testingSet) {
            // Get input, expected output, actual output
            double[] input = dataPair.getInputArray();
            double[] outputExpected = dataPair.getIdealArray();
            double[] outputActual = network.compute(dataPair.getInput()).getData();

            // Denormalize the data
            double[] denormalizedInput = UtilNormalizer.denormalize(input, vehicleDataSet.getInputColumnsNormalizedFields());
            double[] denormalizedOutputExpected = UtilNormalizer.denormalize(outputExpected, vehicleDataSet.getOutputColumnsNormalizedFields());;
            double[] denormalizedOutputActual = UtilNormalizer.denormalize(outputActual, vehicleDataSet.getOutputColumnsNormalizedFields());

            // Compute the error
            ErrorTuple errorTuple = new ErrorTuple(denormalizedOutputExpected, denormalizedOutputActual);

            // Increment total error
            totalPercentageError += errorTuple.getErrorPercentage();
            totalMeanSquaredError += errorTuple.getErrorMeanSquared();
            totalRootMeanSquaredError += errorTuple.getErrorRootMeanSquared();

            // Print results
            if (print) {
                System.out.println("Test #" + testCount + ":");
                System.out.println("\t\tInput:                     " + UtilPrinter.getStr(denormalizedInput));
                System.out.println("\t\tOutput Expected:           " + UtilPrinter.getStr(denormalizedOutputExpected));
                System.out.println("\t\tOutput Actual:             " + UtilPrinter.getStr(denormalizedOutputActual));
                System.out.println("\t\tPercentage Error:          " + UtilPrinter.getStr(errorTuple.getErrorPercentage() * 100) + "%");
                System.out.println("\t\tMean Squared Error:        " + UtilPrinter.getStr(errorTuple.getErrorMeanSquared()));
                System.out.println("\t\tRoot Mean Squared Error:   " + UtilPrinter.getStr(errorTuple.getErrorRootMeanSquared()));
            }

            // Increment counter
            testCount++;
        }

        // Average the total error
        totalPercentageError = totalPercentageError / testCount;
        totalMeanSquaredError = totalMeanSquaredError / testCount;
        totalRootMeanSquaredError = totalRootMeanSquaredError / testCount;

        // Print results
        if (print) {
            System.out.println("Total Percentage Error:           " + UtilPrinter.getStr(totalPercentageError * 100) + "%");
            System.out.println("Total Mean Squared Error:         " + UtilPrinter.getStr(totalMeanSquaredError));
            System.out.println("Total Root Mean Squared Error:    " + UtilPrinter.getStr(totalRootMeanSquaredError));
        }
    }
}