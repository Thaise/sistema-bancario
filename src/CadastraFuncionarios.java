import java.util.ArrayList;
import java.util.Scanner;

public class CadastraFuncionarios {

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarioLista = new ArrayList<Funcionario>();
		Scanner entrada = new Scanner(System.in);

		String nome = "";
		String rg = "";
		String data = "";
		double salario = 0;
		int cargo = 0;
		String continuar = "S";
		Funcionario novoFuncionario;

		while (continuar.equalsIgnoreCase("s")) {
			try {
				System.out.print("Cargo (1 - presidente / 2 - gerente): ");
				String cargoString = entrada.nextLine();
				cargo = Integer.parseInt(cargoString);

				if (cargo == 1) {
					novoFuncionario = new Presidente();
				} else {
					novoFuncionario = new Gerente();
				}

				System.out.print("Nome: ");
				nome = entrada.nextLine();
				novoFuncionario.setNome(nome);

				System.out.print("RG: ");
				rg = entrada.nextLine();
				novoFuncionario.setRg(rg);

				System.out.print("Data de contratação: ");
				data = entrada.nextLine();
				novoFuncionario.setDataDeEntradaBanco(data);

				System.out.print("Salário: ");
				String salarioString = entrada.nextLine();
				salario = Double.parseDouble(salarioString);
				novoFuncionario.setSalario(salario);

				novoFuncionario.getBonificacao();
				funcionarioLista.add(novoFuncionario);

			} catch (DadosIncorretosFuncionarioException e) {
				System.out.println(e.getMessage());
			}

			System.out.print("Deseja continuar? [S = sim/N = não]: ");
			continuar = entrada.nextLine();
		}

		for (int i = 0; i < funcionarioLista.size(); i++) {
			Funcionario funcionarios = funcionarioLista.get(i);
			funcionarios.mostraDadosFuncionario();
		}
	}
}
