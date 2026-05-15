package Consumo;

public class ConsumoAgua {
    public static double calcularConsumo(int populacao, double consumoPorHabitante) {
        int segundos = 86400;
        return (populacao * consumoPorHabitante) / segundos;
    }
}