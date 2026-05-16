package model;

public class Tabela1 {

  // {W mm, Área/Polegadas, VazaoMin (L/s), VazaoMax (L/s), K, N}
  private static final double[][] tabela = {
      { 76, 3, 0.85, 53.8, 0.1771, 1.5447 },
      { 152, 6, 1.52, 110.4, 0.3812, 1.5300 },
      { 229, 9, 2.55, 251.9, 0.5354, 1.5300 },
      { 305, 10, 3.11, 455.6, 0.6909, 1.5220 },
      { 457, 15, 4.25, 696.2, 1.0560, 1.5380 },
      { 610, 20, 11.89, 936.7, 1.4290, 1.5500 },
      { 915, 30, 17.26, 1426, 2.1840, 1.5666 },
      { 1220, 40, 36.79, 1921, 2.9630, 1.5738 },
      { 1525, 60, 62.80, 2422, 3.7320, 1.5870 }
  };

  public static int defineIndice(double vazao) {
    for (int i = 0; i < tabela.length; i++) {
      double vazaoMinima = tabela[i][2];
      double vazaoMaxima = tabela[i][3];
      if (vazao >= vazaoMinima && vazao <= vazaoMaxima) {
        return i;
      }
    }
    return -1;
  }

  public static double[] retornaValores(int indice) {
    if (indice < 0 || indice >= tabela.length) {
      return null;
    }
    return tabela[indice];
  }

  public static int tamanhoTabela() {
    return tabela.length;
  }
}