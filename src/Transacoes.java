import java.util.Scanner;

public class Transacoes {
	
	public static void main(String[] args) throws DadosIncorretosClienteException {
		Scanner entrada = new Scanner(System.in);
		String continuar = "S";
			
		while("S".equalsIgnoreCase(continuar)){
			System.out.println("::Transa��es::\n");
			System.out.print("Qual opera��o deseja realizar: \n" +
					"1 - SAQUE\n2- DEP�SITO\n3 - TRANSFER�NCIA\nOp��o escolhida: ");
			String operacao = entrada.nextLine();
			
			ContaCorrente cliente = new ContaCorrente();
			try {
				if(operacao.equals("1")){
					sacar(entrada,cliente); 
				}else if(operacao.equals("2")){
					depositar(entrada, cliente);
				}else if(operacao.equals("3")){
					transferir(entrada, cliente);
				}
			}catch(SaldoInsuficienteException e){
				System.out.println(e.getMessage());
			}catch(ValorInvalidoException e){
				System.out.println(e.getMessage());
			}
			
			System.out.print("Deseja continuar? [S = sim/N = n�o]: ");
			continuar = entrada.nextLine();
		}
	}

	private static void sacar(Scanner entrada, ContaCorrente cliente) throws SaldoInsuficienteException {
		System.out.print("\nValor do saque: ");
		String valorDoSaque = entrada.nextLine();
		double valorSaque = Double.parseDouble(valorDoSaque);
		cliente.sacar(valorSaque);
		System.out.println("Saldo cliente: "+ cliente.getSaldo());
	}

	private static void depositar(Scanner entrada, ContaCorrente cliente) throws SaldoInsuficienteException, ValorInvalidoException {
		System.out.print("\nValor do dep�sito: ");
		String valorDoDeposito = entrada.nextLine();
		double valorDeposito = Double.parseDouble(valorDoDeposito);
		cliente.depositar(valorDeposito);
		System.out.println("Saldo cliente: "+ cliente.getSaldo());
	}
	
	private static void transferir(Scanner entrada, ContaCorrente cliente) throws SaldoInsuficienteException, DadosIncorretosClienteException, ValorInvalidoException {
		System.out.print("\nValor da tranfer�ncia: ");
		String valorDaTranferencia = entrada.nextLine();
		double valorTranferencia = Double.parseDouble(valorDaTranferencia);
		System.out.print("N�mero da conta: ");
		String contaDestino = entrada.nextLine();
		System.out.print("N�mero da Ag�ncia: ");
		String agenciaDestino = entrada.nextLine();			
		
		ContaCorrente destino = new ContaCorrente();
		destino.setNumeroDaConta(contaDestino);
		destino.setNumeroDaAgencia(agenciaDestino);
		
		cliente.tranferir(destino, valorTranferencia);
		System.out.println("Saldo cliente: "+ cliente.getSaldo());
		System.out.println("Saldo destinat�rio: "+ destino.getSaldo());
	}
}
