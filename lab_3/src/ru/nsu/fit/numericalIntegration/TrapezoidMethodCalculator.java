package ru.nsu.fit.numericalIntegration;

public class TrapezoidMethodCalculator {

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
        return (getFunctionValue(intervalStart) + getFunctionValue(intervalEnd)) / 2 * (intervalEnd - intervalStart);
    }

    public double getApproximateValueOfTheIntegral(double intervalStart, double intervalEnd, double distanceBetweenNodes) {
        double res = 0;
        int numOfIntervals = (int) Math.ceil((intervalEnd - intervalStart) / distanceBetweenNodes);
        double start = intervalStart;
        for (int i = 0; i < numOfIntervals; ++i) {
            res += getIntegralMinNumberOfNodes(start, start + distanceBetweenNodes);
            start += distanceBetweenNodes;
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
