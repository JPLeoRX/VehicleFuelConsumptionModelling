package main.utils;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;

/**
 * Class that provides methods for simple creation of Neural Networks
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilNetworks
{
    /**
     * Multi Layer Perceptron (MLP) creation, also known as conventional Feed-Forward Neural Network
     * This method builds a feed-forward neural network with given input and output sizes
     * The number of hidden layers and amount of neurons there is specified
     * The activation function is ActivationSigmoid
     *
     * @see BasicNetwork
     * @see BasicLayer
     * @see ActivationSigmoid
     *
     * @param numberOfInputNeurons inputs to the network
     * @param numberOfHiddenNeurons array of hidden neurons, {1, 2, 3} will result in 3 hidden layers with count of neurons corresponding to the elements in the array
     * @param numberOfOutputNeurons outputs of the network
     * @return created BasicNetwork object
     */
    public static BasicNetwork createMLP(final int numberOfInputNeurons, final int[] numberOfHiddenNeurons, final int numberOfOutputNeurons) {
        // Create new network
        BasicNetwork network = new BasicNetwork();

        // Add input layer
        network.addLayer(new BasicLayer(null, true, numberOfInputNeurons));

        // Add hidden layer(s)
        for (int layerNeurons : numberOfHiddenNeurons)
            network.addLayer(new BasicLayer(new ActivationSigmoid(), true, layerNeurons));

        // Add output layer
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, numberOfOutputNeurons));

        // Finish structure
        network.getStructure().finalizeStructure();

        // Reset weights
        network.reset(1);

        // Return network
        return network;
    }
}