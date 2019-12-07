package teste;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TratamentoExcecao {
 public static void main(String[] args){
  double x = 100;
  double z = 0;
  double k = x / z; 
 // System.out.println(k);
 String nome = null;
 System.out.println("Nome " + nome); 
 try{
 Aluno a = null;
 System.out.println(a.getNome());
 }catch(Exception e){
 System.out.println("Sem objeto dispo.");
  //e.printStackTrace();
 }
 try{
 File arquivo = new File("arquivo.txt");
 FileWriter escritor = new FileWriter(arquivo);
 escritor.write("Nome: Mateus");
 escritor.close();
 }catch(IOException ex){
 System.out.println("Não foi possível escre.");
 }
 
 }  
}// fim classe
class Aluno{
    String nome;
    public String getNome(){
    return nome;
    }
    public void setNome(String nome){
     this.nome = nome;
    }
}
