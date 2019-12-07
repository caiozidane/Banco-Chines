package br.com.senaimt.pessoas;

public class PessoaFisica extends Pessoa{
  private String cpf;
  public void setCpf(String cpf){
      this.cpf = cpf;
  }
  public String getCpf(){
  return cpf;
  }
}
