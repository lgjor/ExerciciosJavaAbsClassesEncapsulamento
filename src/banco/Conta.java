package banco;

import java.util.Scanner;
import util.ValidaValorDouble;
/**
 * A classe Conta representa uma conta bancária com informações como nome, agência,
 * número da conta e saldo.
 */
public class Conta {
    /** O nome do titular da conta. */
    String nome;
    /** O número da agência da conta. */
    int agencia;
     /** O número da conta. */
    int numeroDaConta;
    /** O saldo da conta. */
    double saldo;
    /** O cheque especial da conta. */
    double LimiteChequeEspecial;
    Scanner scanner = new Scanner(System.in);

    /**
     * Construtor padrão da classe Conta.
     * Inicializa uma nova instância da conta com valores padrão.
     */
    public Conta() {
        // Inicializações padrão, se necessário.
        this.nome = "";
        this.agencia = 0;
        this.numeroDaConta = 0;
        this.saldo = 0.0;
        this.LimiteChequeEspecial = 0;
    }

    /**
     * Lê os dados da conta do usuário através do console.
     *
     * @return A instância da classe Conta com os dados lidos.
     */
    public Conta LeDadosDaConta() {
        System.out.println("Digite seu nome: ");
        this.nome = scanner.next();
        this.agencia = lerAgencia(); // Usando o método de validação
        this.numeroDaConta = lerConta(scanner); // Usando o método de validação 
        this.saldo = ValidaValorDouble.validaValorDouble(scanner, "Digite o saldo: ");
        criaChequeEspecial(this.saldo);
        return this;
    }

    private int lerAgencia() {
        int agencia;
        boolean agenciaValida = false;
        do {
            System.out.println("Digite o número da agência: ");
            String agenciaInput = scanner.next();
            try {
                agencia = Integer.parseInt(agenciaInput);
                if (validarAgencia(agencia)) {
                    agenciaValida = true;
                    return agencia;
                } else {
                    System.out.println("Número de agência inválido. Deve estar entre 1 e 9999.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro entre 1 e 9999..");
            }
        } while (!agenciaValida);
        return -1; // Nunca deve chegar aqui, mas necessário para compilação
    }

    private boolean validarAgencia(int agencia) {
        return agencia > 0 && agencia <= 9999;
    }

    private int lerConta(Scanner scanner) {
        int numeroDaConta;
        boolean contaValida = false;
        do {
            System.out.println("Digite o número da conta: ");
            String contaInput = scanner.next();
            try {
                numeroDaConta = Integer.parseInt(contaInput);
                if (validarConta(numeroDaConta)) {
                    contaValida = true;
                    return numeroDaConta;
                } else {
                    System.out.println("Número de conta inválido. Deve estar entre 1 e 999999.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro entre 1 e 999999.");
            }
        } while (!contaValida);
        return -1; // Nunca deve chegar aqui, mas necessário para compilação
    }

    private boolean validarConta(int numeroDaConta) {
        return numeroDaConta > 0 && numeroDaConta <= 999999;
    }
    /**
     * Método que imprime as informações da conta no console.
     *
     * @param conta A instância da classe Conta a ser impressa.
     */
    public void imprimirConta(Conta conta) {
        System.out.println( "Olá "+ conta.nome +
                            ", obrigado por criar uma conta em nosso banco, sua agência é "+ String.valueOf(conta.agencia) +
                            ", conta "+String.valueOf(conta.numeroDaConta) +
                            " e seu saldo "+ String.valueOf(conta.saldo) +
                            " já está disponível para saque.");
        System.out.println ("Você possui limite de cheque especial de: " + String.valueOf(conta.LimiteChequeEspecial));
    }

    public void criaChequeEspecial(double saldo) {
        if (saldo <= 0) {
            System.out.println("Você não possui cheque especial.");
        } else if (saldo <=500)
            this.LimiteChequeEspecial = 50;
        else {
            this.LimiteChequeEspecial = saldo/2;
        }
    }

    public void consultarSaldo(){
        System.out.println("Seu saldo é: " + this.saldo);
    }

    public void consultarChequeEspecial(){
        System.out.println("Seu limite é: " + this.LimiteChequeEspecial);
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Você depositou: R$" +valor+" seu saldo é: R$" +this.saldo);
    }

    public void sacar(double valor){
        this.saldo -= valor;
        System.out.println("Você sacou: R$" +valor+" seu saldo é: R$" +this.saldo);
    }

    public void pagarBoleto(double valor) {
        double valorChequeEspecial = valor - this.saldo;
        double taxaChequeEspecial = valorChequeEspecial * 0.20;
        if (valor > this.saldo + this.LimiteChequeEspecial - taxaChequeEspecial) {
            System.out.println("Saldo insuficiente para pagar o boleto.");
            return;
        }
        else if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Boleto pago com sucesso!");
        }
        else{
            System.out.println("Deseja usar o valor "+valorChequeEspecial+" do cheque especial pagando a taxa de R$"+taxaChequeEspecial+"? (S/N)");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("S")) {
                this.saldo = 0;
                this.LimiteChequeEspecial -= valorChequeEspecial+taxaChequeEspecial;
                System.out.println("Boleto pago com sucesso!");
                System.out.println("Saldo atual: R$" + this.saldo);
                System.out.println("Limite do cheque especial: R$" + this.LimiteChequeEspecial);
            } else {
                System.out.println("O Boleto não foi pago.");
                return;
            }
            scanner.close();
        }       
    }
}