package ru.nsu.fit.compMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

// calculating functions like f(x) = x^3 + ax^2 + bx + c
public record EquationCalculator(double epsilon, double delta, double a, double b, double c) {
    public static final double TRIAL_VALUE = 0;
    private static final double DERIVATIVE_A = 3;
    public static final int INDEX_FIRST_EL = 0;
    public static final int INDEX_SECOND_EL = 1;

    private double getFunctionValue(double x) {
        return pow(x, 3) + a * pow(x, 2) + b * x + c;
    }

    private List<Double> getFunctionZeros(double a, double b, double c) {
        double D = getDiscriminant(a, b, c);
        double alpha = (-b + Math.sqrt(D)) / (2 * a);
        double betta = (-b - Math.sqrt(D)) / (2 * a);
        return new ArrayList<>(Arrays.asList(alpha, betta));
    }

    private List<Double> handlePositiveCase() {
        double derivativeB = 2 * a;
        List<Double> extremes = getFunctionZeros(DERIVATIVE_A, derivativeB, b);
        Collections.sort(extremes);
        double alpha = extremes.get(INDEX_FIRST_EL);
        double betta = extremes.get(INDEX_SECOND_EL);
        if (getFunctionValue(alpha) > epsilon && getFunctionValue(betta) > epsilon) {
            return handleOneRootInInfCase(alpha);
        }
        if (getFunctionValue(alpha) < -epsilon && getFunctionValue(betta) < -epsilon) {
            return handleOneRootInInfCase(betta);
        }
        if (getFunctionValue(alpha) > epsilon && Math.abs(getFunctionValue(betta)) < epsilon) {
            return Arrays.asList(betta, handleOneRootInInfCase(alpha).get(INDEX_FIRST_EL));
        }
        if (Math.abs(getFunctionValue(alpha)) < epsilon && getFunctionValue(betta) < epsilon) {
            return Arrays.asList(alpha, handleOneRootInInfCase(betta).get(INDEX_FIRST_EL));
        }
        if (getFunctionValue(alpha) > epsilon && getFunctionValue(betta) < -epsilon) {
            return Arrays.asList(handleOneRootInInfCase(alpha).get(INDEX_FIRST_EL),
                    handleOneRootInInfCase(betta).get(INDEX_FIRST_EL), getRootByDichotomyMethod(alpha, betta));
        }
        if (Math.abs(getFunctionValue(alpha)) < epsilon && Math.abs(getFunctionValue(betta)) < epsilon) {
            return Collections.singletonList((alpha + betta) / 2);
        }
        throw new RuntimeException("incorrect condition f(a) = " + getFunctionValue(alpha) + " and f(b) = " + getFunctionValue(betta));
    }

    private double getRightBoundary(double initValue) { // leftBoundary = rightBoundary - delta
        double rightBoundary = initValue;
        double leftBoundary = initValue;
        if (getFunctionValue(initValue) < -epsilon) {
            while (getFunctionValue(rightBoundary) <= 0) {
               rightBoundary += delta;
            }
        }
        if (getFunctionValue(initValue) > epsilon) {
            while (getFunctionValue(leftBoundary) >= 0) {
                leftBoundary -= delta;
            }
            rightBoundary = leftBoundary + delta;
        }
        return rightBoundary;
    }

    private boolean isIncreasingFunction(double left, double right) {
        return getFunctionValue(left) < getFunctionValue(right);
    }

    private double getRootByDichotomyMethod(double leftBoundary, double rightBoundary) {
        double middle = (leftBoundary + rightBoundary) / 2;
        if (getFunctionValue(middle) < -epsilon) {
            if (isIncreasingFunction(leftBoundary, rightBoundary)) {
                return getRootByDichotomyMethod(middle, rightBoundary);
            }
            return getRootByDichotomyMethod(leftBoundary, middle);
        }
        if (getFunctionValue(middle) > epsilon) {
            if (isIncreasingFunction(leftBoundary, rightBoundary)) {
                return getRootByDichotomyMethod(leftBoundary, middle);
            }
            return getRootByDichotomyMethod(middle, rightBoundary);
        }
        return middle;
    }

    private List<Double> handleOneRootInInfCase(double initialBoundary) {
        double rightBoundary = getRightBoundary(initialBoundary);
        double leftBoundary =  rightBoundary - delta;

        double root = getRootByDichotomyMethod(leftBoundary, rightBoundary);
        return Collections.singletonList(root);
    }

    private List<Double> handleNonPositiveCase() {
        double functionInTrialValue = getFunctionValue(TRIAL_VALUE);
        if (Math.abs(functionInTrialValue) < epsilon) {
            return Arrays.asList(TRIAL_VALUE);
        }
        return handleOneRootInInfCase(TRIAL_VALUE);
    }

    public static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public List<Double> findRoots() {
        double derivativeB = 2 * a;

        double D = getDiscriminant(DERIVATIVE_A, derivativeB, b);

        if (D > 0) {
            return handlePositiveCase();
        }
        return handleNonPositiveCase();

    }
}
