package ru.nsu.fit.iterAlgorithm;

public class IterMethodsCalculator {

    public double getIthValByNewtonMethod(int i) {
        NewtonMethodCalc newtonMethodCalc = new NewtonMethodCalc();
        return newtonMethodCalc.getIthValue(i);
    }

    public double getIthValByOneTangentMethod(int i) {
        OneTangentMethodCalc oneTangentMethodCalc = new OneTangentMethodCalc();
        return oneTangentMethodCalc.getIthValue(i);
    }

    public double getIthValBySecantMethod(int i) {
        SecantMethodCalc secantMethodCalc = new SecantMethodCalc();
        return secantMethodCalc.getIthValue(i);
    }

    public double getCalcError(double res) {
        return Math.abs(res - Math.sqrt(5));
    }
}
