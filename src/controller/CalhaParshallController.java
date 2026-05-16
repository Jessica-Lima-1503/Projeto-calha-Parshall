package controller;

import model.CalhaParshall;
import model.Tabela1;
import model.Tabela2;

public class CalhaParshallController {

  // Calcula vazão em L/s a partir de população e consumo per capita (L/dia)
  public double calcularVazao(int populacao, double consumoPorHabitante) {
    int segundosPorDia = 86400;
    return (populacao * consumoPorHabitante) / segundosPorDia;
  }

  // Calcula Ha em metros: Ha = (Q_m3s / K) ^ (1/n)
  private double calcularH(double vazaoM3s, double k, double n) {
    if (k == 0)
      throw new IllegalArgumentException("K não pode ser zero.");
    if (n == 0)
      throw new IllegalArgumentException("N não pode ser zero.");
    return Math.pow(vazaoM3s / k, 1.0 / n);
  }

  // Retorna o índice inicial na Tabela 1 para a vazão fornecida
  public int definirIndiceInicial(double vazaoLs) {
    return Tabela1.defineIndice(vazaoLs);
  }

  // Tenta aprovar a calha a partir do índice informado.
  // Retorna o resultado (aprovado ou não) para aquele índice.
  public CalhaParshall tentarAprovar(double vazaoLs, int indice) {
    double[] dados = Tabela1.retornaValores(indice);

    double k = dados[4];
    double n = dados[5];
    int chave = (int) dados[1]; // chave para buscar E na Tabela 2

    double vazaoM3s = vazaoLs / 1000.0;
    double hMetros = calcularH(vazaoM3s, k, n);
    double hEmCm = hMetros * 100.0;

    double eEmCm = Tabela2.pegarE(chave);

    return new CalhaParshall(vazaoLs, k, n, hEmCm, eEmCm, indice);
  }

  public int tamanhoTabela() {
    return Tabela1.tamanhoTabela();
  }
}