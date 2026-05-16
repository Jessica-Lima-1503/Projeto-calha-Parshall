package model;

public class CalhaParshall {

  private double vazaoLs; // L/s
  private double k;
  private double n;
  private double hEmCm; // altura da lâmina d'água em cm
  private double eEmCm; // altura da borda da calha em cm
  private double limite70; // 70% de E em cm
  private boolean aprovada;
  private int indiceTabela;

  public CalhaParshall(double vazaoLs, double k, double n,
      double hEmCm, double eEmCm, int indiceTabela) {
    this.vazaoLs = vazaoLs;
    this.k = k;
    this.n = n;
    this.hEmCm = hEmCm;
    this.eEmCm = eEmCm;
    this.limite70 = eEmCm * 0.70;
    this.aprovada = hEmCm < this.limite70;
    this.indiceTabela = indiceTabela;
  }

  public double getVazaoLs() {
    return vazaoLs;
  }

  public double getK() {
    return k;
  }

  public double getN() {
    return n;
  }

  public double getHEmCm() {
    return hEmCm;
  }

  public double getEEmCm() {
    return eEmCm;
  }

  public double getLimite70() {
    return limite70;
  }

  public boolean isAprovada() {
    return aprovada;
  }

  public int getIndiceTabela() {
    return indiceTabela;
  }
}