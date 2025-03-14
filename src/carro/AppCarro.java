package carro;

public class AppCarro {

    public AppCarro(){
    }

    public static void main(String[] args) {
        Carro carro = new Carro();
        if (!carro.getLigado()) 
            System.out.println("Carro desligado");
        carro.virar("esquerda");
        carro.setLigado(true);
        carro.virar("esquerda");
        carro.acelerar();
        carro.virar("esquerda");
        carro.incrementaMarcha();
        carro.acelerar();
        // testes ok
    }
}
