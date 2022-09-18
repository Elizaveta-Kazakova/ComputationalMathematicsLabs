package ru.nsu.fit.iterAlgorithm;

public class Main {
    public static void main(String[] args) {
        IterMethodsCalculator iterMethodsCalculator = new IterMethodsCalculator();
        System.out.println("newton method x_2 = " + iterMethodsCalculator.getIthValByNewtonMethod(2));
        System.out.println("error is = "
                + iterMethodsCalculator.getCalcError(iterMethodsCalculator.getIthValByNewtonMethod(2)));
        System.out.println("one tangent method x_2 = " + iterMethodsCalculator.getIthValByOneTangentMethod(2));
        System.out.println("error is = "
                + iterMethodsCalculator.getCalcError(iterMethodsCalculator.getIthValByOneTangentMethod(2)));
        System.out.println("secant method x_2 = " + iterMethodsCalculator.getIthValBySecantMethod(2));
        System.out.println("error is = "
                + iterMethodsCalculator.getCalcError(iterMethodsCalculator.getIthValBySecantMethod(2)));
        System.out.println("sqrt of 5 = " + Math.sqrt(5));
    }
}
