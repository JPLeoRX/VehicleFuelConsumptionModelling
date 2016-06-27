package main.helpers;

import main.utils.machine_learning.UtilError;

public class ErrorTuple
{
    private double errorPercentage;
    private double errorMeanSquared;
    private double errorRootMeanSquared;

    public ErrorTuple(final double[] outputExpected, final double[] outputActual) {
        this.errorPercentage = UtilError.getPercentageError(outputExpected, outputActual);
        this.errorMeanSquared = UtilError.getMeanSquaredError(outputExpected, outputActual);
        this.errorRootMeanSquared = UtilError.getRootMeanSquaredError(outputExpected, outputActual);
    }

    public double getErrorPercentage() {
        return errorPercentage;
    }

    public double getErrorMeanSquared() {
        return errorMeanSquared;
    }

    public double getErrorRootMeanSquared() {
        return errorRootMeanSquared;
    }
}