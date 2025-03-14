package carro;

public class Carro {
    private boolean ligado = false;
    private double velocidade = 0;
    private int marcha = 0;
    private int[] velocidadesMinimas = {0, 0, 21, 41, 61, 81, 101};
    private int[] velocidadesMaximas = {0, 20, 40, 60, 80, 100, 120};
    boolean velocidadeMaxima = true;
    boolean velocidadeMinima = true;
    public Carro(){
        ligado = false;
    }
    //getters and setters

    public boolean getLigado() {
        return ligado;    
    }

    public boolean setLigado(boolean status) {
        this.ligado = status;
        if (status)
            System.out.println("Carro ligado");
        else if (marcha + velocidade == 0)
            System.out.println("Carro desligado");
        else
            System.out.println("Carro não pode ser desligado . Marcha: "+marcha+" Velocidade: "+velocidade);
        return ligado;
    }

    public boolean setVelocidadeMaxima(){
        if (velocidade == velocidadesMaximas[marcha]){
            System.out.println("Velocidade máxima atingida");	
            velocidadeMaxima = true;
            return velocidadeMaxima;
        } 
        velocidadeMaxima = false;
        return velocidadeMaxima;
    }

    public boolean setVelocidadeMinima(){
        if (velocidade == velocidadesMinimas[marcha]){
            System.out.println("Velocidade mínima atingida");	
            velocidadeMinima = true;
            return velocidadeMinima;
        } 
        velocidadeMinima = false;
        return velocidadeMinima;
    }
 
    public boolean isCarroParado(){
        if (marcha==0 || velocidade==0)
            return true;
        return false;
    }

    public void acelerar(){
        if (isCarroParado() && marcha==0){
            System.err.println("Carro parado em ponto morto, mude a marcha antes de acelerar.");
            return;
        }
        else if (!velocidadeMaxima) {
            System.out.println("Acelerando em 1 km/h");
            velocidade +=1;
            imprimeMarcha();
            imprimeVelocidade();
            setVelocidadeMaxima();
            setVelocidadeMinima();
            return;
        }
        System.err.println("Velocidade máxima atingida, mude a marcha antes de acelerar");
        return;
    }

    public void frear(){
        if (isCarroParado() && marcha==0){
            System.err.println("Carro parado, ponto morto.");
            return;
        }
        else if (!velocidadeMinima) {
            System.out.println("Freando em 1 km/h");
            velocidade -=1;
            imprimeMarcha();
            imprimeVelocidade();
            setVelocidadeMaxima();
            setVelocidadeMinima();
            return;
        } else if (velocidade == 0){
            System.err.println("Carro parado");
            return;
        }
        else {
            System.out.println("Velocidade mínima atingida, mude a marcha para frear");
        }
    }
    

    public void incrementaMarcha(){
        if (marcha < 6) {
            this.marcha +=1;
            setVelocidadeMaxima();
            setVelocidadeMinima();
            System.out.println("Passando para a marcha "+marcha);
            return;    
        }
        System.out.println("Marcha máxima atingida");
        return;
    }

    public void decrementaMarcha(){
        if (marcha > 0) {
            this.marcha -=1;
            setVelocidadeMaxima();
            setVelocidadeMinima();
            System.out.println("Diminuiu para a marcha "+marcha);
            return;
        }
        System.out.println("Marcha mínima "+marcha+" atingida");
    }

    public void virar(String lado){
        if (velocidade == 0){
            System.out.println("Carro parado, não é possível virar");
            return;
        }
        else if (velocidade > 0 && velocidade <=40){
            System.out.println("Virando para "+lado);
            return;
        }
        else{
            System.out.println("Velocidade muito alta, não é possível virar");
        }
    }

    public void imprimeMarcha(){
        System.out.println("Marcha "+marcha);
    }

    public void imprimeVelocidade(){
        System.out.println("Velocidade "+velocidade);
    }
}