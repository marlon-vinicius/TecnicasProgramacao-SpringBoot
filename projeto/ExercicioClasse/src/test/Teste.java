package test;

import implement.Colaborador;
import implement.Parceiro;

public class Teste {

    public static void main(String[] args) {
        Colaborador c1 = new Colaborador();

        c1.setBairro("centro");

        Parceiro p1 = new Parceiro();
        p1.setBairro("Tião");

        System.out.println("Bairro: " + c1.getBairro());        
        System.out.println("Bairro: " + p1.getBairro());        
    }
}
