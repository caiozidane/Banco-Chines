package br.com.senaimt.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {
   public static void main(String[] args){
    try {
    String sql = "insert into cliente(nome, cpf) values"
             + "('joao', 1232132)";
    Conexao conexao = new Conexao();
    Statement st = 
    conexao.getConexao().createStatement();
    st.execute(sql);
 conexao.desconectar();
 Conexao conexao2 = new Conexao();
 String sqlPrepared =
 "insert into cliente(nome, cpf) values(?,?)";
 PreparedStatement ps =  
 conexao2.getConexao().prepareStatement(sqlPrepared);
 ps.setString(1, "Marcos");
 ps.setString(2, "1234567");
 ps.execute();
 ps.close();
 conexao2.desconectar();
Conexao conexao3 = new Conexao();
String consulta = "select * from cliente";
Statement st2 =
conexao3.getConexao().createStatement();
ResultSet dados = st2.executeQuery(consulta);   
while(dados.next()){
System.out.println("Nome: "+
        dados.getString("nome"));
System.out.println("CPF: "
        +dados.getString("cpf"));
System.out.println("------");
} 
conexao3.desconectar(); 
} catch (SQLException ex) {
  ex.printStackTrace(); 
}
   
   
   } 
}
