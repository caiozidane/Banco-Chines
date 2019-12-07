package br.com.senaimt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private Connection connection;
  String url = "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=GMT";
  String usuario = "root";
  String senha =  "";
  public void conectar(){
  try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 connection = 
 DriverManager.getConnection(url, usuario, senha);
  } catch (ClassNotFoundException ex) {
    ex.printStackTrace();
  }catch (SQLException ex) {
    ex.printStackTrace();
 }
}  
  public Connection getConexao(){
      if(connection == null){
         conectar();
      }
      return connection;
  } 
  public void desconectar(){
      try {
          connection.close();
       System.out.println("Desconectado.");  
      } catch (SQLException ex) {
          ex.printStackTrace();
    }
  }
}
