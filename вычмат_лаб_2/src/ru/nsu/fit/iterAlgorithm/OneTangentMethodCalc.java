package ru.nsu.fit.iterAlgorithm;

public class OneTangentMethodCalc {
    private static final double INITIAL_VAL = 3;

    //f(x) = x^2 - 5 = 0
    private double getFunctionValue(double x) {
        return x * x - 5;
    }

    // f`(x) = 2*x
    private double getValueOfDerivative(double x) {
        return 2 * x;
    }

    public double getIthValue(int i) {
        int numOfIteration = 0;
        double res = INITIAL_VAL;
        while(numOfIteration != i) {
            ++numOfIteration;
            res = res - (getFunctionValue(res) / getValueOfDerivative(INITIAL_VAL));
        }
        return res;
    }
}
