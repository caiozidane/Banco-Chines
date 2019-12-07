package br.com.senaimt.dao;

import br.com.senaimt.database.Conexao;
import br.com.senaimt.pessoas.PessoaFisica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientePFDAO {
private static final String SQL_INSERT =
"insert into cliente(nome, cpf)"
        + " values(?,?)";  
private static final String SQL_UPDATE = "update cliente set nome = ?, cpf = ? where id = ?";
private static final String SQL_DELETE = "delete from cliente where id = ?";
private static final String SQL_SELECT = "select * from cliente";
private static final String SELECT_POR_ID = "select * from cliente where id = ?";
PreparedStatement psInsert, psUpdate, psSelectPorCodigo, psSelect, psDelete;
public ClientePFDAO(){
    try {
Conexao conexao = new Conexao();
psInsert = conexao.getConexao().prepareStatement(SQL_INSERT);
psSelect = conexao.getConexao().prepareStatement(SQL_SELECT);
psUpdate = conexao.getConexao().prepareStatement(SQL_UPDATE);
psSelectPorCodigo = conexao.getConexao().prepareStatement(SELECT_POR_ID);
psDelete = conexao.getConexao().prepareStatement(SQL_DELETE);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
   }
public void inserir(PessoaFisica pf){
try{
  //Troca os ? pelos dados  
  psInsert.setString(1, pf.getNome());
  psInsert.setString(2, pf.getCpf());
  //Executa a consulta
  psInsert.execute();
   }catch(SQLException e){
       e.printStackTrace();
   }
}
public void alterar(PessoaFisica pf){
try{
psUpdate.setString(1, pf.getNome());
psUpdate.setString(2, pf.getCpf());
psUpdate.setInt(3, pf.getCodigo());
psUpdate.executeUpdate();
}catch(SQLException e){
e.printStackTrace();
  }
}
public void excluir(int codigo){
try{
psDelete.setInt(1, codigo);
psDelete.execute();
}catch(SQLException e){
    e.printStackTrace();
 }
}
public ArrayList getClientesPF(){
ArrayList<PessoaFisica> pessoas 
        =new ArrayList<>();
try{
ResultSet result = psSelect.executeQuery();
PessoaFisica pf;
while(result.next()){
pf = new PessoaFisica();
pf.setCodigo(result.getInt(1));
pf.setNome(result.getString(2));
pf.setCpf(result.getString(3));
pessoas.add(pf);
}
}catch(SQLException e){
    e.printStackTrace();
}
return pessoas;
}



public PessoaFisica getClientePorCodigo(int codigo){
   PessoaFisica pf = new PessoaFisica();
    try {   
        psSelectPorCodigo.setInt(1, codigo);
        ResultSet result =
                psSelectPorCodigo.executeQuery();  
        if(result.next()){
         pf.setCodigo(result.getInt(1));
         pf.setNome(result.getString(2));
         pf.setCpf(result.getString(3));
        } 
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return pf;
}

}// fim

