 
public class Gerente extends Funcionario{
	
	public double getBonificacao(){
		return getSalario() * 0.10 + 1000;
	}

	@Override
	void mostraCargo() {
		System.out.println("Cargo: Gerente");
		
	}


}
