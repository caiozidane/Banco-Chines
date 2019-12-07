package br.com.senaimt.contas;

public abstract class Conta {
  private double saldo;
  public abstract void sacar(double valor);  
  public void depositar(double valor){
      this.saldo += valor;
  }
  public double getSaldo(){
  return  saldo;
  }
  public void setSaldo(double valor){
      this.saldo = valor;
  }
}
