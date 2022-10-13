package ru.nsu.fit.numericalIntegration;

public class SimpsonsMethodCalculator {
    private static final int NUM_OF_NODES_IN_INTERVAL = 3;

    public static double log2(double N)
    {
        // calculate log2 N indirectly
        // using log() method
        double result = (Math.log(N) / Math.log(2));

        return result;
    }

    private double getFunctionValue(double argument) {
        return Math.sin(argument);
    }

    private double getExactFunctionIntegral(double intervalStart, double intervalEnd) {
        return Math.ceil(-Math.cos(intervalEnd) + Math.cos(intervalStart));
    }

    private double getIntegralMinNumberOfNodes(double intervalStart, double intervalEnd) {
        return ((intervalEnd - intervalStart) / 6) * (getFunctionValue(intervalStart) +
                4 * getFunctionValue((intervalStart + intervalEnd) / 2) + getFunctionValue(intervalEnd));
    }

    public double getApproximateValueOfTheIntegral(double intervalStart, double intervalEnd, double distanceBetweenNodes) {
        double intervalLength = (NUM_OF_NODES_IN_INTERVAL - 1) * distanceBetweenNodes; // interval between nodes = 2h
        int numOfIntervals = (int) Math.ceil((intervalEnd - intervalStart) / intervalLength);
        double start = intervalStart;
        double res = 0;
        for (int i = 0; i < numOfIntervals; ++i) {
            //res += getIntegralMinNumberOfNodes(start, start + intervalLength);
            res += (getFunctionValue(start) + getFunctionValue(start + intervalLength) +
                    4 * getFunctionValue(distanceBetweenNodes + start)) * distanceBetweenNodes / 3;
            start += intervalLength;
        }
        return res;
    }

    public double getDegreeOfLeadingErrorTerm(double intervalStart, double intervalEnd, double distanceBetweenNodes) {
        double numerator = Math.abs(getApproximateValueOfTheIntegral(intervalStart, intervalEnd, distanceBetweenNodes)
                - getExactFunctionIntegral(intervalStart, intervalEnd));
        double denominator = Math.abs(getApproximateValueOfTheIntegral(intervalStart, intervalEnd,
                distanceBetweenNodes / 2) - getExactFunctionIntegral(intervalStart, intervalEnd));
        return log2(numerator / denominator);
    }
}
