package view;

import controller.CalhaParshallController;
import model.CalhaParshall;

import java.util.Scanner;

public class CalhaParshallView {

  private final CalhaParshallController controller;
  private final Scanner scanner;

  public CalhaParshallView() {
    this.controller = new CalhaParshallController();
    this.scanner = new Scanner(System.in);
  }

  public void iniciar() {
    System.out.println("\nCÁLCULO CALHA PARSHALL");

    // 1. Entrada de dados
    System.out.print("\nDigite a população: ");
    int populacao = scanner.nextInt();

    System.out.print("Digite o consumo por habitante (L/dia): ");
    double consumoPorHabitante = scanner.nextDouble();

    // 2. Calcular vazão
    double vazaoLs = controller.calcularVazao(populacao, consumoPorHabitante);
    System.out.printf("%nVazão calculada: %.4f L/s%n", vazaoLs);

    // 3. Localizar índice inicial na tabela
    int indice = controller.definirIndiceInicial(vazaoLs);

    if (indice == -1) {
      System.out.println("Nenhuma calha encontrada na tabela para essa vazão.");
      scanner.close();
      return;
    }

    // 4. Loop de tentativas
    boolean aprovada = false;

    while (!aprovada) {
      CalhaParshall resultado = controller.tentarAprovar(vazaoLs, indice);

      exibirResultado(resultado);

      if (resultado.isAprovada()) {
        System.out.printf("%nH (%.2f cm) < 70%% de E (%.2f cm) --> APROVADA%n",
            resultado.getHEmCm(), resultado.getLimite70());
        aprovada = true;

      } else {
        System.out.printf("%nH (%.2f cm) >= 70%% de E (%.2f cm) --> REPROVADA%n",
            resultado.getHEmCm(), resultado.getLimite70());
        System.out.println("Recalculando com calha maior...");

        if (indice < controller.tamanhoTabela() - 1) {
          indice++;
        } else {
          System.out.println("Não há mais opções na tabela. Não é possível aprovar a calha Parshall.");
          break;
        }
      }
    }

    scanner.close();
  }

  private void exibirResultado(CalhaParshall resultado) {
    System.out.println("\n--- RESULTADOS ---");
    System.out.printf("Índice da Tabela 1 : %d%n", resultado.getIndiceTabela());
    System.out.printf("K                  : %.4f%n", resultado.getK());
    System.out.printf("N                  : %.4f%n", resultado.getN());
    System.out.printf("H                  : %.2f cm%n", resultado.getHEmCm());
    System.out.printf("E                  : %.2f cm%n", resultado.getEEmCm());
  }
}