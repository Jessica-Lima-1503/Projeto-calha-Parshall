package model;

public class Tabela2 {

  // {Polegadas/Pés (×10), E (cm)}
  private static final double[][] tabela = {
      { 1, 22.9 },
      { 3, 38.1 },
      { 6, 45.7 },
      { 9, 61.0 },
      { 10, 91.5 },
      { 15, 91.5 },
      { 20, 91.5 },
      { 30, 91.5 },
      { 40, 91.5 },
      { 60, 91.5 },
      { 70, 91.5 },
      { 80, 91.5 },
      { 100, 122.0 }
  };

  public static double pegarE(int chave) {
    for (int i = 0; i < tabela.length; i++) {
      if (tabela[i][0] == chave) {
        return tabela[i][1];
      }
    }
    return -1;
  }
}