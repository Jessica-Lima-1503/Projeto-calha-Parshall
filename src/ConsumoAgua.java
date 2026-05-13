import java.util.Arrays;
import java.util.Scanner;

import static Tabela1.CalculoTabela1.defineIndice;
import static Tabela1.CalculoTabela1.retornaValores;


public class ConsumoAgua {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a população (habitantes): ");
        // int populacao = scanner.nextInt();
        int populacao = 70000;

        System.out.print("Digite o consumo de água (litros por habitante/dia): ");
        // double consumoPorHabitante = scanner.nextDouble();
        int consumoPorHabitante = 160;

        double vazaoQ = calcularConsumo(populacao, consumoPorHabitante);

        System.out.println("Consumo total diário: " + vazaoQ + " litros/s");

        scanner.close();

        double[] itemTabela = retornaValores(defineIndice(vazaoQ));


    }

    public static double calcularConsumo(int populacao, double consumoPorHabitante) {
        int segundos = 86400;
        // int metrosParaLitros;

        return (populacao * consumoPorHabitante) / segundos;
    }


}