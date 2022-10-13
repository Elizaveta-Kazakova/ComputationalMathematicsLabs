package ru.nsu.fit.numericalIntegration;

public class Main {
    public static void main(String[] args) {
        NumericalIntegrationCalculator integrationCalculator = new NumericalIntegrationCalculator();
        System.out.println("Approximate value of the integral by trapezoid method where h = pi / (2 * 100) is " +
                integrationCalculator.getIntegralByTrapezoidMethod(0, Math.PI / 2,
                        Math.PI / (2 * 100)));
        System.out.println("Approximate value of the integral by trapezoid method where h = pi / (2 * 1000) is " +
                integrationCalculator.getIntegralByTrapezoidMethod(0, Math.PI / 2,
                        Math.PI / (2 * 1000)));
        System.out.println("Approximate value of the integral by simpsons method where h = pi / (2 * 100) is " +
                integrationCalculator.getIntegralBySimpsonsMethod(0, Math.PI / 2,
                        Math.PI / (2 * 100)));
        System.out.println("Approximate value of the integral by simpsons method where h = pi / (2 * 1000) is " +
                integrationCalculator.getIntegralBySimpsonsMethod(0, Math.PI / 2,
                        Math.PI / (2 * 1000)));

        System.out.println("error order by trapezoid method where h = pi / (2 * 100) is " +
                integrationCalculator.getDegreeOfLeadingErrorTermByTrapezoidMethod(0, Math.PI / 2,
                Math.PI / (2 * 100)));
        System.out.println("error order by trapezoid method where h = pi / (2 * 1000) is " +
                integrationCalculator.getDegreeOfLeadingErrorTermByTrapezoidMethod(0, Math.PI / 2,
                Math.PI / (2 * 1000)));
        System.out.println("error order by simpsons method where h = pi / (2 * 100) is " +
                integrationCalculator.getDegreeOfLeadingErrorTermBySimpsonsMethod(0, Math.PI / 2,
                Math.PI / (2 * 100)));
        System.out.println("error order by simpsons method where h = pi / (2 * 1000) is " +
                integrationCalculator.getDegreeOfLeadingErrorTermBySimpsonsMethod(0, Math.PI / 2,
                Math.PI / (2 * 1000)));
    }
}
