package CalculoH;

public class CalculoH {

    public static double calcularH(double Q, double k, double n) {

        //condicao do k
        if (k == 0) {
            throw new IllegalArgumentException("K não pode ser zero.");
        }
        //condicao do n
        if (n == 0) {
            throw new IllegalArgumentException("N não pode ser zero.");
        }

        return Math.pow(Q / k, 1.0 / n);
    }
}