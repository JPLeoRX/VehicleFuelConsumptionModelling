package main.utils;

import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;

/**
 * Class that provides methods for simple manipulation on Machine Learning Data Sets
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilDataSets
{
    /**
     * Create data set that will be used for training
     * @param completeDataSet full data set
     * @param numberOfTestingCases number of pairs in the testing data set
     * @return training data set
     */
    public static BasicMLDataSet generateTrainingSet(final MLDataSet completeDataSet, final int numberOfTestingCases) {
        // Create new data set
        BasicMLDataSet trainingSet = new BasicMLDataSet();

        // For each element that should be included in training data set
        for (int i = 0; i < completeDataSet.size() - numberOfTestingCases; i++) {
            // Obtain input and output
            double[] input = UtilArraysDouble.copy(completeDataSet.get(i).getInputArray());
            double[] output = UtilArraysDouble.copy(completeDataSet.get(i).getIdealArray());

            // Convert them back to ML format
            BasicMLData inputData = new BasicMLData(input);
            BasicMLData outputData = new BasicMLData(output);

            // Add input-output pair to new data set
            trainingSet.add(new BasicMLDataPair(inputData, outputData));
        }

        // Return the resulting data set
        return trainingSet;
    }

    /**
     * Create data set that will be used for testing
     * @param completeDataSet full data set
     * @param numberOfTestingCases number of pairs in the testing data set
     * @return testing data set
     */
    public static BasicMLDataSet generateTestingSet(final MLDataSet completeDataSet, final int numberOfTestingCases) {
        // Create new data set
        BasicMLDataSet testingSet = new BasicMLDataSet();

        // For each element that should be included in training data set
        for (int i = completeDataSet.size() - numberOfTestingCases; i < completeDataSet.size(); i++) {
            // Obtain input and output
            double[] input = UtilArraysDouble.copy(completeDataSet.get(i).getInputArray());
            double[] output = UtilArraysDouble.copy(completeDataSet.get(i).getIdealArray());

            // Convert them back to ML format
            BasicMLData inputData = new BasicMLData(input);
            BasicMLData outputData = new BasicMLData(output);

            // Add input-output pair to new data set
            testingSet.add(new BasicMLDataPair(inputData, outputData));
        }

        // Return the resulting data set
        return testingSet;
    }
}