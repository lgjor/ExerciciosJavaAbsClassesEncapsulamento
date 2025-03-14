package banco;

/**
 * A classe ContaTerminal é a classe principal que inicia o aplicativo de conta bancária.
 */

public class ContaTerminal {

    /**
     * Construtor padrão da classe ContaTerminal.
     * Inicializa uma nova instância da classe.
     */
    public ContaTerminal() {
        // Inicializações padrão, se necessário.
    }
    
    /**
     * Cria e retorna uma nova instância da classe Conta.
     *
     * @return Uma nova instância da classe Conta.
     */
    public Conta criarConta() {
        // Inicializações padrão, se necessário.
        Conta conta = new Conta();
        return conta;
    }
    /**
     * O método principal que cria uma instância da classe Conta, lê os dados da conta
     * do usuário e imprime as informações da conta no console.
     *
     * @param args Os argumentos da linha de comando (não utilizados neste aplicativo).
     * @throws Exception Se ocorrer um erro durante a leitura dos dados da conta.
     */
     public static void main(String[] args) throws Exception {

        ContaTerminal contaTerminal = new ContaTerminal();
        Conta conta = contaTerminal.criarConta();
        conta.LeDadosDaConta();
        conta.imprimirConta(conta);
        conta.consultarSaldo();
        conta.consultarChequeEspecial();
        conta.depositar(100);
        conta.sacar(50);
        conta.pagarBoleto(180);
    }
}

