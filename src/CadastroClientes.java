import java.util.ArrayList;
import java.util.Scanner;

public class CadastroClientes {

	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		System.out.println("::Cadastro de correntistas::\n");
			
		ContaCorrente contaCorrenteObjeto;//declarando o objeto contaCorrente;
		String nome;
		String endereco;
		String telefone;
		String cpf;
		String conta;
		String agencia;
		String continuar = "S";
		ArrayList<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
		
		while("S".equalsIgnoreCase(continuar)){
			try{
				contaCorrenteObjeto = new ContaCorrente();
				System.out.print("Titular: ");
				nome = entrada.nextLine();
				contaCorrenteObjeto.cliente.setNome(nome);
				System.out.print("Endere�o: ");
				endereco = entrada.nextLine();
				contaCorrenteObjeto.cliente.setEndereco(endereco);
				System.out.print("Telefone com DDD(sem o zero): ");
				telefone = entrada.nextLine();
				contaCorrenteObjeto.cliente.setTelefone(telefone);
				System.out.print("CPF: ");
				cpf = entrada.nextLine();
				contaCorrenteObjeto.cliente.setCpf(cpf);
				System.out.print("N�mero da conta: ");
				conta = entrada.nextLine();
				contaCorrenteObjeto.setNumeroDaConta(conta);
				System.out.print("N�mero da ag�ncia: ");
				agencia = entrada.nextLine();
				contaCorrenteObjeto.setNumeroDaAgencia(agencia);
		
				contasCorrentes.add(contaCorrenteObjeto);
				
			}catch(DadosIncorretosClienteException e){
				System.out.println(e.getMessage());
			}
			System.out.print("Deseja continuar? [S = sim/N = n�o]: ");
			continuar = entrada.nextLine();
		}
			
		for (int i = 0; i < contasCorrentes.size(); i++) {
			ContaCorrente contaDoCliente = contasCorrentes.get(i);//cria uma nove vari�vel para armazenar cada conta corrente
			contaDoCliente.mostraCliente();	 		
		}
		
		System.out.println("\nTotal de contas: "+ContaCorrente.getTotalDeContas());

	}

}
