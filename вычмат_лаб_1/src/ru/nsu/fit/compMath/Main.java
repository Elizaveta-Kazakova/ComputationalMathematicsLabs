package ru.nsu.fit.compMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            double epsilon = Double.parseDouble(reader.readLine());
            double delta = Double.parseDouble(reader.readLine());
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());
            EquationCalculator calculator = new EquationCalculator(epsilon, delta, a, b, c);
            List<Double> roots = calculator.findRoots();
            System.out.println(roots.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
