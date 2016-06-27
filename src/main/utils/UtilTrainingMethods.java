package main.utils;

import org.encog.ml.data.MLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.neural.networks.training.propagation.scg.ScaledConjugateGradient;

/**
 * Class that provides methods for simple creation of training methods
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilTrainingMethods
{
    /**
     * Creates a basic Back Propagation training method
     *
     * @see Backpropagation
     *
     * @param network network to be trained
     * @param trainingSet training data set
     * @param learningRate learning rate
     * @param learningMomentum learning momentum
     * @return the MLTrain object, ready for training
     */
    public static MLTrain createBackpropagation(final BasicNetwork network, final MLDataSet trainingSet, final double learningRate, final double learningMomentum) {
        // Create back propagation method
        Backpropagation backpropagation = new Backpropagation(network, trainingSet, learningRate, learningMomentum);

        // Return resulting method
        return backpropagation;
    }

    /**
     * Creates a basic Resilient Propagation training method
     *
     * @see ResilientPropagation
     *
     * @param network network to be trained
     * @param trainingSet training data set
     * @param learningRate learning rate
     * @param learningMomentum learning momentum
     * @return the MLTrain object, ready for training
     */
    public static MLTrain createResilientPropagation(final BasicNetwork network, final MLDataSet trainingSet, final double learningRate, final double learningMomentum) {
        // Create resilient propagation method
        ResilientPropagation resilientPropagation = new ResilientPropagation(network, trainingSet, learningRate, learningMomentum);

        // Return resulting method
        return resilientPropagation;
    }

    /**
     * Creates a basic Scaled Conjugate Gradient training method
     *
     * @see ScaledConjugateGradient
     *
     * @param network network to be trained
     * @param trainingSet training data set
     * @return the MLTrain object, ready for training
     */
    public static MLTrain createScaledConjugateGradient(final BasicNetwork network, final MLDataSet trainingSet) {
        // Create resilient propagation method
        ScaledConjugateGradient scaledConjugateGradient = new ScaledConjugateGradient(network, trainingSet);

        // Return resulting method
        return scaledConjugateGradient;
    }
}