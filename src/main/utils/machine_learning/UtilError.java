package main.utils.machine_learning;

/**
 * Class that provides methods for simple error calculations
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public abstract class UtilError
{
    /**
     * Compute the average error
     * @param outputExpected theoretical values
     * @param outputActual actual values
     * @return average error
     */
    public static double getPercentageError(final double[] outputExpected, final double[] outputActual) {
        // Create net error
        double netError = 0;

        // For each element
        for (int i = 0; i < outputActual.length; i++) {
            // Compute temporary error
            double tempError = Math.abs((outputActual[i] - outputExpected[i]) / outputExpected[i]);

            // Increment net error
            netError += tempError;
        }

        // Average the net error
        netError = netError / outputActual.length;

        // Return the net error
        return netError;
    }

    /**
     * Compute the mean squared error (MSE)
     * @param outputExpected theoretical values
     * @param outputActual actual values
     * @return mean squared error
     */
    public static double getMeanSquaredError(final double[] outputExpected, final double[] outputActual) {
        // Create net error
        double netError = 0;

        // For each element
        for (int i = 0; i < outputActual.length; i++) {
            // Compute temporary error
            double tempError = Math.pow((outputExpected[i] - outputActual[i]), 2);

            // Increment net error
            netError += tempError;
        }

        // Average the net error
        netError = netError / outputActual.length;

        // Return the net error
        return netError;
    }

    /**
     * Compute the root mean squared error (RMSE)
     * @param outputExpected theoretical values
     * @param outputActual actual values
     * @return root mean squared error
     */
    public static double getRootMeanSquaredError(final double[] outputExpected, final double[] outputActual) {
        // Create net error
        double netError = 0;

        // For each element
        for (int i = 0; i < outputActual.length; i++) {
            // Compute temporary error
            double tempError = Math.pow((outputExpected[i] - outputActual[i]), 2);

            // Increment net error
            netError += tempError;
        }

        // Average the net error
        netError = netError / outputActual.length;

        // Obtain root
        netError = Math.sqrt(netError);

        // Return the net error
        return netError;
    }
}