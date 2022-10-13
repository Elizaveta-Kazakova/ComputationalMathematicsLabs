package ru.nsu.fit.numericalIntegration;

public class NumericalIntegrationCalculator {

    private TrapezoidMethodCalculator trapezoidMethodCalculator = new TrapezoidMethodCalculator();
    private SimpsonsMethodCalculator simpsonsMethodCalculator = new SimpsonsMethodCalculator();

    public double getIntegralByTrapezoidMethod(double intervalStart, double intervalEnd, double distanceBetweenNodes) {
        return trapezoidMethodCalculator.getApproximateValueOfTheIntegral(intervalStart,
                intervalEnd, distanceBetweenNodes);
    }

    public double getIntegralBySimpsonsMethod(double intervalStart, double intervalEnd, double distanceBetweenNodes) {
        return simpsonsMethodCalculator.getApproximateValueOfTheIntegral(intervalStart,
                intervalEnd, distanceBetweenNodes);
    }

    public double getDegreeOfLeadingErrorTermByTrapezoidMethod(double intervalStart,
                                                            double intervalEnd, double distanceBetweenNodes) {
        return trapezoidMethodCalculator.getDegreeOfLeadingErrorTerm(intervalStart, intervalEnd, distanceBetweenNodes);
    }

    public double getDegreeOfLeadingErrorTermBySimpsonsMethod(double intervalStart,
                                                            double intervalEnd, double distanceBetweenNodes) {
        return simpsonsMethodCalculator.getDegreeOfLeadingErrorTerm(intervalStart, intervalEnd, distanceBetweenNodes);
    }
}
