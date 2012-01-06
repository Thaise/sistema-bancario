
abstract class Funcionario {

	private String nome;
	private String rg;
	private double salario;
	private String dataEntradaBanco;
	private int id;
	
	public static int incrementaId = 1;
	
	public Funcionario(){
		this.id = incrementaId++;
	}
	
	public void setNome(String nome) throws DadosIncorretosFuncionarioException{
		if(nome.equals("")){
			throw new DadosIncorretosFuncionarioException("O nome deve ser preenchido.");
		}else{
			this.nome = nome;	
		}
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getId(){
		return id;
	}
	
	public void setRg(String rg) throws DadosIncorretosFuncionarioException{
		if(rg.length() > 10 || rg.length() < 7  || rg.equals("")){
			throw new DadosIncorretosFuncionarioException("O RG deve ter no máximo 10 dígitos."); 
		}else{
			this.rg = rg;
		}	
	}
	
	public String getRg(){
		return rg;
	}
	
	public void setDataDeEntradaBanco(String dataEntradaBanco){
		this.dataEntradaBanco = dataEntradaBanco;
	}
	
	public String getDataDeEntradaBanco(){
		return dataEntradaBanco;
	}
	
	public void setSalario(double salario) throws DadosIncorretosFuncionarioException{
		if(salario > 10000 || salario < 3000){
			throw new DadosIncorretosFuncionarioException("O salário deve estar entre R$545,00 e R$10.000,00."); 
		}else{
			this.salario = salario;	
		}
	}
	
	public double getSalario(){
		return salario;
	}
	
	abstract double getBonificacao();
	
	abstract void mostraCargo();
	
	public void mostraDadosFuncionario(){
		System.out.println("\nNome: "+nome);
		System.out.println("ID: "+id);
		System.out.println("RG: "+rg);
		System.out.println("Data de entrada: "+dataEntradaBanco);
		System.out.println("Salario: "+salario);
		System.out.println("Bonificação: "+getBonificacao());
		mostraCargo();
	}
	
}
