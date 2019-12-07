package br.com.senaimt.contas;

public class ContaCorrente extends Conta {
  
    @Override
    public void sacar(double valor){
       if(getSaldo() >= valor){
       setSaldo(getSaldo() - valor);
       }
    }
}
