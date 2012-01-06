
public class ContaCorrente {
	
	private static int totalDeContas;
	
	Cliente cliente = new Cliente();
	private String numeroDaConta;
	private String numeroDaAgencia;
	private double saldo;
	private double limite = 100;
	
	public ContaCorrente(){
		ContaCorrente.totalDeContas += 1;
	}
	
	public static int getTotalDeContas(){
		return ContaCorrente.totalDeContas;
	}
	
	public void setNumeroDaConta(String numero){
		numeroDaConta = numero;
	}
	
	public void setNumeroDaAgencia(String numero){
		numeroDaAgencia = numero;
	}
	
	public void sacar(double valor) throws SaldoInsuficienteException{
		if(valor > saldo + limite){		
			throw new SaldoInsuficienteException("Saldo insufiente!");
		}else{
			saldo -= valor;
		}	
	}
	
	public void depositar(double valor) throws ValorInvalidoException{
		if(valor > 0){
			saldo += valor;
		}else{
			throw new ValorInvalidoException("Não é possível depositar um valor negativo!");
		}
	}
	
	public void tranferir(ContaCorrente destino, double valor) throws SaldoInsuficienteException, ValorInvalidoException{
		this.sacar(valor);
		destino.depositar(valor);	
	}

	public double getSaldo(){
		return saldo + limite;
	}
		
	public void mostraCliente(){
		System.out.println("\nNome: "+cliente.getNome());
		System.out.println("Endereço: "+cliente.getEndereco());
		System.out.println("Telefone: "+cliente.getTelefone());
		System.out.println("CPF: "+cliente.getCpf());
		System.out.println("Conta: "+numeroDaConta);
		System.out.println("Agência: "+numeroDaAgencia);
	}
}
