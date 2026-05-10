import java.util.Scanner;

public class ConsumoAgua {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a população (habitantes): ");
        int populacao = scanner.nextInt();

        System.out.print("Digite o consumo de água (litros por habitante/dia): ");
        double consumoPorHabitante = scanner.nextDouble();

        double consumoTotal = calcularConsumo(populacao, consumoPorHabitante);

        System.out.println("Consumo total diário: " + consumoTotal + " litros/s");

        scanner.close();
    }
    public static double calcularConsumo(int populacao, double consumoPorHabitante) {

        int segundos =  86400;

        return ((populacao * consumoPorHabitante) / 1000)/86400;
    }
}