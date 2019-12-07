package br.com.senaimt.tela;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tela extends JFrame{
 public static void main(String[] args){
    Tela tela = new Tela();
    tela.setTitle("Tela de Login");
    tela.setSize(800, 600);
    tela.setDefaultCloseOperation(
    JFrame.EXIT_ON_CLOSE
    );
    JTextField campo = new JTextField();
    campo.setSize(100, 40);
    tela.add(campo);
    tela.setVisible(true);
 } 
}
