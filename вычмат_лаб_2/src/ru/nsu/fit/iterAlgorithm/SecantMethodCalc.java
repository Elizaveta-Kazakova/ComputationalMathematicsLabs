package ru.nsu.fit.iterAlgorithm;

public class SecantMethodCalc {
    private static final double INITIAL_VAL = 3;
    private static final int VALUE_NUM_FOR_NEWTON_METHOD = 1;

    //f(x) = x^2 - 5 = 0
    private double getFunctionValue(double x) {
        return x * x - 5;
    }

    private double getInitialNextValue() {
        NewtonMethodCalc newtonMethodCalc = new NewtonMethodCalc();
        return newtonMethodCalc.getIthValue(VALUE_NUM_FOR_NEWTON_METHOD);
    }

    public double getIthValue(int i) {
        double previousValue = INITIAL_VAL; // x_0
        double res = getInitialNextValue(); // x_1
        int numOfIteration = 1;
        while(numOfIteration < i) {
            ++numOfIteration;
            double newRes = res - (getFunctionValue(res) * (res - previousValue) /
                    (getFunctionValue(res) - getFunctionValue(previousValue)));
            previousValue = res;
            res = newRes;
        }
        return res;
    }
}
