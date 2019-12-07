package br.com.senaimt.tablemodel;

import br.com.senaimt.pessoas.PessoaFisica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPF 
        extends AbstractTableModel{ 
  private List<PessoaFisica> dados;
  private String[] colunas = {"codigo", "nome", "cpf"};  
   public TableModelPF(){
     dados = new ArrayList<>();
   } 
public void addPessoaFisica(PessoaFisica pf){
     dados.add(pf);
     //Atualiza a tabela...
     this.fireTableDataChanged();
 }
public void removePessoaFisica(PessoaFisica pf){
     dados.remove(pf);
     this.fireTableDataChanged();
 }
public void addPessoas(List<PessoaFisica>
        pessoas){
 dados.addAll(pessoas);
 this.fireTableDataChanged();
}
public List<PessoaFisica> getPessoasFisicas(){
        return dados;
}
public PessoaFisica getPessoa(int indice){
    return dados.get(indice);
}
    @Override // retorna numero de registros
    public int getRowCount() {
        return dados.size();
    }
    @Override//retorna numero de colunas
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public Object getValueAt(int linha, int coluna) {
            switch(coluna){
            case 0: 
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getNome();
            case 2: 
                return dados.get(linha).getCpf();
            default:
                return null;
        }
    }
 
}
