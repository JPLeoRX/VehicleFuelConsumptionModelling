package main;

import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;

/**
 * Created by Leo on 28-Jun-16.
 */
public class Network
{
    private BasicNetwork network;
    private MLTrain trainingMethod;

    /**
     * Train the network
     * @param maxEpochs limit in maximum epochs
     */
    public void train(int maxEpochs) {
        // Initialize epoch
        int epoch = 0;

        // While current epoch is less than maximum epoch
        while (epoch < maxEpochs) {
            // Perform training
            trainingMethod.iteration();

            // Increment epoch
            epoch++;

            // Print results
            System.out.println("Epoch #" + epoch + "\tTraining Error:   " + trainingMethod.getError());
        }

        // Finalize training
        trainingMethod.finishTraining();
    }
}
