package CalculoH;

public class CalculoH {

    public static double calcularH(double Q, double k, double N) {

        if (k == 0) {
            throw new IllegalArgumentException("k não pode ser zero.");
        }

        if (N == 0) {
            throw new IllegalArgumentException("N não pode ser zero.");
        }

        return Math.pow(Q / k, 1.0 / N);
    }

    public static void main(String[] args) {

        double Q = 100;
        double k = 5;
        double N = 2;

        double H = calcularH(Q, k, N);

        System.out.println("Resultado de H = " + H);
    }
}
